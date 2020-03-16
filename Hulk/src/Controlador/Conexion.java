/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author lmarin
 */
public class Conexion {
    public Connection getConexion() {
    
            Connection con = null;
    
            try {
               
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
             
                 con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;database=Hulk_tore;user=sa;password=Nadar");
             

            } catch (Exception e) {
    
                System.out.println(e);
                System.out.println("no entro");
    
            }
            return con;
        }
       public static void main(String[] args) {
        Conexion prop=new Conexion();
        prop.getConexion();
        
        
    }
    
    
}
