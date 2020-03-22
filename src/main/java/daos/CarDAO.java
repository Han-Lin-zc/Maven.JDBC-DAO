package daos;

import java.sql.*;
import java.util.*;

public class CarDAO implements DAO{

    Connection connection = ConnectionFactory.getConnection();

    public CarDTO extractCarFromResultSet(ResultSet rs) throws SQLException
    {
        CarDTO carDTO = new CarDTO();

        carDTO.setId( rs.getInt("id"));
        carDTO.setName( rs.getString("name"));
        carDTO.setModel( rs.getString("model"));
        carDTO.setYear( rs.getInt("year"));
        carDTO.setColor( rs.getString("color"));
        carDTO.setVin( rs.getInt("vin"));
        return carDTO;
    }

    public CarDTO findById(Integer id) {
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM car WHERE id = " + id);
            if (rs.next()) {
                return extractCarFromResultSet(rs);
            }
        } catch (SQLException e ) {
            e.printStackTrace();
        }
        return null;
    }

    public List<CarDTO> findAllCar() {

        List<CarDTO> cars = new ArrayList<CarDTO>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM car");
            while (rs.next()) {
                CarDTO carDTO = extractCarFromResultSet(rs);
                cars.add(carDTO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cars;
    }

    public boolean update(CarDTO dto) {
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "UPDATE car SET name=?, model=?, year=?, color=?, vin=? WHERE id=" + dto.getId() + ";");
            ps.setString(1, dto.getName());
            ps.setString(2, dto.getModel());
            ps.setInt(3, dto.getYear());
            ps.setString(4, dto.getColor());
            ps.setInt(5, dto.getVin());
            int i = ps.executeUpdate();

            if (i == 1) return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private static final String INSERT = "INSERT INTO car" +
            "(id, name, model, year, color, vin" +
            "values(?,?,?,?,?,?);";


    public boolean create(CarDTO dto) {
        try {
            PreparedStatement ps = connection.prepareStatement(INSERT);
            ps.setInt(1, dto.getId());
            ps.setString(1, dto.getName());
            ps.setString(1, dto.getModel());
            ps.setInt(1, dto.getYear());
            ps.setString(1, dto.getColor());
            ps.setInt(1, dto.getVin());

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(Integer id) {
        try {
            Statement statement = connection.createStatement();
            int i = statement.executeUpdate("DELETE FROM car WHERE id=" + id);

            if (i == 1) return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
