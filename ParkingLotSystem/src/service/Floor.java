package service;

import java.util.ArrayList;
import java.util.List;

import parkingSpot.ParkingSpot;

public class Floor {

	private int floorId;
	private List<ParkingSpot> spots = new ArrayList<>();

	public Floor(int floorId, List<ParkingSpot> spots) {
		this.floorId = floorId;
		this.spots = spots;
	}

	public int getFloorId() {
		return floorId;
	}

	public List<ParkingSpot> getParkingSpot() {
		return spots;
	}
	
	

}