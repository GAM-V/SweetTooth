/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.Pacientes;

import Modelo.Pacientes.GestorPacientes;
import Vista.Pacientes.GUIRegistrarPaciente;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JTextField;

public class ControladorRegistrarPaciente implements ActionListener{
    
    private GUIRegistrarPaciente guiRegistrarPaciente;
    private JTextField nombre, apellido, email, telefono, direccion;
    private JDateChooser fechaNacimiento;
    private JButton confirmar;
    private GestorPacientes gestorPacientes;

    public ControladorRegistrarPaciente(GUIRegistrarPaciente guiRegistrarPaciente, JTextField nombre, JTextField apellido, JTextField email, JTextField telefono, JTextField direccion, JDateChooser fechaNacimiento, JButton confirmar) {
        this.guiRegistrarPaciente = guiRegistrarPaciente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
        this.confirmar = confirmar;
        this.gestorPacientes = new GestorPacientes();
        vaciarContenido();
    }
    
    private void vaciarContenido(){
        this.nombre.setText("");
        this.apellido.setText("");
        this.email.setText("");
        this.telefono .setText("");
        this.direccion.setText("");
        this.fechaNacimiento.setDate(null);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object seleccion = ae.getSource();
        if(seleccion == confirmar){
            if (!nombre.getText().isEmpty() && !apellido.getText().isEmpty() && !email.getText().isEmpty() && !telefono.getText().isEmpty() && !direccion.getText().isEmpty() && fechaNacimiento.getDate() != null ) {
                // Obtener los valores de los campos
                String nombrePaciente = nombre.getText();
                String apellidoPaciente = apellido.getText();
                String emailPaciente = email.getText();
                String telefonoPaciente = telefono.getText();
                String direccionPaciente = direccion.getText();
                Date fechaNacimientoPaciente = fechaNacimiento.getDate();
                
                Boolean registrado = gestorPacientes.registrarPaciente(nombrePaciente, apellidoPaciente, emailPaciente, telefonoPaciente, direccionPaciente, fechaNacimientoPaciente);
                if(registrado){
                    gestorPacientes.desplegarMensaje("Paciente registrado");                    
                }else{
                    gestorPacientes.desplegarMensaje("Error al registrar el paciente");
                }
                vaciarContenido();
            }else{
                gestorPacientes.desplegarMensaje("Ningun campo debe estar vacio");
            }
        }
    }
}
