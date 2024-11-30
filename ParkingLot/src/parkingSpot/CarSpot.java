package parkingSpot;

import util.VehicleType;
import vehicle.Vehicle;

public class CarSpot extends ParkingSpot {

	public CarSpot(int spotId) {
		super(spotId);
	}

	@Override
	public boolean canPark(Vehicle vehicle) {
		return vehicle.getVehicleType() == VehicleType.CAR;
	}

}
