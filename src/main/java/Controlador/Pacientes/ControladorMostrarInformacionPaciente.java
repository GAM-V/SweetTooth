/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.Pacientes;

import Modelo.Pacientes.GestorPacientes;
import Modelo.Pacientes.Paciente;
import Vista.Pacientes.GUIMostrarInformacionPaciente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class ControladorMostrarInformacionPaciente implements ActionListener{
    private GUIMostrarInformacionPaciente guiMostrarInformacionPaciente;
    private JComboBox pacienteOpcion;
    private JLabel id, nombre, apellido, fechaNacimiento, email, telefono, direccion;
    private JButton mostrar;
    private GestorPacientes gestorPacientes;

    public ControladorMostrarInformacionPaciente(GUIMostrarInformacionPaciente guiMostrarInformacionPaciente, JComboBox pacienteOpcion, JLabel id, JLabel nombre, JLabel apellido, JLabel fechaNacimiento, JLabel email, JLabel telefono, JLabel direccion, JButton mostrar) {
        this.guiMostrarInformacionPaciente = guiMostrarInformacionPaciente;
        this.pacienteOpcion = pacienteOpcion;
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.email = email;
        this.telefono = telefono;
        this.direccion = direccion;
        this.mostrar = mostrar;
        this.gestorPacientes = new GestorPacientes();
        vaciarContenido();
        setOpciones();
        this.pacienteOpcion.setSelectedItem(null);
    }
    
    private void vaciarContenido(){
        this.id.setText("");
        this.nombre.setText("");
        this.apellido.setText("");
        this.fechaNacimiento.setText("");
        this.email.setText("");
        this.telefono .setText("");
        this.direccion.setText("");
    }
    
    public void mostrarInformacion(String nombrePaciente){
        Paciente paciente = gestorPacientes.consultarPaciente(nombrePaciente);
        vaciarContenido();
        if(paciente != null){
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            this.id.setText("Id: " + paciente.getIdPaciente());
            this.nombre.setText("Nombre: " + paciente.getNombre());
            this.apellido.setText("Apellido: " + paciente.getApellido());
            this.fechaNacimiento.setText("Fecha de nacimiento " + formatoFecha.format(paciente.getFechaNacimiento()));
            this.email.setText("Email: " + paciente.getEmail());
            this.telefono .setText("Telefono: " + paciente.getTelefono());
            this.direccion.setText("Direccion: " + paciente.getDireccion());            
        }
    }
    
    private void setOpciones(){
        this.pacienteOpcion.removeAllItems();
        List<Paciente> pacientes = gestorPacientes.getPacientes();
        for(Paciente paciente: pacientes){
            pacienteOpcion.addItem(paciente.getNombre());
        }
    }    
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object seleccion = ae.getSource();
        if(seleccion == mostrar){
            if(pacienteOpcion.getSelectedItem() != null){
                vaciarContenido();
                mostrarInformacion(pacienteOpcion.getSelectedItem().toString());
            }
        }
    }
}
