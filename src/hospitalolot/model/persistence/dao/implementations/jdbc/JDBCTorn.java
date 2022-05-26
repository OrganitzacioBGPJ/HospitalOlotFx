/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospitalolot.model.persistence.dao.implementations.jdbc;

import hospitalolot.model.business.entities.Torn;
import hospitalolot.model.persistence.dao.contract.TornDAO;
import hospitalolot.model.persistence.dao.implementations.jdbc.mysql.MySQLConnection;
import hospitalolot.model.persistence.exception.DAOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;

/**
 *
 * @author Bernat
 */
public class JDBCTorn implements TornDAO {

    @Override
    public Torn get(long id) throws DAOException {
        try {
            PreparedStatement query = MySQLConnection.getInstance().getConnection().prepareStatement("Select * from torn where idtorn = ?");
            query.setLong(1, id);
            ResultSet result = query.executeQuery();
            if (result.next()) {
                Torn t = new Torn(result.getString("horari"), result.getLong("idTorn"));
                return t;
            }
            return null;
        } catch (SQLException ex) {
            System.out.println(ex);
            throw new DAOException();
        }

    }

    @Override
    public List<Torn> getAll() throws DAOException {
        try {
            Statement query = MySQLConnection.getInstance().getConnection().createStatement();
            ResultSet result = query.executeQuery("Select * from torns");
            List<Torn> llista = new ArrayList<>();
            while (result.next()) {
                llista.add(new Torn(result.getString("horari"), result.getInt("idTorn")));

            }
            return llista;
        } catch (SQLException ex) {
            throw new DAOException();
        }
    }

    @Override
    public void add(Torn t) throws DAOException {
        try {
            PreparedStatement query = MySQLConnection.getInstance().getConnection().prepareStatement("INSERT INTO torn(horari) values(?)", Statement.RETURN_GENERATED_KEYS);
            query.setString(1, t.getHorari());
            query.executeUpdate();
            ResultSet rst = query.getGeneratedKeys();
            if (rst.next()) {
                t.setId(rst.getInt("id"));
            }
        } catch (SQLException ex) {
            throw new DAOException();
        }
    }

    @Override
    public void delete(Torn t) throws DAOException {
        try {
            PreparedStatement query = MySQLConnection.getInstance().getConnection().prepareStatement("DELETE FROM torn WHERE IDtorn = ?");
            query.setLong(1, t.getId());
            query.executeUpdate();
        } catch (SQLException ex) {
            throw new DAOException();
        }

    }

    @Override
    public void update(Torn t) throws DAOException {
        try {
            PreparedStatement query = MySQLConnection.getInstance().getConnection().prepareStatement("UPDATE TORN SET HORARI = ? WHERE IDtorn = ?");
            query.setString(1, t.getHorari());
            query.setLong(2, t.getId());
        } catch (SQLException ex) {
            Logger.getLogger(JDBCTorn.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}