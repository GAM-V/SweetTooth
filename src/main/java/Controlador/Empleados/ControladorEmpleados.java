/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.Empleados;

import Vista.Empleados.GUIRegistrarEmpleado;
import Vista.Empleados.GUIMostrarInformacionEmpleado;
import Vista.Empleados.GUIModificarEmpleado;
import Vista.Empleados.GUIEmpleados;
import Vista.Empleados.GUIEliminarEmpleado;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ControladorEmpleados implements ActionListener{
    private JButton registrar, mostrar, eliminar, modificar;
    private GUIEmpleados guiEmpleados;
    private GUIRegistrarEmpleado guiRegistrarEmpleado;
    private GUIEliminarEmpleado guiEliminarEmpleado;
    private GUIModificarEmpleado guiModificarEmpleado;
    private GUIMostrarInformacionEmpleado guiMostrarInformacionEmpleado;
    

    public ControladorEmpleados(JButton registrar, JButton mostrar, JButton eliminar, JButton modificar, GUIEmpleados guiEmpleados) {
        this.registrar = registrar;
        this.mostrar = mostrar;
        this.eliminar = eliminar;
        this.modificar = modificar;
        this.guiEmpleados = guiEmpleados;      
    }
    
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object seleccion = ae.getSource();
        if(seleccion == registrar){
            this.guiRegistrarEmpleado =new GUIRegistrarEmpleado();
            guiEmpleados.setContenido(guiRegistrarEmpleado.getContenido());
        }
        if(seleccion == mostrar){
            this.guiMostrarInformacionEmpleado = new GUIMostrarInformacionEmpleado();
            guiEmpleados.setContenido(guiMostrarInformacionEmpleado.getContenido());
        }
        if(seleccion == eliminar){
            this.guiEliminarEmpleado = new GUIEliminarEmpleado();
            guiEmpleados.setContenido(guiEliminarEmpleado.getContenido());
        }
        if(seleccion == modificar){
            this.guiModificarEmpleado = new GUIModificarEmpleado();
            guiEmpleados.setContenido(guiModificarEmpleado.getContenido());
        }
    }
    
}
