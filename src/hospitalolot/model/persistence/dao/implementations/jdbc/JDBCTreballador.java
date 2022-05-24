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
import java.sql.PreparedStatement;

/**
 *
 * @author Bernat
 */
public class JDBCTreballador implements TreballadorDAO {

    @Override
    public Treballador get(long id) throws DAOException {
        try {
            PreparedStatement query = MySQLConnection.getInstance().getConnection().prepareStatement("Select * from treballadors where id = ?");
            query.setLong(1, id);
            ResultSet result = query.executeQuery();
            Treballador t = new Treballador(result.getLong("idTreballador"), result.getString("nom"), result.getString("cognom"), result.getBoolean("temporal"));
            if (result.next()) {
                return t;
            }
            return null;
        } catch (SQLException ex) {
            throw new DAOException();
        }
    }

    @Override
    public List<Treballador> getAll() throws DAOException {
        try {
            Statement query = MySQLConnection.getInstance().getConnection().createStatement();
            ResultSet result = query.executeQuery("Select * from treballadors");
            List<Treballador> llista = new ArrayList<Treballador>();

            //LA DEIXO PER QUAN TINGUI FET EL DAO DE LES ALTRES CLASSES JA QUE SINÓ NO PODEN AFEGIR EL TREBALLADOR
            while (result.next()) {
                llista.add(new Treballador(result.getInt("idTreballador"), result.getString("Nom"), result.getString("Cognom"), result.getBoolean("Temporal")));
            }
            return llista;
        } catch (SQLException ex) {
            throw new DAOException();
        }
    }

    @Override
    public void add(Treballador t) throws DAOException {
        try {
            PreparedStatement query = MySQLConnection.getInstance().getConnection().prepareStatement("INSERT INTO treballadors(nom, cognom, temporal) values(?,?,?)", Statement.RETURN_GENERATED_KEYS);
            query.setString(1, t.getNom());
            query.executeUpdate();

            query.setString(2, t.getCognom());
            query.executeUpdate();

            query.setBoolean(3, t.getTemporal());
            query.executeUpdate();
            ResultSet rst = query.getGeneratedKeys();
            if (rst.next()) {
                t.setId(rst.getInt("idTreballador"));
            }
        } catch (SQLException ex) {
            throw new DAOException();
        }
    }

    @Override
    public void delete(Treballador t) throws DAOException {
        try {
            PreparedStatement query = MySQLConnection.getInstance().getConnection().prepareStatement("DELETE FROM treballadors WHERE ID = ?");
            query.setLong(1, t.getId());
            query.executeUpdate();
        } catch (SQLException ex) {
            throw new DAOException();
        }
    }

    @Override
    public void update(Treballador t) throws DAOException {
        try {
            PreparedStatement query = MySQLConnection.getInstance().getConnection().prepareStatement("UPDATE treballadors SET Nom = ? WHERE idTreballador = ?");
            query.setString(1, t.getNom());
            query.setLong(2, t.getId());
            query.executeUpdate();
        } catch (SQLException ex) {
            throw new DAOException();
        }
    }

    public void updateCognom(Treballador t) throws DAOException {
        try {
            PreparedStatement query = MySQLConnection.getInstance().getConnection().prepareStatement("UPDATE treballadors SET Cognom = ? WHERE idTreballador = ?");
            query.setString(1, t.getCognom());
            query.setLong(2, t.getId());
            query.executeUpdate();
        } catch (SQLException ex) {
            throw new DAOException();
        }
    }

    public void updateTemporal(Treballador t) throws DAOException {
        try {
            PreparedStatement query = MySQLConnection.getInstance().getConnection().prepareStatement("UPDATE treballadors SET Temporal = ? WHERE idTreballador = ?");
            query.setString(1, t.getTemporal().toString());
            query.setLong(2, t.getId());
            query.executeUpdate();
        } catch (SQLException ex) {
            throw new DAOException();
        }
    }
}
