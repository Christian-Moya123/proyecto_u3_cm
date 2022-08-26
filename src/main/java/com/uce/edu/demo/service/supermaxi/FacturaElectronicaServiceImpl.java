package com.uce.edu.demo.service.supermaxi;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.modelo.factura.FacturaElectronica;
import com.uce.edu.demo.repository.supermaxi.IFacturaElectronicaRepository;

@Service
public class FacturaElectronicaServiceImpl implements IFacturaElectronicaService{
	@Autowired
	private IFacturaElectronicaRepository facturaElectronicaRepository;
	
	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void procesarElectronica(String numero, Integer cantidadItems, BigDecimal monto) {
		// TODO Auto-generated method stub
		FacturaElectronica electronica = new FacturaElectronica();
		electronica.setNumero(numero);
		electronica.setFecha(LocalDateTime.now());
		electronica.setNumeroItems(cantidadItems);
		electronica.setMonto(monto);
		
		this.facturaElectronicaRepository.insertar(electronica);
		throw new RuntimeException();
	}

}
