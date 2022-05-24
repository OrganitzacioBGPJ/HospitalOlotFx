/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package hospitalolot.view.gui;

import hospitalolot.model.business.entities.Unitat;
import hospitalolot.model.persistence.dao.implementations.jdbc.JDBCUnitat;
import hospitalolot.model.persistence.exception.DAOException;


/**
 *
 * @author Bernat
 */
public class HospitalOlot {

    public static void main(String[] args) throws DAOException {
    try {  
        String uni = "Unitat5";
    JDBCUnitat b = new JDBCUnitat();
    b.delete(uni);
    }catch (DAOException e){
        System.out.println(e);
            System.out.println("malament");
            }
    }
    
    
    
    
}
