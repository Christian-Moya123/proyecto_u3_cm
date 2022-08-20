package com.uce.edu.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.uce.edu.demo.repository.IHotelRepository;
import com.uce.edu.demo.repository.modelo.Hotel;
import com.uce.edu.demo.service.IHotelService;

@SpringBootTest
@RunWith(value = Parameterized.class)
public class Impl3Test {

	@Autowired
	private IHotelRepository hotelRepo;
	
	@Mock
	private IHotelService hotelRepo2;
	 private Integer id;
	
	private String nombre, direccion;
	
	@Parameterized.Parameters
	public static Collection getData(){
		
		return Arrays.asList(new Object[][] {
			{1},
			{2}
		});
	}
	
	
	
	
	public Impl3Test(Integer id) {
		super();
		this.id = id;
	}


	@Test
	public void testGuardarHotel() {
		
		Hotel hotel = hotelRepo2.buscar(id);
		
		assertEquals(id, hotel);
	}
}
