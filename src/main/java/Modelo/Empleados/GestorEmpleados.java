/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Empleados;

import Modelo.CITAS.Agenda;
import Modelo.CITAS.Cita;
import Modelo.Persistencia;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class GestorEmpleados {
    
    private Persistencia persistencia;

    public GestorEmpleados() {
        this.persistencia = new Persistencia();
    }
    
    public boolean registrarEmpleado(String nombre, String apellido, String email, String telefono, String direccion, String numLicencia, Date fechaNacimiento, Date fechaContratacion, String rol) {
        if(rol == "Dentista"){
            Persistencia persistenciaAgenda = new Persistencia();
            List<Agenda> agendas = persistenciaAgenda.getListaAgenda();
            Agenda agenda = new Agenda();
            agenda.setNombre(nombre);
            agendas.add(agenda);
            persistenciaAgenda.actualizarDataBaseAgendas(agendas);
        }
        Random random = new Random();
        int numero = random.nextInt(10000);
        String id = String.format("%04d", numero);
        
        Empleado nuevoEmpleado = new Empleado();
        nuevoEmpleado.setIdEmpleado(id);
        nuevoEmpleado.setNombre(nombre);
        nuevoEmpleado.setApellido(apellido);
        nuevoEmpleado.setEmail(email);
        nuevoEmpleado.setTelefono(telefono);
        nuevoEmpleado.setDireccion(direccion);
        nuevoEmpleado.setNumeroLicencia(numLicencia);
        nuevoEmpleado.setFechaNacimiento(fechaNacimiento);
        nuevoEmpleado.setFechaContratacion(fechaContratacion);
        nuevoEmpleado.setRol(rol);
        
        List<Empleado> empleados = persistencia.getEmpleados();
        empleados.add(nuevoEmpleado);
        persistencia.actualizarEmpleados(empleados);
        return true;
    }
    
    public Empleado consultarEmpleado(String nombreEmpleado){
        List<Empleado> empleados = persistencia.getEmpleados();
        for(Empleado empleado : empleados){
            if(empleado.getNombre().equals(nombreEmpleado)){
                return empleado;
            }
        }
        return null;
    }
    
    public Boolean eliminarEmpleado(String nombreEmpleado){
        List<Empleado> empleados = persistencia.getEmpleados();
        List<Empleado> temp = new LinkedList<>();
        for(Empleado empleado : empleados){
            if(!empleado.getNombre().equals(nombreEmpleado)){
                temp.add(empleado);
            }else{
                if(empleado.getRol().equals("Dentista")){
                    eliminarAgendaAsociada(empleado.getNombre());
                    eliminarCitasAsociadas(empleado.getNombre());
                }
            }
        }
        persistencia.actualizarEmpleados(temp);
        if(empleados.size() != temp.size()){
            return true;
        }else{
            return false;
        }
    }
    
    public void eliminarAgendaAsociada(String nombreDentista){
        List<Agenda> agendas = persistencia.getListaAgenda();
        List<Agenda> temp = new LinkedList<>();
        for(Agenda agenda :agendas){
            if(!agenda.getNombre().equals(nombreDentista)){
                temp.add(agenda);
            }
        }
        persistencia.actualizarDataBaseAgendas(temp);
    }
    
    public void eliminarCitasAsociadas(String nombreDentista){
        List<Cita> usuarios = persistencia.getListaCitas();
        List<Cita> nuevasCitas = new ArrayList<>();
        for(Cita cita: usuarios){
            if(!cita.getNombreDentista().equals(nombreDentista)){
                nuevasCitas.add(cita);
            }
        }
        persistencia.actualizarDataBaseCitas(nuevasCitas);
    }
    
    public boolean modificarEmpleado(String nombrePrevio, String nombre, String apellido, String email, String telefono, String direccion, String numLicencia, Date fechaNacimiento, Date fechaContratacion, String rol) {
        List<Empleado> empleados = persistencia.getEmpleados();  
        boolean empleadoModificado = false;
        for(Empleado empleado : empleados){
            if(empleado.getNombre().equals(nombrePrevio)){
                empleado.setNombre(nombre);
                empleado.setApellido(apellido);
                empleado.setEmail(email);
                empleado.setTelefono(telefono);
                empleado.setDireccion(direccion);
                empleado.setNumeroLicencia(numLicencia);
                empleado.setFechaNacimiento(fechaNacimiento);
                empleado.setFechaContratacion(fechaContratacion);
                empleado.setRol(rol);    
                empleadoModificado = true;
            }
        }
        persistencia.actualizarEmpleados(empleados);
        return empleadoModificado;
    }
    
    public List<Empleado> getEmpleados(){
        List<Empleado> empleados = persistencia.getEmpleados();
        return empleados;
    }

    public void desplegarMensaje(String mensaje){
        persistencia.desplegarMensaje(mensaje);
    }
    
}
