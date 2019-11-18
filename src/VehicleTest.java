import java.io.*;
import java.util.*;

public class VehicleTest {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        try (BufferedReader bfr = new BufferedReader(new FileReader(new File("Vehicle.csv")))) {
            Queue<Vehicle> vehicleQueue1 = readFile(bfr);
            action(vehicleQueue1);
        } catch (IOException | ArrayIndexOutOfBoundsException e) {
            System.err.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static void action(Queue<Vehicle> vehicleQueue1) throws IOException {
        String code;
        do {
            System.out.println("Podaj kod działania");
             code = scanner.nextLine();
            switch (code) {
                case ("0"):
                    System.out.println("Porgram zakończył działanie.");
                    writeToFile(vehicleQueue1);

                    break;
                case ("1"):
                    System.out.println("Podaj dane o pojeździe: typ pojazdu, marka, model, rocznik, przebieg, numer VIN.");
                    vehicleQueue1.offer(new Vehicle(scanner.nextLine(), scanner.nextLine(), scanner.nextLine(),
                            scanner.nextLine(), scanner.nextLine(), scanner.nextLine()));
                    break;
                case ("2"):
                    System.out.println("Pojazd do przeglądu: " + vehicleQueue1.poll());
                    break;
            }
        }
        while (!code.equals("0"));
    }

    private static void writeToFile(Queue<Vehicle> vehicleQueue1) throws IOException {
        while (vehicleQueue1.peek() != null) {
            BufferedWriter bfw = new BufferedWriter(new FileWriter(new File("Vehicle.csv")));
            bfw.write(String.valueOf(vehicleQueue1.poll()));
            bfw.flush();
            bfw.close();
        }
    }

    private static Queue<Vehicle> readFile(BufferedReader bfr) throws IOException {
        String line;
        Queue<Vehicle> vehicleQueue = new LinkedList<>();
        while ((line = bfr.readLine()) != null) {
            String[] vehicle = line.split(",");
            vehicleQueue.offer(new Vehicle(vehicle[0], vehicle[1], vehicle[2], vehicle[3], vehicle[4], vehicle[5]));
        }
        return vehicleQueue;
    }
}