/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Pacientes;

import Modelo.CITAS.Cita;
import Modelo.Persistencia;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class GestorPacientes {
    
    private Persistencia persistencia;

    public GestorPacientes() {
        this.persistencia = new Persistencia();
    }
    
    
    
    public boolean registrarPaciente(String nombre, String apellido, String email, String telefono, String direccion, Date fechaNacimiento) {
        Random random = new Random();
        int numero = random.nextInt(10000);
        String id = String.format("%04d", numero);
        
        Paciente nuevoPaciente = new Paciente();
        nuevoPaciente.setIdPaciente(id);
        nuevoPaciente.setNombre(nombre);
        nuevoPaciente.setApellido(apellido);
        nuevoPaciente.setEmail(email);
        nuevoPaciente.setTelefono(telefono);
        nuevoPaciente.setDireccion(direccion);
        nuevoPaciente.setFechaNacimiento(fechaNacimiento);        
        List<Paciente> pacientes = persistencia.getListaPacientes();
        pacientes.add(nuevoPaciente);
        persistencia.actualizarDataBasePacientes(pacientes);
        return true;
    }
    
    public Paciente consultarPaciente(String nombreEmpleado){
        List<Paciente> Pacientes = persistencia.getListaPacientes();
        for(Paciente paciente : Pacientes){
            if(paciente.getNombre().equals(nombreEmpleado)){
                return paciente;
            }
        }
        return null;
    }
    
    public Boolean eliminarPaciente(String nombrePaciente){
        List<Paciente> pacientes = persistencia.getListaPacientes();
        List<Paciente> temp = new LinkedList<>();
        for(Paciente paciente : pacientes){
            if(!paciente.getNombre().equals(nombrePaciente)){
                temp.add(paciente);
            }
        }
        persistencia.actualizarDataBasePacientes(temp);
        if(pacientes.size() != temp.size()){
            eliminarCitasAsociadas(nombrePaciente);
            return true;
        }else{
            return false;
        }
    }
    
    public void eliminarCitasAsociadas(String nombrePaciente){
        List<Cita> citas = persistencia.getListaCitas();
        List<Cita> nuevasCitas = new ArrayList<>();
        for(Cita cita: citas){
            if(!cita.getNombrePaciente().equals(nombrePaciente)){
                nuevasCitas.add(cita);
            }
        }
        persistencia.actualizarDataBaseCitas(nuevasCitas);
    }
    
    
    public boolean modificarPaciente(String nombrePrevio, String nombre, String apellido, String email, String telefono, String direccion, Date fechaNacimiento) {
        List<Paciente> pacientes = persistencia.getListaPacientes();  
        boolean pacienteModificado = false;
        for(Paciente empleado : pacientes){
            if(empleado.getNombre().equals(nombrePrevio)){
                empleado.setNombre(nombre);
                empleado.setApellido(apellido);
                empleado.setEmail(email);
                empleado.setTelefono(telefono);
                empleado.setDireccion(direccion);
                empleado.setFechaNacimiento(fechaNacimiento);
                pacienteModificado = true;
            }
        }
        persistencia.actualizarDataBasePacientes(pacientes);
        return pacienteModificado;
    }
    
    public List<Paciente> getPacientes(){
        List<Paciente> pacientes = persistencia.getListaPacientes();
        return pacientes;
    }

    public void desplegarMensaje(String mensaje){
        persistencia.desplegarMensaje(mensaje);
    }
    
}
