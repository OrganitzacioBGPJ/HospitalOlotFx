/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package hospitalolotapp.controller;

import hospitalolot.model.business.entities.Treballador;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import hospitalolot.model.persistence.dao.implementations.jdbc.mysql.MySQLConnection;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.sql.PreparedStatement;
import javafx.stage.Stage;

/**
 *
 * @author usuario
 */
public class FXMLDocumentController implements Initializable {

    private Treballador treballador;

    @FXML
    private Label lblUsuari;
    @FXML
    private Label lblContrasenya;
    @FXML
    private TextField txtUsuari;
    @FXML
    private PasswordField txtContrasenya;
    @FXML
    private Button btnIniciarSessio;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        treballador = new Treballador();
    }

    @FXML
    private void btnIniciarSessio(ActionEvent event) {

        try {
            boolean connectat = false;
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://192.168.18.220:3306/hospital", "Administrador", "Patata123");
            String usuari = txtUsuari.getText();
            String contrasenya = txtContrasenya.getText();

            Statement stm = con.createStatement();

            String consultaSql = "SELECT * FROM usuaris where NomUsuari='" + usuari + "' and contrasenya='" + contrasenya + "'";
            //            main start stop checkcredential getscene.getwindow 
            ResultSet resultat = stm.executeQuery(consultaSql);

            if (resultat!= null) {
                if (usuari == resultat.getString("NomUsuari") && contrasenya == resultat.getString("contrasenya")) {
                    System.out.println("Usuari iniciat!");
                    connectat = true;
                }
            }

            if (connectat) {
            }
//            if (resultat.next()) {
//                int idUsuari = resultat.getInt("idUsuaris");
//                String nomUsuari = resultat.getString("NomUsuari");
//                String contrasenyaUsuari = resultat.getString("contrasenya");
//                int idTreballador = resultat.getInt("idTreballador");
//                System.out.println("idUsuaris = " + idUsuari + " | nomUsuari = " + nomUsuari + " | contrasenya = " + contrasenyaUsuari + " | idTreballador = " + idTreballador);
//            }
//            if (con != null) {
//                System.out.println("Connexió realitzada correctament.");
//            }
        } catch (ClassNotFoundException e) {
            System.out.println("No es troba la classe. " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Falla en connectar-se a la base de dades. " + e.getMessage());
        }
    }
}
