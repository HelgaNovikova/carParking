import models.ParkingLot;
import menu.InitialMenu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ParkingLot parkingLot = new ParkingLotInitializer().buildParkingLot();
        new InitialMenu(sc, parkingLot);
    }
}