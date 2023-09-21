package exceptions;

public class VehicleIsAlreadyParkedException extends RuntimeException {
    public VehicleIsAlreadyParkedException() {
        super("This vehicle is already parked");
    }
}
