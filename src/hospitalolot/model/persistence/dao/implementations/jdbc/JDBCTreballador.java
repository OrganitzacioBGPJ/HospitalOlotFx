/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospitalolot.model.persistence.dao.implementations.jdbc;

import hospitalolot.model.business.entities.Treballador;
import hospitalolot.model.persistence.dao.contract.TreballadorDAO;
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
public class JDBCTreballador implements TreballadorDAO{

    @Override
    public Treballador get(long id) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Treballador> getAll() throws DAOException {
        try {
            Statement query = MySQLConnection.getInstance().getConnection().createStatement();
            ResultSet result = query.executeQuery("Select * from persones");
            List<Treballador> llista = new ArrayList<Treballador>();
            
            //LA DEIXO PER QUAN TINGUI FET EL DAO DE LES ALTRES CLASSES JA QUE SINÓ NO PODEN AFEGIR EL TREBALLADOR
            /*while(result.next()){
                llista.add(new Treballador(result.getString("nom"),
                                        result.getString("dni"),
                                        result.getShort("edat")));
            }*/
            return llista;
        } catch(SQLException ex){
            throw new DAOException();
        }
    }

    @Override
    public void add(Treballador t) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Treballador t) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Treballador t) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
