package com.uce.edu.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.ClassOrderer.OrderAnnotation;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.Rollback;

import com.uce.edu.demo.repository.ICuentaBancariaRepository;
import com.uce.edu.demo.repository.IHotelRepository;
import com.uce.edu.demo.repository.modelo.CuentaBancaria;
import com.uce.edu.demo.repository.modelo.Hotel;
import com.uce.edu.demo.service.IHotelService;

import org.jboss.logging.Logger;

@SpringBootTest
@AutoConfigureTestDatabase(replace = Replace.NONE)//
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class Impl2Test {
	
	private static Logger logger = Logger.getLogger(ProyectoU3CmApplication.class);
	
	@Autowired
	private IHotelRepository hotelRepo;
	
	
	


	@Test
	@Order(1)
	public void testGuardarHotel() {
		logger.info("Test guardar hotel 1");
		Hotel hotel= new Hotel();
		hotel.setNombre("angel7ddddddddddd");
		hotel.setDireccion("san luis7ddddddd");
		
		Hotel hotelGuardado =  hotelRepo.insertar(hotel);
		
		assertNotNull(hotelGuardado);
	}
	
	@Test
	@Order(3)
	public void testBuscarHotel() {
		logger.info("Test buscar hotel 3");
		Integer id = 2;
		Hotel hotel = hotelRepo.buscar(id);
		   
		assertThat(hotel.getId()).isEqualTo(id);
	}



	
	@Test
	@Order(2)
	public void actualizarHotelTest() {
		logger.info("Test actualizar hotel 5");
		Integer id = 3;
		
		Hotel hotel= new Hotel();
		hotel.setNombre("marco1");
		hotel.setDireccion("calle 21 A1");
		hotel.setId(id);
		
		Hotel hotelActualizado =  hotelRepo.actualizar(hotel);
		
		assertThat(hotelActualizado.getId()).isEqualTo(id);
	}
	
	@Test
	@Order(4)
	public void  testbuscarHotelOuterJoinLefht()  {
		logger.info("Test buscarHotelOuterJoinLefht hotel 4");
		List<Hotel> hoteles = hotelRepo.buscarHotelOuterJoinLefht();
		for(Hotel hotel: hoteles) {
			System.out.println(hotel);
		}
		
		assertThat(hoteles).size().isGreaterThan(0);
	}
	
	
}
