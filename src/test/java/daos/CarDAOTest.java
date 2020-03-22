package daos;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CarDAOTest {


    CarDAO car = new CarDAO();

    CarDTO carDTO = new CarDTO(12, "86", "GT", 2020, "black", 102193);


    @Test
    public void extractCarFromResultSetTest() {
        CarDTO newCar = car.findById(1);
        Assert.assertEquals(newCar.getId(), newCar.getCarById());
    }

    @Test
    public void findByIdTest() {
        car.create(carDTO);
        CarDTO newCar = car.findById(12);
        Assert.assertEquals("86", newCar.getName());
        Assert.assertEquals("GT", newCar.getModel());
        Assert.assertEquals(2020 , newCar.getYear());
        Assert.assertEquals("black", newCar.getColor());
        Assert.assertEquals(102193, newCar.getVin());
    }

    @Test
    public void findAllCarTest() {
        List<CarDTO> list = car.findAllCar();
        Integer expectedSize = 5;
        Integer actualSize = list.size();
        Assert.assertEquals(expectedSize, actualSize);
    }

    @Test
    public void updateTest() {
        car.create(carDTO);
        CarDTO expected = new CarDTO(12, "Civic", "SI", 2020, "red", 932110);
        car.update(expected);
        CarDTO actual = car.findById(12);
        assertEquals(expected.getId(), actual.getId());
        assertEquals(expected.getName(), actual.getName());
        assertEquals(expected.getModel(), actual.getModel());
        assertEquals(expected.getYear(), actual.getYear());
        assertEquals(expected.getColor(), actual.getColor());
        assertEquals(expected.getVin(), actual.getVin());
    }

    @Test
    public void createTest() {
        car.create(carDTO);
        CarDTO expected = new CarDTO(12, "Civic", "SI", 2020, "red", 932110);
        car.create(expected);
        assertEquals(12, carDTO.getId());
    }

    @Test
    public void deleteTest() {
        car.create(carDTO);
        assertEquals(12, carDTO.getId());
        car.delete(12);
        assertNull(car.findById(12));
    }
}