package daos;

public class CarDTO implements DTO{

    private Integer id;
    private String name;
    private String model;
    private Integer year;
    private String color;
    private Integer Vin;

    public CarDTO() {}

    public CarDTO(String name, String model, Integer year, String color, Integer vin) {
        this.name = name;
        this.model = model;
        this.year = year;
        this.color = color;
        Vin = vin;
    }

    public CarDTO(Integer id, String name, String model, Integer year, String color, Integer vin) {
        this.id = id;
        this.name = name;
        this.model = model;
        this.year = year;
        this.color = color;
        Vin = vin;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getVin() {
        return Vin;
    }

    public void setVin(Integer vin) {
        Vin = vin;
    }

    public int getCarById() {
        return getId();
    }
}
