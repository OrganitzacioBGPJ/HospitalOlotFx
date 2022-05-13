/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospitalolot.model.persistence.dao.implementations.jdbc.mysql;

import hospitalolot.model.persistence.exception.DAOException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

/**
 *
 * @author Bernat
 */
public class MySQLConnection {
    private final String FILE_CONFIG = "resources/config.properties";
    
    
    private static MySQLConnection instance;
    private Connection connection;
    private MySQLConnection() {
        Properties prop = new Properties();
        try{
            InputStream config = new FileInputStream(FILE_CONFIG);
            prop.load(config);
            String driver = prop.getProperty("driver");
            String url = prop.getProperty("url");
            String user = prop.getProperty("user");
            String password = prop.getProperty("password");
            
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
        } catch(IOException ex){
            
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        } catch(SQLException ex){
            System.out.println("Error de connexió: " + ex.getMessage());
        }
    }
    public static MySQLConnection getInstance() {
        if(instance == null){
            instance = new MySQLConnection();
        }
        return instance;
    }
    public Connection getConnection(){
        return connection;
    }
    public void disconnect(){
        try {
            connection.close();
        } catch (SQLException ex) {
            System.out.println("Error en desconnectar" + ex);
        }
    }
            
}
