/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospitalolot.model.business.entities;

/**
 *
 * @author Bernat
 */
public class Treballador extends Entity{
    
    private String nom;
    private String cognom;
    private Boolean temporal;

    public Treballador(String nom, String cognom, Boolean temporal) {
        this.nom = nom;
        this.cognom = cognom;
        this.temporal = temporal;
    }

    public Treballador(long id, String nom, String cognom, Boolean temporal) {
        super(id);
        this.nom = nom;
        this.cognom = cognom;
        this.temporal = temporal;
    }

    public Treballador() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognom() {
        return cognom;
    }

    public void setCognom(String cognom) {
        this.cognom = cognom;
    }

    public Boolean getTemporal() {
        return temporal;
    }

    public void setTemporal(Boolean temporal) {
        this.temporal = temporal;
    }
    
    public void reservarGuardia(Guardies g) {
        
    }
    
    
    
}
