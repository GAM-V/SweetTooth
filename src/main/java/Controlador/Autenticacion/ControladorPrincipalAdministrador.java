/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.Autenticacion;
import Vista.Citas.GUICitas;
import Vista.Pagos.GUIPagos;
import Vista.Usuarios.GUIUsuarios;
import Vista.Empleados.GUIEmpleados;
import Vista.Pacientes.GUIPacientes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import Vista.Autenticacion.GUIPrincipalAdmin;


public class ControladorPrincipalAdministrador implements ActionListener {
    private GUICitas guiCitas ;
    private GUIUsuarios guiUsuarios;
    private GUIEmpleados guiEmpleados;
    private GUIPacientes guiPacientes;
    private GUIPagos guiPagos;
    private JButton citas, Usuarios, empleados, pacientes, pagos;
    private GUIPrincipalAdmin principal;
    
    public ControladorPrincipalAdministrador(GUIPrincipalAdmin principal, JButton citas, JButton Usuarios, JButton empleados, JButton pacientes, JButton pagos){
        guiCitas = new GUICitas();
        guiUsuarios = new GUIUsuarios();
        guiEmpleados = new GUIEmpleados();
        guiPacientes = new GUIPacientes();        
        this. principal = principal;
        this.citas = citas;
        this.Usuarios = Usuarios;
        this.empleados = empleados;
        this.pacientes = pacientes;
        this.pagos = pagos;
    }
    
    public void actionPerformed(ActionEvent ae){
        Object botonPresionado = ae.getSource();
        if(botonPresionado == this.citas){
            principal.setContenido(guiCitas.getContenido());
        }
        if(botonPresionado == this.Usuarios){
            principal.setContenido(guiUsuarios.getContenido());
        } 
        if(botonPresionado == this.empleados){
            principal.setContenido(guiEmpleados.getContenido());
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
