import java.io.*;
import java.util.*;

public class VehicleTest {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        try (BufferedReader bfr = new BufferedReader(new FileReader(new File("Vehicle.csv")))) {
            Queue<Vehicle> vehicleQueue1 = readFile(bfr);

            action(vehicleQueue1);
            try (BufferedWriter bfw = new BufferedWriter(new FileWriter(new File("Vehicle.csv")))) {
                writeToFile(vehicleQueue1, bfw);
            } catch (
                    IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void action(Queue<Vehicle> vehicleQueue1) {
        System.out.println("Podaj kod działania");
        String code = scanner.nextLine();
        do {
            switch (code) {
                case ("0"):
                    System.out.println("Porgram zakończył działanie.");
                    try (BufferedWriter bfw = new BufferedWriter(new FileWriter(new File("Vehicle.csv")))) {
                        writeToFile(vehicleQueue1, bfw);
                    } catch (
                            IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case ("1"):
                    if (vehicleQueue1.isEmpty()) {
                        System.out.println("Podaj dane o pojeździe: typ pojazdu, marka, model, rocznik, przebieg, numer VIN.");
                        vehicleQueue1.offer(new Vehicle(scanner.nextLine(), scanner.nextLine(), scanner.nextLine(),
                                scanner.nextLine(), scanner.nextLine(), scanner.nextLine()));
                    }
                    break;
                case ("2"):
                    System.out.println("Pojazd do przeglądu: " + vehicleQueue1.poll());
                    break;
            }
            System.out.println("Podaj kod działania");
             code = scanner.nextLine();
        }
        while (!code.equals("0"));


//            for (int i = 0; i < Vehicle.getNR(); i++) {
//                String s =scanner.nextLine();
//            }
//            if (vehicleQueue1.isEmpty()) {
//                System.out.println("Podaj dane o pojeździe: typ pojazdu, marka, model, rocznik, przebieg, numer VIN.");
//                vehicleQueue1.offer(new Vehicle(scanner.nextLine(), scanner.nextLine(), scanner.nextLine(),
//                        scanner.nextLine(), scanner.nextLine(), scanner.nextLine()));
//            }


    }


    private static void writeToFile(Queue<Vehicle> vehicleQueue1, BufferedWriter bfw) throws IOException {
        while (vehicleQueue1.peek() != null) {
            bfw.write(String.valueOf(vehicleQueue1.poll()));
            scanner.close();
        }

    }

    private static Queue<Vehicle> readFile(BufferedReader bfr) throws IOException {
        String line;
        Queue<Vehicle> vehicleQueue = new LinkedList<>();
        while ((line = bfr.readLine()) != null) {
            String[] vehicle = line.split(",");
            if (vehicle.length == Vehicle.getNR()) {
                vehicleQueue.offer(new Vehicle(vehicle[0], vehicle[1], vehicle[2], vehicle[3], vehicle[4], vehicle[5]));
            } else {
                System.out.println("Źle sformatowany plik.");
            }
        }
        return vehicleQueue;
    }
}
