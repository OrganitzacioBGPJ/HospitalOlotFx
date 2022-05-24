/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospitalolot.view.console;

import java.util.Scanner;


/**
 *
 * @author Bernat
 */
public class main {

    public static void main(String[] args) {
        int opcio;
        Scanner lector = new Scanner(System.in);
        System.out.println("MENÚ");
        System.out.println("1. ESCOLLIR GUÀRDIES");
        System.out.println("2. DESESCOLLIR GUÀRDIES");
        System.out.println("3. SUPLIR GUÀRDIA");
        opcio = lector.nextInt();
        switch(opcio) {
            case 1:
                mostrarGuardies();
                escollirGuardia();
        }
    }
}
