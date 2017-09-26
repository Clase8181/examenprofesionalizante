/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import Clases.MySQL;
import Clases.VehiculoJoel;

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
    MySQL db = new MySQL();
    db.MySQLConnection("root", "", "inventarios");
     VehiculoJoel dat=new VehiculoJoel(); 
         VehiculoJoel dat1=new VehiculoJoel(); 
        dat1.getColor();
        dat.getPlaca();
        
        
    }
    }
    

