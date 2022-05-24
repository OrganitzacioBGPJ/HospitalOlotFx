/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospitalolot.model.persistence.dao.implementations.jdbc;

import hospitalolot.model.business.entities.Entity;
import hospitalolot.model.business.entities.Unitat;
import hospitalolot.model.persistence.dao.contract.UnitatDAO;
import hospitalolot.model.persistence.dao.implementations.jdbc.mysql.MySQLConnection;
import hospitalolot.model.persistence.exception.DAOException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCUnitat implements UnitatDAO {

    @Override
    public Unitat get(long id) throws DAOException {
        try {
            PreparedStatement query = MySQLConnection.getInstance().getConnection().prepareStatement("Select * from unitats where id = ?");
            query.setString(1, Long.toString(id));
            ResultSet result = query.executeQuery();
            if (result.next()) {
                /**/
                Unitat t = new Unitat(result.getLong("idUnitat"), result.getString("Tipus"));
                return t;
            }
            return null;
        } catch (SQLException ex) {
            throw new DAOException();
        }

    }

    @Override
    public List<Unitat> getAll() throws DAOException {
        try {
            Statement query = MySQLConnection.getInstance().getConnection().createStatement();
            ResultSet result = query.executeQuery("Select * from unitats");
            List<Unitat> llista = new ArrayList<>();
            while (result.next()) {
                llista.add(new /**/ Unitat(result.getInt("idUnitat"), result.getString("tipus")));
               
            }
            return llista;
        } catch (SQLException ex) {
            throw new DAOException();
        }
    }

    @Override
    public void add(Unitat t) throws DAOException {
        try {
            PreparedStatement query = MySQLConnection.getInstance().getConnection().prepareStatement("INSERT INTO unitats(tipus) values(?)", Statement.RETURN_GENERATED_KEYS);
            query.setString(1, t.getTipus());
            query.executeUpdate();
            ResultSet rst = query.getGeneratedKeys();
            if (rst.next()) {
                t.setId(rst.getInt("idUnitat"));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void delete(Unitat t) throws DAOException {
        try {
            PreparedStatement query = MySQLConnection.getInstance().getConnection().prepareStatement("DELETE FROM unitats WHERE ID = ?");
            query.setLong(1, t.getId());
            query.executeUpdate();
        } catch (SQLException ex) {
            throw new DAOException();
        }

    }
        public void delete(String nom) throws DAOException {
        try {
            PreparedStatement query = MySQLConnection.getInstance().getConnection().prepareStatement("DELETE FROM unitats WHERE tipus = ?");
            query.setString(1, (nom));
            query.executeUpdate();
        } catch (SQLException ex) {
            throw new DAOException();
        }

    }

    @Override
    public void update/**/(Unitat t) throws DAOException {
        try {
            PreparedStatement query = MySQLConnection.getInstance().getConnection().prepareStatement/**/("UPDATE unitats SET TIPUS = ? WHERE ID = ?");
            query.setString(1, /**/ t.getTipus());
            query.setString(2, Long.toString(t.getId()));
        } catch (SQLException ex) {
            throw new DAOException();
        }
    }

}