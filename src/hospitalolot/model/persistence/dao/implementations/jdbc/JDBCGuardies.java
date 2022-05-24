/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospitalolot.model.persistence.dao.implementations.jdbc;

import hospitalolot.model.business.entities.Categoria;
import hospitalolot.model.business.entities.Guardies;
import hospitalolot.model.business.entities.Torn;
import hospitalolot.model.business.entities.Treballador;
import hospitalolot.model.business.entities.Unitat;
import hospitalolot.model.persistence.dao.contract.GuardiesDAO;
import hospitalolot.model.persistence.dao.implementations.jdbc.mysql.MySQLConnection;
import hospitalolot.model.persistence.exception.DAOException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bernat
 */
public class JDBCGuardies implements GuardiesDAO {

    private static JDBCUnitat ju = new JDBCUnitat();
    private static JDBCTorn jt = new JDBCTorn();
    private static JDBCCategoria jc = new JDBCCategoria();

    @Override
    public Guardies get(long id) throws DAOException {
        try {
            PreparedStatement query = MySQLConnection.getInstance().getConnection().prepareStatement("Select * from guardies where id = ?");
            query.setLong(1, id);
            ResultSet result = query.executeQuery();
            if (result.next()) {
                Unitat u = ju.get(result.getInt("idUnitat"));
                Torn t = jt.get(result.getInt("idTorn"));
                Categoria c = jc.get(result.getInt("idCategoria"));
                Guardies g = new Guardies(u, t, c, result.getDate("dia"), result.getByte("quantitatLlocsTreball"));
                return g;
            }

            return null;
        } catch (SQLException ex) {
            throw new DAOException();
        }

    }

    @Override
    public List<Guardies> getAll() throws DAOException {
         try {
            Statement query = MySQLConnection.getInstance().getConnection().createStatement();
            ResultSet result = query.executeQuery("Select * from guardies");
            List<Guardies> llista = new ArrayList<Guardies>();

            while (result.next()) {
                Unitat u = ju.get(result.getInt("idUnitat"));
                Torn t = jt.get(result.getInt("idTorn"));
                Categoria c = jc.get(result.getInt("idCategoria"));
                llista.add( new Guardies(u, t, c, result.getDate("dia"), result.getByte("quantitatLlocsTreball")));
            }
            return llista;
        } catch (SQLException ex) {
            throw new DAOException();
        }
    }

    @Override
    public void add(Guardies g) throws DAOException {
        try {
            PreparedStatement query = MySQLConnection.getInstance().getConnection().prepareStatement("INSERT INTO treballadors(unitat, torn, categoria, dia, quantitatLlocsTreball) values(?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            query.setLong(1, g.getU().getId());
            query.executeUpdate();

            query.setLong(2, g.getT().getId());
            query.executeUpdate();

            query.setLong(3, g.getC().getId());
            query.executeUpdate();
            
            query.setDate(4, (Date) g.getDia());
            query.executeUpdate();
            
            query.setByte(5, g.getQuantitatTreballadors());
            query.executeUpdate();
            
            ResultSet rst = query.getGeneratedKeys();
            if (rst.next()) {
                g.setId(rst.getInt("idTreballador"));
            }
        } catch (SQLException ex) {
            throw new DAOException();
        }
    }


    @Override
    public void delete(Guardies g) throws DAOException {
        try {
            PreparedStatement query = MySQLConnection.getInstance().getConnection().prepareStatement("DELETE FROM guardies WHERE ID = ?");
            query.setLong(1, g.getId());
            query.executeUpdate();
        } catch (SQLException ex) {
            throw new DAOException();
        }
    }

    @Override
    public void update(Guardies g) throws DAOException {
        
    }
    
    public void updateQuantitatTreballadors(Guardies g) throws DAOException {
        try {
            PreparedStatement query = MySQLConnection.getInstance().getConnection().prepareStatement("UPDATE treballadors SET quantitatTreballadors = ? WHERE idGuardies = ?");
            query.setByte(1, g.getQuantitatTreballadors());
            query.setLong(2, g.getId());
            query.executeUpdate();
        } catch (SQLException ex) {
            throw new DAOException();
        }
    }
    
    public void updateDia(Guardies g) throws DAOException {
        try {
            PreparedStatement query = MySQLConnection.getInstance().getConnection().prepareStatement("UPDATE treballadors SET dia = ? WHERE idGuardies = ?");
            query.setByte(1, g.getQuantitatTreballadors());
            query.setLong(2, g.getId());
            query.executeUpdate();
        } catch (SQLException ex) {
            throw new DAOException();
        }
    }
}

  