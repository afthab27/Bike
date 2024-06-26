package com.edubridge.mybike.service;

import java.util.List;

import com.edubridge.mybike.model.Bike;


public interface BikeService {
	int addBike(Bike b);
	List<Bike> findbikes();
	Bike findBikeByName(String name);
	int updateBike(Bike b);
	int deleteBikeByName(String name);
	void deleteAllBikes();


}
