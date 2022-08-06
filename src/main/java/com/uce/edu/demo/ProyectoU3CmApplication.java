package com.uce.edu.demo;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.modelo.factura.Factura;
import com.uce.edu.demo.repository.modelo.Habitacion;
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
		
		logger.info("JOIN WHERE");
		List<Hotel> listaHotelesWhere = this.hotelService.buscarHotelWhereJoin("Familiar");
		
		for (Hotel h: listaHotelesWhere) {
			logger.info("Hotel: nombre:  " + h.getNombre()+" direccion: "+ h.getDireccion());
			
		}
		
		logger.info("INNER JOIN EAGER/LAZY");
		List<Hotel> listaHoteles = this.hotelService.buscarHotelInnerJoin("Familiar");
		
		for (Hotel h: listaHoteles) {
			logger.info("Hotel: nombre: " + h.getNombre()+" direccion: "+ h.getDireccion());
			
			
			logger.info("Hotel 2 habitaciones: " + h.getHabitaciones());
			
		}
		
		logger.info("JOIN FETCH");
		List<Hotel> listaHotelesFetch = this.hotelService.buscarHotelFetchJoin("Familiar");
		
		for (Hotel h: listaHotelesFetch) {
			logger.info("Hotel: nombre: " + h.getNombre()+" direccion: "+ h.getDireccion());
			
			
			logger.info("Hotel 3 habitaciones: " + h.getHabitaciones());
			
		}
		
		
		//////////////////////////////////////////////////////////////////////////////////////////
		
	}

}
