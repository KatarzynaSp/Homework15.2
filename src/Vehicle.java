import java.util.Scanner;

public class Vehicle {
    private String type;
    private String mark;
    private String model;
    private String year;
    private String mileage;
    private String vin;
    private static final int NR = 6;

    public Vehicle(String type, String mark, String model, String year, String mileage, String vin) {
        this.type = type;
        this.mark = mark;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
        this.vin = vin;
    }

    public static int getNR() {
        return NR;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMileage() {
        return mileage;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    @Override
    public String toString() {
        return type + "," + mark + "," + model + "," + year + "," + mileage + "," + vin + "\n";
    }
}