import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class VehicleTest {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Queue<Vehicle> vehicleQueue = new LinkedList<>();

        readData(vehicleQueue);
        enterData(input, vehicleQueue);
        action(input, vehicleQueue);

    }

    private static void action(Scanner input, Queue<Vehicle> vehicleQueue) {
        boolean end = true;
        while (end) {
            System.out.println("Podaj kod działania");
            String data = input.nextLine();
            switch (data) {
                case ("0"):
                    end = false;
                    System.out.println("Porgram zakończył działanie.");
                    writeAndClose(input, vehicleQueue);
                    break;
                case ("1"):
                    System.out.println("Podaj dane o pojeździe: typ pojazdu, marka, model, rocznik, przebieg, numer VIN.");
                    vehicleQueue.offer(new Vehicle(input.nextLine(), input.nextLine(), input.nextLine(),
                            input.nextLine(), input.nextLine(), input.nextLine()));
                    break;
                case ("2"):
                    System.out.println("Pojazd do przeglądu: " + vehicleQueue.poll());
                    break;
                default:
            }
        }
    }

    private static void enterData(Scanner input, Queue<Vehicle> vehicleQueue) {
        if (vehicleQueue.isEmpty()) {
            System.out.println("Podaj dane o pojeździe: typ pojazdu, marka, model, rocznik, przebieg, numer VIN.");
            vehicleQueue.offer(new Vehicle(input.nextLine(), input.nextLine(), input.nextLine(), input.nextLine(), input.nextLine(), input.nextLine()));
        }
    }

    private static Queue<Vehicle> readData(Queue<Vehicle> vehicleQueue) {
        try (BufferedReader bfr = new BufferedReader(new FileReader(new File("Vehicle.csv")))) {
            String line;
            while ((line = bfr.readLine()) != null) {
                String[] vehicle = line.split(",");
                int arrayLength = 6;
                if (vehicle.length == arrayLength) {
                    vehicleQueue.offer(new Vehicle(vehicle[0], vehicle[1], vehicle[2], vehicle[3], vehicle[4], vehicle[5]));
                } else {
                    System.out.println("Źle sformatowany plik.");
                    System.exit(-1);
                }
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return vehicleQueue;
    }

    private static void writeAndClose(Scanner input, Queue<Vehicle> vehicleQueue) {
        try (BufferedWriter bfw = new BufferedWriter(new FileWriter(new File("Vehicle.csv")))) {
            while (vehicleQueue.peek() != null) {
                bfw.write(String.valueOf(vehicleQueue.poll()));
            }
            input.close();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}