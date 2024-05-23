/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.Pacientes;

import Modelo.Pacientes.GestorPacientes;
import Modelo.Pacientes.Paciente;
import Vista.Pacientes.GUIEliminarPaciente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class ControladorEliminarPaciente implements ActionListener{
    
    private GUIEliminarPaciente guiEliminarPaciente;
    private JComboBox pacienteOpcion;
    private JLabel id, nombre, apellido, fechaNacimiento, email, telefono, direccion;
    private JButton eliminar;
    private GestorPacientes gestorPacientes;

    public ControladorEliminarPaciente(GUIEliminarPaciente guiEliminarPaciente, JComboBox paxcienteOpcion, JLabel id, JLabel nombre, JLabel apellido, JLabel fechaNacimiento, JLabel email, JLabel telefono, JLabel direccion, JButton eliminar) {
        this.guiEliminarPaciente = guiEliminarPaciente;
        this.pacienteOpcion = paxcienteOpcion;
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.email = email;
        this.telefono = telefono;
        this.direccion = direccion;
        this.eliminar = eliminar;
        this.gestorPacientes = new GestorPacientes();
        setOpciones();
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
        pacienteOpcion.setSelectedItem(null);
    }    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object seleccion = ae.getSource();
        if(seleccion == pacienteOpcion){
            vaciarContenido();
            if(pacienteOpcion.getSelectedItem() != null){
                mostrarInformacion(pacienteOpcion.getSelectedItem().toString());
                
            }
        }
        if(seleccion == eliminar){
            if(pacienteOpcion.getSelectedItem() != null){
                boolean eliminado = gestorPacientes.eliminarPaciente(pacienteOpcion.getSelectedItem().toString());
                if(eliminado){
                    gestorPacientes.desplegarMensaje("Paceinte eliminado");
                    vaciarContenido();
                    setOpciones();
                }else{
                    gestorPacientes.desplegarMensaje("EL paciente no se pudo eliminar");                    
                }
            }else{
                gestorPacientes.desplegarMensaje("Selecciona un paciente");
            }
        }
    }
}
