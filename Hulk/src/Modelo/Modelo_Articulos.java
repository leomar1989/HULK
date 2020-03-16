/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author lmarin
 */
public class Modelo_Articulos extends Vista.Vista_ControlInventario{
    
        
    
    private int ID;
    private String Descripcio;
    private int Cantidad;
    private int Precio;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getDescripcio() {
        return Descripcio;
    }

    public void setDescripcio(String Descripcio) {
        this.Descripcio = Descripcio;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }
        public int getPrecio() {
        return Precio;
    }

    public void setPrecio(int Precio) {
        this.Precio = Precio;
    }
public void Guardar(){
    Controlador.Controlador_Articulos ca=new Controlador.Controlador_Articulos();
    ca.Guardar(this.Descripcio,this.Cantidad,this.Precio);

    
}
public void consultar(JTable Jtable1)
{
    Controlador.Controlador_Articulos nw=new Controlador.Controlador_Articulos();
    nw.Consultar(Jtable1);
    
}
public void consultaradicionar(int ID,int Cantidad,JTable tb1)
{   Controlador.Controlador_Articulos ct=new Controlador.Controlador_Articulos();
       DefaultTableModel modelo=(DefaultTableModel) tb1.getModel();
       System.out.println(""+getID()+getDescripcio()+getPrecio());
       Object [] fila=new Object[4]; 
        ct.consultarcompra(ID);
        if(this.Cantidad<=Cantidad)
        {
         
           
                    fila[0]= getID();
                    fila[1]= getDescripcio();
                    fila[2]= getPrecio();
                    fila[3]= getCantidad();
                    modelo.addRow(fila);
         
        }

 
}
        
    
}
