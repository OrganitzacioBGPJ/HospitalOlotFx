/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package hospitalolot.view.gui;

import hospitalolot.model.business.entities.Torn;
import hospitalolot.model.business.entities.Unitat;
import hospitalolot.model.business.entities.dates;
import hospitalolot.model.persistence.dao.implementations.jdbc.JDBCTorn;
import hospitalolot.model.persistence.dao.implementations.jdbc.JDBCUnitat;
import hospitalolot.model.persistence.exception.DAOException;


/**
 *
 * @author Bernat
 */
public class HospitalOlot {

    public static void main(String[] args) throws DAOException {
        JDBCUnitat ju = new JDBCUnitat();
        Unitat u = ju.get(2);
        System.out.println(u.getId() + u.getTipus());
    }
    
    
    
    
}
