/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Modelo_Articulos;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lmarin
 */
public class Controlador_Articulos extends Conexion {
    public void Guardar( String Descripcio,int Cantidad,int Precio)
    {
        try {
            Connection cn=this.getConexion();
            
   
            Statement st =cn.createStatement();
            String cadena= "insert into Tbl_Articul values ('" + Descripcio + "' , '" + Cantidad + "', '" + Precio + "')";
            boolean r= st.execute(cadena);
          
            
             } 
        catch (Exception e)
        {
            
            System.out.println(e);
        }
  
    }
    public void Consultar(JTable jTable1)
    {
      
        
        Modelo.Modelo_Articulos md =new Modelo_Articulos();
        DefaultTableModel modelo=(DefaultTableModel) jTable1.getModel();
        
        try {
            Connection cn=this.getConexion();
            Statement st =cn.createStatement();
            ResultSet rs = st.executeQuery ("select * from Tbl_Articul");
            while (rs.next())
            {
                int i=Integer.parseInt(rs.getString(1));
                int Cant=Integer.parseInt(rs.getString(3));
                int Precio=Integer.parseInt(rs.getString(4));
               

                
                     
                    Object [] fila=new Object[4]; 
                    fila[0]= i;
                    fila[1]= rs.getString(2);
                    fila[2]= Cant;
                    fila[3]=Precio;
                    modelo.addRow(fila);



              }
          

            } 
        catch (Exception e) 
        {
            
            System.out.println(e);
        }
       
        
    }
    public void consultarcompra(int ID)
    {
            Modelo.Modelo_Articulos n=new Modelo.Modelo_Articulos();
    try {
          
            Connection cn=this.getConexion();
            Statement st =cn.createStatement();
            ResultSet rs = st.executeQuery("select * from Tbl_Articul WHERE ID='"+ID+"'");
             while (rs.next())
            {
                n.setID(Integer.parseInt(rs.getString(1)));
                n.setDescripcio(rs.getString(2));
                n.setPrecio(Integer.parseInt(rs.getString(3)));               
                n.setPrecio(Integer.parseInt(rs.getString(4)));
             }
            // System.out.println(""+n.getID()+n.getDescripcio()+n.getPrecio());
        } 
        catch (Exception e) 
        {
             System.out.println(e);
        }
    }
    
    
}
