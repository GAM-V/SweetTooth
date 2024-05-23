/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.Autenticacion;
import Vista.Citas.GUICitas;
import Vista.Pagos.GUIPagos;
import Vista.Pacientes.GUIPacientes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import Vista.Autenticacion.GUIPrincipalRecepcionista;



public class ControladorPrincipalRecepcionista implements ActionListener {
    private GUICitas guiCitas ;
    private GUIPacientes guiPacientes;
    private GUIPagos guiPagos;
    private JButton citas, pacientes, pagos;
    private GUIPrincipalRecepcionista principal;
    
    public ControladorPrincipalRecepcionista(GUIPrincipalRecepcionista principal, JButton citas, JButton pacientes, JButton pagos){
        guiCitas = new GUICitas();
        guiPacientes = new GUIPacientes();        
        this. principal = principal;
        this.citas = citas;
        this.pacientes = pacientes;
        this.pagos = pagos;
    }
    
    public void actionPerformed(ActionEvent ae){
        Object botonPresionado = ae.getSource();
        if(botonPresionado == this.citas){
            principal.setContenido(guiCitas.getContenido());
        }
        if(botonPresionado == this.pacientes){
            principal.setContenido(guiPacientes.getContenido());
        } 
        if(botonPresionado == this.pagos){
            guiPagos = new GUIPagos();
            principal.setContenido(guiPagos.getContenido());
        } 
          
    }

}
