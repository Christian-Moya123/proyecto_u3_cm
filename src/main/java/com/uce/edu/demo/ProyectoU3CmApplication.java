package com.uce.edu.demo;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.modelo.factura.Factura;
import com.uce.edu.demo.repository.modelo.Hotel;
import com.uce.edu.demo.service.IHotelService;
import com.uce.edu.demo.taller27.cajero.service.IFacturaService;

@SpringBootApplication
public class ProyectoU3CmApplication implements CommandLineRunner{
	
	private static Logger logger = Logger.getLogger(ProyectoU3CmApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3CmApplication.class, args);
	}

	@Autowired
	private IHotelService hotelService;
	
	@Autowired
	private IFacturaService facturaService;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
	/*	List<Hotel> listaHoteles = this.hotelService.buscarHotelInnerJoin("ffamiliar");
		
		for (Hotel h: listaHoteles) {
			logger.info("Hotel: " + h.getNombre()+" "+ h.getDireccion());
		}
		
		
		List<Hotel> listaHotelesLefth = this.hotelService.buscarHotelOuterJoinLefht("Familiar");
		
		for (Hotel h: listaHotelesLefth) {
			logger.info("Hotel: " + h.getNombre()+" "+ h.getDireccion());
		}
		
		List<Hotel> listaHotelesRight = this.hotelService.buscarHotelOuterJoinRigth("Familiar");
		
		for (Hotel h: listaHotelesRight) {
			logger.info("Hotel: " + h.getNombre()+" "+ h.getDireccion());
		}
		
		List<Hotel> listaHoteles2Inner = this.hotelService.buscarHotelInnerJoin();
		
		for (Hotel h: listaHoteles2Inner) {
			logger.info("Hotel: " + h.getNombre()+" "+ h.getDireccion());
		}
		
		
		List<Hotel> listaHoteles2LefthJoin = this.hotelService.buscarHotelOuterJoinLefht();
		
		for (Hotel h: listaHoteles2LefthJoin) {
			logger.info("Hotel: " + h.getNombre()+" "+ h.getDireccion());
		}*/
		//////////////////////////////////////////////////////////////////////////////////////////
		List<Factura> listaFactura = this.facturaService.buscarFacturaInnerJoin(22);
		
		for (Factura h: listaFactura) {
			logger.info("Hotel: " + h.getFecha()+" "+ h.getNumero());
		}
		
		
		List<Factura> listaFacturaLefth = this.facturaService.buscarFacturaOuterJoinLefht(22);
		
		for (Factura h: listaFacturaLefth) {
			logger.info("Hotel: " + h.getFecha()+" "+ h.getNumero());
		}
		
		List<Factura> listaFacturaRight = this.facturaService.buscarFacturalOuterJoinRigth(22);
		
		for (Factura h: listaFacturaRight) {
			logger.info("Hotel: " +  h.getFecha()+" "+ h.getNumero());
		}
		
		List<Factura> listaFactura2Inner = this.facturaService.buscarFacturaInnerJoin();
		
		for (Factura h: listaFactura2Inner) {
			logger.info("Hotel: " +  h.getFecha()+" "+ h.getNumero());
		}
		
		
		List<Factura> listaFactura2LefthJoin = this.facturaService.buscarFacturaOuterJoinLefht();
		
		for (Factura h: listaFactura2LefthJoin) {
			logger.info("Hotel: " + h.getFecha()+" "+ h.getNumero());
		}
	}

}
