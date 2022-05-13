/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package hospitalolot.model.persistence.dao.contract;

import hospitalolot.model.persistence.exception.DAOException;
import java.util.List;

/**
 *
 * @author Bernat
 */
public interface Dao<T> {
    //Consulta
    T get(long id) throws DAOException;
    List<T> getAll()throws DAOException;
    
    //Modificadors
    void add(T t)throws DAOException;
    void delete(T t)throws DAOException;
    void update(T t)throws DAOException;
}
