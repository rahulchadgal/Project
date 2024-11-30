package vehicle;

import util.VehicleType;

public class Bike extends Vehicle {

	public Bike(String vehicleId) {
		super(vehicleId);
	}

	@Override
	public VehicleType getVehicleType() {
		return VehicleType.BIKE;
	}

}
