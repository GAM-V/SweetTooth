/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Pagos;

import Modelo.CITAS.Cita;
import java.util.Date;

public class Pago {
    private String nombreCliente, idCita, costo, motivo;
    private Date fechaPago;

    public Pago(TarjetaCredito tarjetaCredito, Cita cita, String costo, Date fechaPago) {
        this.nombreCliente = tarjetaCredito.getTitular();
        this.idCita = cita.getId();
        this.costo = costo;
        this.motivo = cita.getMotivo();
        this.fechaPago = fechaPago;
    }

    public String getCosto() {
        return costo;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getIdCita() {
        return idCita;
    }

    public void setIdCita(String idCita) {
        this.idCita = idCita;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }
    
     
}
