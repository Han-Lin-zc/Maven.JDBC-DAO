package daos;

public class CarDTO implements DTO{

    private int id;
    private String name;
    private String model;
    private int year;
    private String color;
    private int Vin;

    public CarDTO() {}

    public CarDTO(String name, String model, int year, String color, int vin) {
        this.name = name;
        this.model = model;
        this.year = year;
        this.color = color;
        Vin = vin;
    }

    public CarDTO(int id, String name, String model, int year, String color, int vin) {
        this.id = id;
        this.name = name;
        this.model = model;
        this.year = year;
        this.color = color;
        Vin = vin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getVin() {
        return Vin;
    }

    public void setVin(int vin) {
        Vin = vin;
    }

    public int getCarById() {
        return getId();
    }
}
