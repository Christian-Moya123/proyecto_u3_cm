package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.management.RuntimeErrorException;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.ICuentaBancariaRepository;
import com.uce.edu.demo.repository.ITransferenciaRepository;
import com.uce.edu.demo.repository.modelo.CuentaBancaria;
import com.uce.edu.demo.repository.modelo.Transferencia;

@Service
public class TransferenciaServiceImpl implements ITransferenciaService{
	
	@Autowired
	private ICuentaBancariaRepository bancariaRepositoru;
	
	@Autowired
	private ITransferenciaRepository iTransferenciaRepositori;

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void realizarTransferencia(String numeroctaOrigen, String numeroctaDestino, BigDecimal monto) {
		// TODO Auto-generated method stub
		//0. buscar la cuentaa origen
		CuentaBancaria ctaOrigen = this.bancariaRepositoru.buscarPorNumero(numeroctaOrigen);
		//1. Rerstar el monto a la cuenta origen
		BigDecimal saldoOrigen = ctaOrigen.getSaldo(); 
		BigDecimal saldoFinal = saldoOrigen.subtract(monto);
		ctaOrigen.setSaldo(saldoFinal);
		this.bancariaRepositoru.actualizar(ctaOrigen);
		
		//0. buscar la cuentaa destino
		CuentaBancaria ctaDestino = this.bancariaRepositoru.buscarPorNumero(numeroctaDestino);

		//2. Sumar el monto a la cuenta destino
		ctaDestino.setSaldo(ctaDestino.getSaldo().add(monto));
		this.bancariaRepositoru.actualizar(ctaDestino);
	
		//3. Insertar a ala transferencia
		Transferencia trans = new Transferencia();
		trans.setFecha(LocalDateTime.now());
		trans.setMonto(monto);
		//trans.setMonto(null);//prara provocar un error intencional
		trans.setCuentaOrigen(ctaOrigen);
		trans.setCuentaDestino(ctaDestino);
		this.iTransferenciaRepositori.insertar(trans);
		
//		if(ctaOrigen.getSaldo().equals("Ahorros")) {
	//		throw new RuntimeException();
		//}
		if(monto.compareTo(saldoOrigen)>0) {
			throw new RuntimeException();
			
		}
		
		
		
		
		
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void realizarTransferenciaFachada(String ctaOrigen, String ctaDestino, BigDecimal monto) {
		// TODO Auto-generated method stub
		this.realizarTransferencia(ctaOrigen, ctaDestino, monto);
	}

	@Override
	public Transferencia buscar(Integer id) {
		// TODO Auto-generated method stub
		   return this.iTransferenciaRepositori.buscar(id);
	}

}
