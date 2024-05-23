/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.Empleados;

import Modelo.Empleados.GestorEmpleados;
import Vista.Empleados.GUIRegistrarEmpleado;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.*;

public class ControladorRegistrarEmpleado implements ActionListener{
    
    private GUIRegistrarEmpleado guiRegistrarEmpleado;
    private JTextField nombre, apellido, email, telefono, direccion, numLicencia;
    private JDateChooser fechaNacimiento, fechaContratacion;
    private JComboBox rol;
    private JButton confirmar;
    private GestorEmpleados gestorEmpleados;

    public ControladorRegistrarEmpleado(GUIRegistrarEmpleado guiRegistrarEmpleado, JTextField nombre, JTextField apellido, JTextField email, JTextField telefono, JTextField direccion, JTextField numLicencia, JDateChooser fechaNacimiento, JDateChooser fechaContratacion, JComboBox rol, JButton confirmar) {
        this.guiRegistrarEmpleado = guiRegistrarEmpleado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.direccion = direccion;
        this.numLicencia = numLicencia;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaContratacion = fechaContratacion;
        this.rol = rol;
        this.confirmar = confirmar;
        this.gestorEmpleados = new GestorEmpleados();
        this.rol.removeAllItems();
        this.rol.addItem("Gerente");
        this.rol.addItem("Dentista");
        this.rol.addItem("Recepcionista");
        this.rol.addItem("Asistente");
        this.rol.addItem("Intendencia");
        vaciarContenido();
        
    }
    

    private void vaciarContenido(){
        this.nombre.setText("");
        this.apellido.setText("");
        this.email.setText("");
        this.telefono .setText("");
        this.direccion.setText("");
        this.numLicencia.setText("");
        this.rol.setSelectedItem(null);        
    }
    
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object seleccion = ae.getSource();
        if(seleccion == confirmar){
            if (!nombre.getText().isEmpty() && !apellido.getText().isEmpty() && !email.getText().isEmpty() && !telefono.getText().isEmpty() && !direccion.getText().isEmpty() && !numLicencia.getText().isEmpty() && fechaNacimiento.getDate() != null && fechaContratacion.getDate() != null && rol.getSelectedItem() != null) {
                // Obtener los valores de los campos
                String nombreEmpleado = nombre.getText();
                String apellidoEmpleado = apellido.getText();
                String emailEmpleado = email.getText();
                String telefonoEmpleado = telefono.getText();
                String direccionEmpleado = direccion.getText();
                String numLicenciaEmpleado = numLicencia.getText();
                Date fechaNacEmpleado = fechaNacimiento.getDate();
                Date fechaContratacionEmpleado = fechaContratacion.getDate();
                String rolEmpleado = (String) rol.getSelectedItem();

                gestorEmpleados.registrarEmpleado(nombreEmpleado, apellidoEmpleado, emailEmpleado, telefonoEmpleado, direccionEmpleado, numLicenciaEmpleado, fechaNacEmpleado, fechaContratacionEmpleado, rolEmpleado);
                gestorEmpleados.desplegarMensaje("Empleado registrado");
                vaciarContenido();
            }else{
                gestorEmpleados.desplegarMensaje("Ningun campo debe estar vacio");
            }
        }
    }
    
}
