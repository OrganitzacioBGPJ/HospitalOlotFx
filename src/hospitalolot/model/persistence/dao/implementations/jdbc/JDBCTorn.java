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

/**
 *
 * @author Bernat
 */
public class JDBCTorn implements TornDAO {

    @Override
    public Torn get(long id) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Torn> getAll() throws DAOException {
        try {
            Statement query = MySQLConnection.getInstance().getConnection().createStatement();
            ResultSet result = query.executeQuery("Select * from persones");
            List<Torn> llista = new ArrayList<Torn>();
            while (result.next()) {
                Torn t = new Torn(result.getString("Horari"));
                t.setId(result.getInt("idTorn"));
                
            
             //,result.getInt("idTorn") si s'ha d'afegir l'id del torn
            }
            return llista;
        } catch (SQLException ex) {
            throw new DAOException();
        }
    }

    @Override
    public void add(Torn t) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Torn t) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Torn t) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
