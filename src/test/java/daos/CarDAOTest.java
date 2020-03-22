package daos;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CarDAOTest {


    CarDAO car = new CarDAO();

    CarDTO carDTO = new CarDTO(12, "86", "GT", 2020, "black", 102193);
    CarDTO carDTO2 = new CarDTO(1, "Civic", "Accord", 2016, "red", 112233);


    @Test
    public void extractCarFromResultSetTest() {
        CarDTO newCar = car.findById(1);
        Assert.assertEquals(newCar.getId(), newCar.getCarById());
    }

    @Test
    public void findByIdTest() {
        car.create(carDTO2);
        CarDTO newCar = car.findById(1);
        Assert.assertEquals("Civic", newCar.getName());
        Assert.assertEquals("Accord", newCar.getModel());
        Assert.assertEquals(2016, newCar.getYear());
        Assert.assertEquals("red", newCar.getColor());
        Assert.assertEquals(112233, newCar.getVin());
    }

    @Test
    public void findAllCarTest() {
        List<CarDTO> list = car.findAllCar();
        Integer expectedSize = 2;
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
        assertTrue(car.create(carDTO));
        car.delete(12);
    }

    @Test
    public void deleteTest() {
        car.create(carDTO);
        assertEquals(12, carDTO.getId());
        car.delete(12);
        assertNull(car.findById(12));
    }
}