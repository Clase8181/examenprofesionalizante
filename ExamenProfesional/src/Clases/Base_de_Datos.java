/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
public class Base_de_Datos {
 private  Connection Conexion;
 private  Statement sentencia;
 //Parametros de Configuración
 private final String Servidor="localhost";
 private final String Puerto="3306";//3306
 private final String BD="Malla";//
 private final String Usuario="root";//
 private final String clave="";//
 private final String URL="jdbc:mysql://"+Servidor+":"+Puerto+"/"+BD;//
 
 
    public Base_de_Datos() {
        this.Conexion = null;
        this.sentencia = null;
        
        
    }
 /**
  *Metodo para crear comunicación con la base de dato 
  * Retorna true cuando la conexion se crea correctamente
  * y false cuando no es posible
  */
public boolean Conectar(/*String user, String pass, String db_name*/) throws SQLException, ClassNotFoundException {
    boolean estado=false;
      try{
            //Cargamos el Driver, previmente se debe agregar al programa Libraries/MySQL ODBC
            Class.forName("com.mysql.jdbc.Driver");
            /*
            Una vez cargado el driver es necesario crear un objeto del tipo Connection, para administrar la conexión. 
            Una aplicación puede utilizar DriverManager para obtener un objeto de tipo conexión,
            Connection, con una base de datos. 
            La conexión se especifica siguiendo una sintaxis basada en la especificación más amplia de los URL, 
            de la forma:jdbc:subprotocolo//servidor:puerto/base de datos             
            */
            try {
           //  Conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + db_name, user, pass);
             // Conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + db_name, user, pass);
                     
              Conexion = DriverManager.getConnection(URL,Usuario,clave);
            estado=true;
            
            
            }catch (SQLException cex) {
           // System.err.println("Error: ConetorBD.Conectar URL"+URL+"Usuario "+user+"clave "+pass);
            System.err.println("al intentar conectarse a la base");
            System.err.println("Mensaje "+cex.getMessage());
       } 
      } catch (ClassNotFoundException ex) {
          System.err.println("Error: ConetorBD.Conectar");
            System.err.println("No se encontro el Driver de conexion de My SQL");
            Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
       } 
      
             
        return estado;
    }

  /********************************************************************************************
    
    Este método permite cerrar la conexion
    Verificando que exista la conexion
    *********************************************************************************************/
     public void desconectar() {
        try {           
            if(Conexion!=null){
                 Conexion.close();
                 Conexion=null;
            }else{
            JOptionPane.showMessageDialog(null, "no se puede cerrar una conexion que no ha sido iniciada");
            }
           
            
        } catch (SQLException ex) {
            System.err.println("Error: ConetorBD.desconectar");
            Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
     
     /********************************************************************************************
    
   Método que permite crear una Base de DAtos, y recibe por parametro el nombre de la Base de Datos
    *********************************************************************************************/
public boolean ejecutar(String SQL){
    boolean estado=false;
     try {
         sentencia=Conexion.createStatement();
         sentencia.execute(SQL);
         sentencia.close();
         estado=true;
     } catch (SQLException ex) {
         System.err.println("Error: ConetorBD.ejecutar(SQL) "+SQL);
     }
    
return estado;
}
     
 public ResultSet seleccionar(String sql){
 ResultSet resultado=null;
     try {
         sentencia= Conexion.createStatement();
         resultado=sentencia.executeQuery(sql);
     } catch (SQLException ex) {
         System.err.println("Error: ConetorBD.Seleccionar(SQL) "+sql);
         System.err.println("Error: "+ex.getMessage());
         Logger.getLogger(Base_de_Datos.class.getName()).log(Level.SEVERE, null, ex);
     } 
 return resultado;
 }   
}