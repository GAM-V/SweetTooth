/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.Pacientes;

import Modelo.Pacientes.*;
import Vista.Pacientes.GUIModificarPaciente;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;
import javax.swing.*;

public class ControladorModificarPaciente implements ActionListener{
    
    private GUIModificarPaciente guiModificarPaciente;
    private JTextField nombre, apellido, email, telefono, direccion;
    private JDateChooser fechaNacimiento;
    private JComboBox pacienteOpcion;
    private JButton confirmar;
    private GestorPacientes gestorPacientes;

    public ControladorModificarPaciente(GUIModificarPaciente guiModificarPaciente, JTextField nombre, JTextField apellido, JTextField email, JTextField telefono, JTextField direccion, JDateChooser fechaNacimiento, JComboBox pacienteOpcion, JButton confirmar) {
        this.guiModificarPaciente = guiModificarPaciente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
        this.pacienteOpcion = pacienteOpcion;
        this.confirmar = confirmar;
        this.gestorPacientes = new GestorPacientes();
        setOpciones();
        vaciarContenido();
    }
    
    
    
    private void setOpciones(){
        this.pacienteOpcion.removeAllItems();
        List<Paciente> pacientes = gestorPacientes.getPacientes();
        if(!pacientes.isEmpty()){
            for(Paciente paciente : pacientes){
                pacienteOpcion.addItem(paciente.getNombre());
            }
            pacienteOpcion.setSelectedItem(null);
        }
    }
    
    private void mostrarInformacionPaciente(String nombrePaciente){
        List<Paciente> pacientes = gestorPacientes.getPacientes();
        if(!pacientes.isEmpty()){
            for(Paciente paciente : pacientes){
                if(paciente.getNombre().equals(nombrePaciente)){
                    this.nombre.setText(paciente.getNombre());
                    this.apellido.setText(paciente.getApellido());
                    this.fechaNacimiento.setDate(paciente.getFechaNacimiento());
                    this.email.setText(paciente.getEmail());
                    this.telefono .setText(paciente.getTelefono());
                    this.direccion.setText(paciente.getDireccion());
                }
            }
        }
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
        if(seleccion == pacienteOpcion){
            if(pacienteOpcion.getSelectedItem()!=null){
                mostrarInformacionPaciente(pacienteOpcion.getSelectedItem().toString());
            }
        }
        if(seleccion == confirmar){
            if (!nombre.getText().isEmpty() && !apellido.getText().isEmpty() && !email.getText().isEmpty() && !telefono.getText().isEmpty() && !direccion.getText().isEmpty() && fechaNacimiento.getDate() != null && pacienteOpcion.getSelectedItem() != null) {
                // Obtener los valores de los campos
                String nombrePrevio = pacienteOpcion.getSelectedItem().toString();
                String nombreEmpleado = nombre.getText();
                String apellidoEmpleado = apellido.getText();
                String emailEmpleado = email.getText();
                String telefonoEmpleado = telefono.getText();
                String direccionEmpleado = direccion.getText();
                Date fechaNacEmpleado = fechaNacimiento.getDate();

                boolean pacienteModificado = gestorPacientes.modificarPaciente(nombrePrevio, nombreEmpleado, apellidoEmpleado, emailEmpleado, telefonoEmpleado, direccionEmpleado, fechaNacEmpleado);
                if(pacienteModificado){
                    setOpciones();
                    vaciarContenido();
                    gestorPacientes.desplegarMensaje("Empleado modificado");                    
                }else{
                    gestorPacientes.desplegarMensaje("Error al modificar empleado");             
                }
            }else{
                gestorPacientes.desplegarMensaje("Ningun campo debe estar vacio");
            }
        }
    }    
}
