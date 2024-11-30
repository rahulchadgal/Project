package service;

import model.Vehicle;

public abstract class ParkingSpot {
	private int spotId;
	private Vehicle vehicle;

	public ParkingSpot(int spotId) {
		this.spotId = spotId;
		this.vehicle = null;
	}

	public int getSpotId() {
		return spotId;
	}

	public boolean isAvailable() {
		return (vehicle == null);
	}

	public void parkVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public void unparkVehicle() {
		this.vehicle = null;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public abstract boolean canPark(Vehicle vehicle);
}
