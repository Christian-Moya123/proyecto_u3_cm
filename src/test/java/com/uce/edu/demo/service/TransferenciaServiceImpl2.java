package com.uce.edu.demo.service;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import javax.transaction.Transactional;

import org.jboss.logging.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.junit.jupiter.api.Test;

import com.uce.edu.demo.ProyectoU3CmApplication;
import com.uce.edu.demo.repository.modelo.Transferencia;

@SpringBootTest
@Rollback(true)
@Transactional
class TransferenciaServiceImpl2 {

	private static Logger logger = Logger.getLogger(ProyectoU3CmApplication.class);
	
	
	@Autowired
	private ITransferenciaService transferenciaService;
	
	@Test
	 void testRealizarTransferencia() {
		Transferencia t = this.transferenciaService.buscar(5);
		BigDecimal ivaEncontrado = t.getMonto().divide(new BigDecimal(12));
		logger.info(ivaEncontrado);
		BigDecimal ivaEsperado = new BigDecimal("1.00");
		logger.info(ivaEsperado);
		assertEquals(ivaEncontrado, ivaEsperado);
	}
}
