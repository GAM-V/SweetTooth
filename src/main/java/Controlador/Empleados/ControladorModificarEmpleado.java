/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.Empleados;

import Modelo.Empleados.Empleado;
import Modelo.Empleados.GestorEmpleados;
import Vista.Empleados.GUIModificarEmpleado;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;
import javax.swing.*;

public class ControladorModificarEmpleado implements ActionListener{
    
    private GUIModificarEmpleado guiiModificarEmpleado;
    private JTextField nombre, apellido, email, telefono, direccion, numLicencia;
    private JDateChooser fechaNacimiento, fechaContratacion;
    private JComboBox empleadoOpcion, rol;
    private JButton confirmar;
    private GestorEmpleados gestorEmpleados;

    public ControladorModificarEmpleado(GUIModificarEmpleado guiiModificarEmpleado, JTextField nombre, JTextField apellido, JTextField email, JTextField telefono, JTextField direccion, JTextField numLicencia, JDateChooser fechaNacimiento, JDateChooser fechaContratacion, JComboBox empleadoOpcion, JComboBox rol, JButton confirmar) {
        this.guiiModificarEmpleado = guiiModificarEmpleado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.direccion = direccion;
        this.numLicencia = numLicencia;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaContratacion = fechaContratacion;
        this.empleadoOpcion = empleadoOpcion;
        this.rol = rol;
        this.confirmar = confirmar;
        this.gestorEmpleados = new GestorEmpleados();
        this.rol.removeAllItems();
        setOpciones();
        this.rol.addItem("Gerente");
        this.rol.addItem("Dentista");
        this.rol.addItem("Recepcionista");
        this.rol.addItem("Asistente");
        this.rol.addItem("Intendencia");
        vaciarContenido();
    }
   
    
    private void setOpciones(){
        this.empleadoOpcion.removeAllItems();
        List<Empleado> empleados = gestorEmpleados.getEmpleados();
        if(!empleados.isEmpty()){
            for(Empleado empleado : empleados){
                empleadoOpcion.addItem(empleado.getNombre());
            }
            empleadoOpcion.setSelectedItem(null);
        }
    }
    
    private void mostrarInformacionEmpleado(String nombreEmpleado){
        List<Empleado> empleados = gestorEmpleados.getEmpleados();
        if(!empleados.isEmpty()){
            for(Empleado empleado : empleados){
                if(empleado.getNombre().equals(nombreEmpleado)){
                    this.nombre.setText(empleado.getNombre());
                    this.apellido.setText(empleado.getApellido());
                    this.fechaNacimiento.setDate(empleado.getFechaNacimiento());
                    this.email.setText(empleado.getEmail());
                    this.telefono .setText(empleado.getTelefono());
                    this.direccion.setText(empleado.getDireccion());
                    this.fechaContratacion.setDate(empleado.getFechaContratacion());
                    this.numLicencia.setText(empleado.getNumeroLicencia());
                    this.rol.setSelectedItem(empleado.getRol()); 
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
        this.numLicencia.setText("");
        this.fechaContratacion.setDate(null);
        this.fechaNacimiento.setDate(null);
        this.rol.setSelectedItem(null); 
    }
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object seleccion = ae.getSource();
        if(seleccion == empleadoOpcion){
            if(empleadoOpcion.getSelectedItem()!=null){
                mostrarInformacionEmpleado(empleadoOpcion.getSelectedItem().toString());
            }
        }
        if(seleccion == confirmar){
            if (!nombre.getText().isEmpty() && !apellido.getText().isEmpty() && !email.getText().isEmpty() && !telefono.getText().isEmpty() && !direccion.getText().isEmpty() && !numLicencia.getText().isEmpty() && fechaNacimiento.getDate() != null && fechaContratacion.getDate() != null && rol.getSelectedItem() != null && empleadoOpcion.getSelectedItem() != null) {
                // Obtener los valores de los campos
                String nombrePrevio = empleadoOpcion.getSelectedItem().toString();
                String nombreEmpleado = nombre.getText();
                String apellidoEmpleado = apellido.getText();
                String emailEmpleado = email.getText();
                String telefonoEmpleado = telefono.getText();
                String direccionEmpleado = direccion.getText();
                String numLicenciaEmpleado = numLicencia.getText();
                Date fechaNacEmpleado = fechaNacimiento.getDate();
                Date fechaContratacionEmpleado = fechaContratacion.getDate();
                String rolEmpleado = rol.getSelectedItem().toString();

                boolean empleadoModificado = gestorEmpleados.modificarEmpleado(nombrePrevio, nombreEmpleado, apellidoEmpleado, emailEmpleado, telefonoEmpleado, direccionEmpleado, numLicenciaEmpleado, fechaNacEmpleado, fechaContratacionEmpleado, rolEmpleado);
                if(empleadoModificado){
                    setOpciones();
                    gestorEmpleados.desplegarMensaje("Empleado modificado");                    
                }else{
                    gestorEmpleados.desplegarMensaje("Error al modificar empleado");             
                }
            }else{
                gestorEmpleados.desplegarMensaje("Ningun campo debe estar vacio");
            }
        }
    }
    
}
