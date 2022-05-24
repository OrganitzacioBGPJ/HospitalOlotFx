/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospitalolot.model.persistence.dao.implementations.jdbc.utils;

import hospitalolot.model.business.entities.Categoria;
import hospitalolot.model.business.entities.Guardies;
import hospitalolot.model.business.entities.Torn;
import hospitalolot.model.business.entities.Unitat;
import hospitalolot.model.persistence.dao.contract.Dao;
import hospitalolot.model.persistence.dao.implementations.jdbc.JDBCCategoria;
import hospitalolot.model.persistence.dao.implementations.jdbc.JDBCTorn;
import hospitalolot.model.persistence.dao.implementations.jdbc.JDBCUnitat;
import hospitalolot.model.persistence.dao.implementations.jdbc.mysql.MySQLConnection;
import hospitalolot.model.persistence.exception.DAOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bernat
 */
public class JDBCTipusGuardia implements Dao{
    
    private static JDBCUnitat ju = new JDBCUnitat();
    private static JDBCTorn jt = new JDBCTorn();
    private static JDBCCategoria jc = new JDBCCategoria();

    @Override
    public Object get(long id) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List getAll() throws DAOException {
        try {
            Statement query = MySQLConnection.getInstance().getConnection().createStatement();
            ResultSet result = query.executeQuery("Select * from tipusguardia");
            List<Guardies> llista = new ArrayList<>();
            while (result.next()) {
                Unitat u = ju.get(result.getInt("idUnitat"));
                Torn t = jt.get(result.getInt("idTorn"));
                Categoria c = jc.get(result.getInt("idCategoria"));
                llista.add(new Guardies(u,t,c, result.getDate("dia").toLocalDate(), (byte)result.getInt("numTreballadors")));
            }
            return llista;
        } catch (SQLException ex) {
            throw new DAOException();
        }
    }

    @Override
    public void add(Object t) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Object t) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Object t) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
