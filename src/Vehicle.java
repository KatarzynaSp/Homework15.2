public class Vehicle {
    private String type;
    private String mark;
    private String model;
    private String year;
    private String mileage;
    private String VIN;

    public Vehicle(String type, String mark, String model, String year, String mileage, String VIN) {
        this.type = type;
        this.mark = mark;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
        this.VIN = VIN;
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

    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    @Override
    public String toString() {
        return type + "," + mark + "," + model + "," + year + "," + mileage + "," + VIN + "\n";
    }
}