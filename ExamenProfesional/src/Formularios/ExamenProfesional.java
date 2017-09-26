/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import Clases.MySQL;
import Clases.hospital_0;

/**
 *
 * @author Jaime
 */
public class ExamenProfesional {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       
        hospital_0 hospital_1=new hospital_0 ();
        
        
        System.out.println(hospital_1.getNombre()+" "+hospital_1.getTipo_sangre()+" "+hospital_1.getEdad());
   
    }
    }
    

