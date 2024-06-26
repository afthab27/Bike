package com.edubridge.mybike.dao;

import java.util.List;

import com.edubridge.mybike.model.Bike;

public interface BikeDao{
	int addBike(Bike b);
	List<Bike> findBikes();
	Bike findBikeByName(String name);
	int updateBike(Bike b);
	int deleteBikeByName(String name);
	void deleteAllBikes();
	





}
