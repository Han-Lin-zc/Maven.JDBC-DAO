package daos;

import java.util.List;

public interface DAO {
    public CarDTO findById(Integer id);
    public List<CarDTO> findAllCar();
    public boolean update(CarDTO dto);
    public boolean create(CarDTO dto);
    public boolean delete(Integer id);
}
