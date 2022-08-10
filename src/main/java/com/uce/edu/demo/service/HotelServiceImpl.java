package com.uce.edu.demo.service;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.uce.edu.demo.ProyectoU3CmApplication;
import com.uce.edu.demo.repository.IHotelRepository;
import com.uce.edu.demo.repository.modelo.Hotel;

@Service
public class HotelServiceImpl implements IHotelService{
	private static Logger logger = Logger.getLogger(ProyectoU3CmApplication.class);
	
	@Autowired
	private IHotelRepository hotelRepository;

	@Override
	public List<Hotel> buscarHotelInnerJoin(String tipoHabitacion) {
		// TODO Auto-generated method stub
		return this.hotelRepository.buscarHotelInnerJoin(tipoHabitacion);
	}

	@Override
	public List<Hotel> buscarHotelOuterJoinLefht(String tipoHabitacion) {
		// TODO Auto-generated method stub
		return this.hotelRepository.buscarHotelOuterJoinLefht(tipoHabitacion);
	}

	@Override
	public List<Hotel> buscarHotelOuterJoinRigth(String tipoHabitacion) {
		// TODO Auto-generated method stub
		return this.hotelRepository.buscarHotelOuterJoinRigth(tipoHabitacion);
	}

	@Override
	public List<Hotel> buscarHotelWhereJoin(String tipoHabitacion) {
		// TODO Auto-generated method stub
		return this.hotelRepository.buscarHotelWhereJoin(tipoHabitacion);
	}

	@Override
	public List<Hotel> buscarHotelFetchJoin(String tipoHabitacion) {
		// TODO Auto-generated method stub
		logger.info("Transaccion activa Service: " + TransactionSynchronizationManager.isActualTransactionActive());
		return this.hotelRepository.buscarHotelFetchJoin(tipoHabitacion);
	}

	@Override
	public List<Hotel> buscarHotelInnerJoin() {
		// TODO Auto-generated method stub
		return this.hotelRepository.buscarHotelInnerJoin();
	}

	@Override
	public List<Hotel> buscarHotelOuterJoinLefht() {
		// TODO Auto-generated method stub
		return this.hotelRepository.buscarHotelOuterJoinLefht();
	}

}
