/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Modelo.Pacientes.Paciente;
import Modelo.USUARIOS.Usuario;
import Modelo.CITAS.Agenda;
import Modelo.CITAS.Cita;
import Modelo.Empleados.Empleado;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;

public class Persistencia {

    public Persistencia() {
    }
    
    public void desplegarMensaje(String mensaje){
        JOptionPane.showMessageDialog(null, mensaje, "Alerta", JOptionPane.INFORMATION_MESSAGE);
    }
    
    

    public static String obtenerDirectorio(){
        String carpetaUsuario = System.getProperty("user.home");
        return Paths.get(carpetaUsuario, "DataBaseSweetTooth").toString();
        
    }
    
    public  void verificarYCrearDirectorio(){
        String rutaDirectorio = obtenerDirectorio();
        Path patDirectorio = Paths.get(rutaDirectorio);
        
        if(!Files.exists(patDirectorio)){
            try {
                Files.createDirectory(patDirectorio);
                System.out.println("Directorio creado");
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        else{
            System.out.println("El directorio ya existe");
        }
    }
    
    // obtener informacion
    
    
    //-----------------DENTISTAS-----------------------
    
    public List<Empleado> getDentistas() {
        String rutaArchivo = Paths.get(obtenerDirectorio(), "Empleados.json").toString();
        System.out.println(obtenerDirectorio());
        Path pathArchivo = Paths.get(rutaArchivo);

        if (Files.exists(pathArchivo)) {
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                Empleado[] empleadosArray = objectMapper.readValue(pathArchivo.toFile(), Empleado[].class);
                List<Empleado> empleados = new ArrayList<>(Arrays.asList(empleadosArray));
                List<Empleado> dentistas = new ArrayList<>();
                for(Empleado empleado : empleados){
                    if(empleado.getRol().equals("Dentista")){
                        dentistas.add(empleado);
                    }
                }
                System.out.println("Dentistas leídos desde: " + rutaArchivo);
                return dentistas;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new ArrayList<>();  // Devuelve una lista vacía si hay un error o el archivo no existe
    }
    
    
    
    //-----------------Empleados-----------------------
    
    public List<Empleado> getEmpleados() {
        String rutaArchivo = Paths.get(obtenerDirectorio(), "Empleados.json").toString();
        System.out.println(obtenerDirectorio());
        Path pathArchivo = Paths.get(rutaArchivo);

        if (Files.exists(pathArchivo)) {
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                Empleado[] empleadosArray = objectMapper.readValue(pathArchivo.toFile(), Empleado[].class);
                List<Empleado> empleados = new ArrayList<>(Arrays.asList(empleadosArray));
                System.out.println("Dentistas leídos desde: " + rutaArchivo);
                return empleados;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new ArrayList<>();  // Devuelve una lista vacía si hay un error o el archivo no existe
    }
    
    public void actualizarEmpleados(List<Empleado> empleados) {
        String rutaArchivo = Paths.get(obtenerDirectorio(), "Empleados.json").toString();
        Path pathArchivo = Paths.get(rutaArchivo);

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            objectMapper.writeValue(pathArchivo.toFile(), empleados);
            System.out.println("Empleados actualizadas en: " + rutaArchivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    // ----------------------CITAS---------------------------

    public List<Cita> getListaCitas() {
        String rutaArchivo = Paths.get(obtenerDirectorio(), "Citas.json").toString();
        Path pathArchivo = Paths.get(rutaArchivo);

        if (Files.exists(pathArchivo)) {
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                Cita[] citasArray = objectMapper.readValue(pathArchivo.toFile(), Cita[].class);
                List<Cita> citas = new ArrayList<>(Arrays.asList(citasArray));
                System.out.println("Citas leídas desde: " + rutaArchivo);
                return citas;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new ArrayList<>(); // Devuelve una lista vacía si hay un error o el archivo no existe
    }
    
    public void actualizarDataBaseCitas(List<Cita> citas) {
        String rutaArchivo = Paths.get(obtenerDirectorio(), "Citas.json").toString();
        Path pathArchivo = Paths.get(rutaArchivo);

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            objectMapper.writeValue(pathArchivo.toFile(), citas);
            System.out.println("Citas actualizados en: " + rutaArchivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public Cita buscarCita(String idCita) {
        List<Cita> lista = this.getListaCitas();
        for (Cita cita : lista) {
            System.out.println(cita);
            if (cita.getId().equals(idCita)) {
                return cita;
            }
        }
        return null;
    }
    
    //-------------------AGENDA--------------------
    
    public List<Agenda> getListaAgenda() {
        String rutaArchivo = Paths.get(obtenerDirectorio(), "Agendas.json").toString();
        Path pathArchivo = Paths.get(rutaArchivo);

        if (Files.exists(pathArchivo)) {
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                Agenda[] agendasArray = objectMapper.readValue(pathArchivo.toFile(), Agenda[].class);
                List<Agenda> agendas = new ArrayList<>(Arrays.asList(agendasArray));
                System.out.println("Agendas leídas desde: " + rutaArchivo);
                return agendas;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new ArrayList<>(); // Devuelve una lista vacía si hay un error o el archivo no existe
    }
    
    public void actualizarDataBaseAgendas(List<Agenda> agendas) {
        String rutaArchivo = Paths.get(obtenerDirectorio(), "Agendas.json").toString();
        Path pathArchivo = Paths.get(rutaArchivo);

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            objectMapper.writeValue(pathArchivo.toFile(), agendas);
            System.out.println("Agendas actualizados en: " + rutaArchivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    //-------------------USUARIOS----------------------------

    public List<Usuario> getListaUsuarios() {
        String rutaArchivo = Paths.get(obtenerDirectorio(), "DBUsuarios.json").toString();
        Path pathArchivo = Paths.get(rutaArchivo);

        if (Files.exists(pathArchivo)) {
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                Usuario[] usuariosArray = objectMapper.readValue(pathArchivo.toFile(), Usuario[].class);
                List<Usuario> usuarios = new ArrayList<>(Arrays.asList(usuariosArray));
                System.out.println("Usuarios leídos desde: " + rutaArchivo);
                return usuarios;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new ArrayList<>(); // Devuelve una lista vacía si hay un error o el archivo no existe
    }
    
    public void actualizarDataBaseUsuarios(List<Usuario> usuarios) {
        String rutaArchivo = Paths.get(obtenerDirectorio(), "DBUsuarios.json").toString();
        Path pathArchivo = Paths.get(rutaArchivo);

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            objectMapper.writeValue(pathArchivo.toFile(), usuarios);
            System.out.println("Usuarios actualizados en: " + rutaArchivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public Usuario buscarUsuario(String nombreUsuario) {
        List<Usuario> lista = this.getListaUsuarios();
        for (Usuario usuario : lista) {
            System.out.println(usuario);
            if (usuario.getNombreUsuario().equals(nombreUsuario)) {
                return usuario;
            }
        }
        return null;
    }
    
    //---------------------PACIENTES--------------------------

    public List<Paciente> getListaPacientes() {
        String rutaArchivo = Paths.get(obtenerDirectorio(), "Pacientes.json").toString();
        Path pathArchivo = Paths.get(rutaArchivo);

        if (Files.exists(pathArchivo)) {
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                Paciente[] pacientesArray = objectMapper.readValue(pathArchivo.toFile(), Paciente[].class);
                List<Paciente> pacientes = new ArrayList<>(Arrays.asList(pacientesArray));
                System.out.println("Pacientes leídos desde: " + rutaArchivo);
                return pacientes;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new ArrayList<>(); // Devuelve una lista vacía si hay un error o el archivo no existe
    }
    
    public void actualizarDataBasePacientes(List<Paciente> pacientes) {
        String rutaArchivo = Paths.get(obtenerDirectorio(), "Pacientes.json").toString();
        Path pathArchivo = Paths.get(rutaArchivo);

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            objectMapper.writeValue(pathArchivo.toFile(), pacientes);
            System.out.println("Pacientes actualizados en: " + rutaArchivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public Paciente buscarPaciente(String nombreCliente) {
        List<Paciente> lista = this.getListaPacientes();
        for (Paciente paciente : lista) {
            System.out.println(paciente);
            if (paciente.getNombre().equals(nombreCliente)) {
                return paciente;
            }
        }
        return null;
    }
    
    
}
