package vehicle;

import util.VehicleType;

public abstract class Vehicle {

	private String vehicleId;

	public Vehicle(String vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getVehicleId() {
		return vehicleId;
	}

	public abstract VehicleType getVehicleType();
}
