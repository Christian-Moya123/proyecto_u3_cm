package com.uce.edu.demo.service.supermaxi;

import java.math.BigDecimal;

public interface IFacturaElectronicaService {
	public void procesarElectronica(String numero, Integer cantidadItems, BigDecimal monto );
	

}
