package com.uce.edu.demo.repository;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Hotel;

public interface IHotelRepository {
	
	public List<Hotel> buscarHotelInnerJoin(String tipoHabitacion);
	public List<Hotel> buscarHotelOuterJoinLefht(String tipoHabitacion);
	public List<Hotel> buscarHotelOuterJoinRigth(String tipoHabitacion);
	public List<Hotel> buscarHotelInnerJoin();
	public List<Hotel> buscarHotelOuterJoinLefht();
	
	public List<Hotel> buscarHotelWhereJoin(String tipoHabitacion);
	
	public List<Hotel> buscarHotelFetchJoin(String tipoHabitacion);
	
	public Hotel buscar(Integer id);
	public Hotel insertar(Hotel hotel);
	public Hotel actualizar(Hotel hotel);
	public void eliminar(Integer id);
	
	 public List<Hotel> buscarTodos();
	



}
