package vehicle;

import util.VehicleType;

public class Truck extends Vehicle {

	public Truck(String vehicleId) {
		super(vehicleId);
	}

	@Override
	public VehicleType getVehicleType() {
		return VehicleType.TRUCK;
	}

}
