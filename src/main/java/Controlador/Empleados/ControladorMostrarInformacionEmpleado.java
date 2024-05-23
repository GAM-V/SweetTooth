/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.Empleados;

import Modelo.Empleados.Empleado;
import Modelo.Empleados.GestorEmpleados;
import Vista.Empleados.GUIMostrarInformacionEmpleado;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class ControladorMostrarInformacionEmpleado implements ActionListener{
    
    private GUIMostrarInformacionEmpleado guiMostrarInformacionEmpleado;
    private JComboBox empleadoOpcion;
    private JLabel id, nombre, apellido, fechaNacimiento, email, telefono, direccion, rol, fechaContratacion, numLicencia;
    private JButton mostrar;
    private GestorEmpleados gestorEmpleados;

    public ControladorMostrarInformacionEmpleado(GUIMostrarInformacionEmpleado guiMostrarInformacionEmpleado, JComboBox empleadoOpcion, JLabel id, JLabel nombre, JLabel apellido, JLabel fechaNacimiento, JLabel email, JLabel telefono, JLabel direccion, JLabel rol, JLabel fechaContratacion, JLabel numLicencia, JButton mostrar) {
        this.guiMostrarInformacionEmpleado = guiMostrarInformacionEmpleado;
        this.empleadoOpcion = empleadoOpcion;
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.email = email;
        this.telefono = telefono;
        this.direccion = direccion;
        this.rol = rol;
        this.fechaContratacion = fechaContratacion;
        this.numLicencia = numLicencia;
        this.mostrar = mostrar;
        this.gestorEmpleados = new GestorEmpleados();
        vaciarContenido();
        setOpciones();
        empleadoOpcion.setSelectedItem(null);
    }
    
    private void vaciarContenido(){
        this.id.setText("");
        this.nombre.setText("");
        this.apellido.setText("");
        this.fechaNacimiento.setText("");
        this.email.setText("");
        this.telefono .setText("");
        this.direccion.setText("");
        this.rol.setText("");
        this.fechaContratacion.setText("");
        this.numLicencia.setText("");
    }
    
    public void mostrarInformacion(String nombreEmpleado){
        Empleado empleado = gestorEmpleados.consultarEmpleado(nombreEmpleado);
        vaciarContenido();
        if(empleado != null){
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            this.id.setText("Id: " + empleado.getIdEmpleado());
            this.nombre.setText("Nombre: " + empleado.getNombre());
            this.apellido.setText("Apellido: " + empleado.getApellido());
            this.fechaNacimiento.setText("Fecha de nacimiento " + formatoFecha.format(empleado.getFechaNacimiento()));
            this.email.setText("Email: " + empleado.getEmail());
            this.telefono .setText("Telefono: " + empleado.getTelefono());
            this.direccion.setText("Direccion: " + empleado.getDireccion());
            this.rol.setText("Rol: " + empleado.getRol());
            this.fechaContratacion.setText("Fecha de contratación: " + formatoFecha.format(empleado.getFechaContratacion()));
            this.numLicencia.setText("Numero de licencia: " + empleado.getNumeroLicencia());
        }
    }
    
    private void setOpciones(){
        this.empleadoOpcion.removeAllItems();
        List<Empleado> empleados = gestorEmpleados.getEmpleados();
        for(Empleado empleado: empleados){
            empleadoOpcion.addItem(empleado.getNombre());
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object seleccion = ae.getSource();
        if(seleccion == mostrar){
            if(empleadoOpcion.getSelectedItem() != null){
                vaciarContenido();
                mostrarInformacion(empleadoOpcion.getSelectedItem().toString());
            }
        }
    }
    
    
}
