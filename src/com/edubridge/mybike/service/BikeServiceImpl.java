package com.edubridge.mybike.service;

import java.util.List;

import com.edubridge.mybike.dao.BikeDaoImpl;
import com.edubridge.mybike.model.Bike;

public class BikeServiceImpl implements BikeService {
	private BikeDaoImpl dao=new BikeDaoImpl();

	@Override
	public int addBike(Bike b) {
		
		return dao.addBike(b);
	}

	@Override
	public List<Bike> findbikes() {
		
		return dao.findBikes();
	}

	@Override
	public Bike findBikeByName(String name) {
		
		return dao.findBikeByName(name);
	}

	@Override
	public int updateBike(Bike b) {
		
		return dao.updateBike(b);
	}

	@Override
	public int deleteBikeByName(String name) {
		
		return dao.deleteBikeByName(name);
	}

	@Override
	public void deleteAllBikes() {
		
	  dao.deleteAllBikes();
		
	}
	
}
 