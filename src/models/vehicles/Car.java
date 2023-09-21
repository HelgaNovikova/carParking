package models.vehicles;


import exceptions.VehicleWasNotParkedException;
import models.ParkingFloor;
import models.ParkingLot;
import models.ParkingRow;
import models.parkingSpots.ParkingSpot;
import models.parkingSpots.SpotType;

import java.util.List;

public class Car extends Vehicle {

    public Car(String color, String plateNumber) {
        super(color, plateNumber);
    }

    @Override
    public void park(ParkingLot parkingLot) {
        List<ParkingFloor> floorList = parkingLot.getFloors();
        for (ParkingFloor floor : floorList) {
            List<ParkingRow> rows = floor.getFloor();
            for (ParkingRow row : rows) {
                List<ParkingSpot> spots = row.getRow();
                for (ParkingSpot spot : spots) {
                    if (spot.getSpotType() != SpotType.MOTORCYCLE &&spot.isAvailable()) {
                        spot.park(this);
                        this.parkingSpots.add(spot);
                        System.out.println("Successfully parked");
                        return;
                    }
                }
            }
        }
        throw new VehicleWasNotParkedException();
    }
}
