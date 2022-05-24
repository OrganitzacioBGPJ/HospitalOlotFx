/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospitalolot.model.business.entities;

import java.util.Date;

/**
 *
 * @author Bernat
 */
public class Guardia {
    private Unitat u;
    private Torn t;
    private Categoria c;
    private Date dia;
    private Treballador tre;

    public Guardia(Unitat u, Torn t, Categoria c, Date dia, Treballador tre) {
        this.u = u;
        this.t = t;
        this.c = c;
        this.dia = dia;
        this.tre = tre;
    }
    
    public Guardia(Unitat u, Torn t, Categoria c, Date dia) {
        this.u = u;
        this.t = t;
        this.c = c;
        this.dia = dia;
    }

    public Guardia() {
    }

    public Unitat getU() {
        return u;
    }

    public void setU(Unitat u) {
        this.u = u;
    }

    public Torn getT() {
        return t;
    }

    public void setT(Torn t) {
        this.t = t;
    }

    public Categoria getC() {
        return c;
    }

    public void setC(Categoria c) {
        this.c = c;
    }

    public Date getDia() {
        return dia;
    }

    public void setDia(Date dia) {
        this.dia = dia;
    }

    public Treballador getTre() {
        return tre;
    }

    public void setIdTreballador(Treballador idTreballador) {
        this.tre = tre;
    }
    
        
    public void escollirGuardia(Treballador t, Guardia g) {
        
    }
}
