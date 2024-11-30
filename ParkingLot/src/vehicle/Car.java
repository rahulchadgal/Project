package vehicle;

import util.VehicleType;

public class Car extends Vehicle {

	public Car(String vehicleId) {
		super(vehicleId);
	}


	@Override
	public VehicleType getVehicleType() {
		return VehicleType.CAR;
	}

}
