/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.CITAS;

import Modelo.Pacientes.Paciente;
import Modelo.Empleados.Empleado;
import Modelo.Persistencia;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class GestorCitas {
    Persistencia persistencia;

    public GestorCitas() {
        persistencia = new Persistencia();
    }
    
    
    public List<Empleado> obtenerListaDentistas(){
        return  persistencia.getDentistas();
    }
    
    public List<Paciente> obtenerListaPacientes(){
        return persistencia.getListaPacientes();
    }
    public List<Agenda> obtenerListaAgendas(){
        return persistencia.getListaAgenda();
    }
    public List<Cita> obtenerListaCitas(){
        return persistencia.getListaCitas();
    }
    
    public void registrarCita(Date fecha, String hora, String nombrePaciente, String nombreDentista, String motivo){
        Cita cita = new Cita();
        
        Random random = new Random();
        // Genera un número aleatorio entre 0 y 9999 (ambos inclusive)
        int numero = random.nextInt(10000);
        // Formatea el número como una cadena de 4 dígitos (rellenando con ceros a la izquierda si es necesario)
        String id = String.format("%04d", numero);

        cita.setId(id);
        cita.setFecha(fecha);
        cita.setHora(hora);
        cita.setNombrePaciente(nombrePaciente);
        cita.setNombreDentista(nombreDentista);
        cita.setDuracion("1 hora");
        cita.setMotivo(motivo);
        cita.setPagada(false);

        List<Cita> citasTemp = persistencia.getListaCitas();
        citasTemp.add(cita);
        persistencia.actualizarDataBaseCitas(citasTemp);

        // Crear una instancia de Calendar y establecer la fecha en el objeto Date
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);

        // Obtener el día del mes
        int dia = calendar.get(Calendar.DAY_OF_MONTH);
        registrarEnAgenda(dia, nombreDentista, hora);
    }
    private void registrarEnAgenda(int dia, String nombreDentista, String hora){
        //Actualizar agenda
        List<Agenda> agendas = persistencia.getListaAgenda();

        for(Agenda agenda : agendas){
            if(agenda.getNombre().equals(nombreDentista)){
                agenda.marcarHorarioNoDisponible(dia, hora);
            }
        }
        persistencia.actualizarDataBaseAgendas(agendas);
        persistencia.desplegarMensaje("Cita registrada ");

    }
    
    private void eliminarEnagenda(int dia, String nombreDentista, String hora){
        //Actualizar agenda
        List<Agenda> agendas = persistencia.getListaAgenda();

        for(Agenda agenda : agendas){
            if(agenda.getNombre().equals(nombreDentista)){
                agenda.marcarHorarioDisponible(dia, hora);
            }
        }
        persistencia.actualizarDataBaseAgendas(agendas);
    }
    
    public void eliminarCita(String ID){
        List<Cita> usuarios = persistencia.getListaCitas();
        List<Cita> nuevasCitas = new ArrayList<>();
        for(Cita cita: usuarios){
            if(!cita.getId().equals(ID)){
                nuevasCitas.add(cita);
                // Crear una instancia de Calendar y establecer la fecha en el objeto Date
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(cita.getFecha());

                // Obtener el día del mes
                int dia = calendar.get(Calendar.DAY_OF_MONTH);
                eliminarEnagenda(dia, cita.getNombreDentista(), cita.getHora());
            }
        }
        persistencia.actualizarDataBaseCitas(nuevasCitas);
        desplegarMensaje("Cita eliminada");
        
    }
    
    public void desplegarMensaje(String mensaje){
        persistencia.desplegarMensaje(mensaje);
    }
    
    
    
}
