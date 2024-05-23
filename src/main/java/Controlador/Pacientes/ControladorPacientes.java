/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.Pacientes;

import Vista.Pacientes.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ControladorPacientes implements ActionListener{
    private GUIPacientes guiPacientes;
    private JButton registrar, modificar, mostrar, eliminar;
    private GUIRegistrarPaciente guiRegistrarPaciente;
    private GUIModificarPaciente guiModificarPaciente;
    private GUIMostrarInformacionPaciente guiMostrarInformacionPaciente;
    private GUIEliminarPaciente guiEliminarPaciente;

    public ControladorPacientes(GUIPacientes guiPcientes, JButton registrar, JButton modificar, JButton mostrar, JButton eliminar) {
        this.guiPacientes = guiPcientes;
        this.registrar = registrar;
        this.modificar = modificar;
        this.mostrar = mostrar;
        this.eliminar = eliminar;
    }
    
    
 
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object seleccion = ae.getSource();
        if(seleccion == registrar){
            this.guiRegistrarPaciente = new GUIRegistrarPaciente();
            guiPacientes.setContenido(guiRegistrarPaciente.getContenido());
        }
        if(seleccion == mostrar){
            this.guiMostrarInformacionPaciente = new GUIMostrarInformacionPaciente();
            guiPacientes.setContenido(guiMostrarInformacionPaciente.getContenido());
        }
        if(seleccion == eliminar){
            this.guiEliminarPaciente = new GUIEliminarPaciente();
            guiPacientes.setContenido(guiEliminarPaciente.getContenido());
        }
        if(seleccion == modificar){
            this.guiModificarPaciente = new GUIModificarPaciente();
            guiPacientes.setContenido(guiModificarPaciente.getContenido());
        }
    }
}
