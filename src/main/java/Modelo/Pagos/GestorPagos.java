/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Pagos;

import Modelo.CITAS.Cita;
import Modelo.Pacientes.Paciente;
import Modelo.Persistencia;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class GestorPagos {
    private Persistencia persistencia;
    private Impresora impresora;

    public GestorPagos() {
        this.impresora = new Impresora();
        this.persistencia = new Persistencia();
    }
    
    public List<Cita> obtenerCitasPendientes(String nombrePaciente){
        List<Cita> citas = persistencia.getListaCitas();
        
        List<Cita> temp = new LinkedList<>();
        for(Cita cita : citas){
            if(cita.getNombrePaciente().equals(nombrePaciente) && !cita.getPagada()){
                temp.add(cita);
            }
        }
        return temp;
    }
    
    public boolean realizarPago(String idCita, String nombrePaciente, String numeroTarjeta, String titular, Date fechaVencimiento, String cvv){
        TarjetaCredito tarjetaCredito = new TarjetaCredito(numeroTarjeta, titular, cvv, fechaVencimiento);
        Cita cita = getCita(idCita);
        actualizarCitaPagada(cita);
        Date fechaPago = new Date();
        Pago pago = new Pago(tarjetaCredito, cita, "$200", fechaPago);
        ReciboPago reciboPago = new ReciboPago(cita, pago);
        impresora.imprimir(reciboPago.toString());
        return true;
    }
    
    public List<Paciente> getPacientes(){
        return persistencia.getListaPacientes();
    }
    
    public Cita getCita(String id){
        return persistencia.buscarCita(id);
    }
    
    public void actualizarCitaPagada(Cita citaPagada){
        List<Cita> citas = persistencia.getListaCitas();
        for(Cita cita : citas){
            if(cita.getId().equals(citaPagada.getId())){
                cita.setPagada(true);
            }
        }
        persistencia.actualizarDataBaseCitas(citas);
    }
    
    public void desplegarMensaje(String mensaje){
        persistencia.desplegarMensaje(mensaje);
    }
}
