package shelter.dao;

import shelter.database.DatabaseManager;
import shelter.models.Animal;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Handles CRUD operations for the Animal table in the database.
 * Uses prepared statements to avoid SQL injection.
 */
public class AnimalDAO {
    public Animal create(Animal a) throws SQLException {
        String sql = "INSERT INTO animal (species, name, sex, size, chip, vaccines, sterilized, type) VALUES (?, ?, ?, ?,?,?,?,?) RETURNING id;";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, a.getSpecies());
            ps.setString(2, a.getName());
            ps.setString(3, a.getSex());
            ps.setString(4, a.getSize());
            ps.setBoolean(5, a.isChip());
            ps.setBoolean(6, a.isVaccines());
            ps.setBoolean(7, a.isSterilized());
            ps.setString(8, a.getType());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                a.setId(rs.getInt("id"));
            }
            return a;
        }
    }

    public Optional<Animal> findById(int id) throws SQLException {
        String sql = "SELECT id, species, name, sex, size, chip, vaccines, sterilized, type FROM animal WHERE id = ?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Animal a = mapRow(rs);
                return Optional.of(a);
            }
            return Optional.empty();
        }
    }

    public List<Animal> findAll() throws SQLException {
        String sql = "SELECT id, species, name, sex, size, chip, vaccines, sterilized, type FROM animal ORDER BY id";
        List<Animal> list = new ArrayList<>();
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(mapRow(rs));
            }
        }
        return list;
    }

    public boolean update(Animal a) throws SQLException {
        String sql = "UPDATE animal SET species = ?, name = ?, sex = ?, size = ?, chip = ?, vaccines = ?, sterilized = ?,type = ? WHERE id = ?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, a.getSpecies());
            ps.setString(2, a.getName());
            ps.setString(3, a.getSex());
            ps.setString(4, a.getSize());
            ps.setBoolean(5, a.isChip());
            ps.setBoolean(6, a.isVaccines());
            ps.setBoolean(7, a.isSterilized());
            ps.setString(8, a.getType());
            ps.setInt(9, a.getId());
            int rows = ps.executeUpdate();
            return rows > 0;
        }
    }

    public boolean delete(int id) throws SQLException {
        String sql = "DELETE FROM animal WHERE id = ?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            return rows > 0;
        }
    }

    private Animal mapRow(ResultSet rs) throws SQLException {
        Animal a = new Animal();
        a.setId(rs.getInt("id"));
        a.setSpecies(rs.getString("species"));
        a.setName(rs.getString("name"));
        a.setSex(rs.getString("sex"));
        a.setSize(rs.getString("size"));
        a.setChip(rs.getBoolean("chip"));
        a.setVaccines(rs.getBoolean("vaccines"));
        a.setSterilized(rs.getBoolean("sterilized"));
        a.setType(rs.getString("type"));
        return a;
    }
}