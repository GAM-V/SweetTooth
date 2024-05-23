/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Pagos;

import Modelo.CITAS.Cita;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReciboPago {
    private String nombreCliente, idCita, costo, motivo;
    private Date fechaCita, fechaPago;

    public ReciboPago(Cita cita, Pago pago) {
        this.nombreCliente = pago.getNombreCliente();
        this.idCita = cita.getId();
        this.costo = pago.getCosto();
        this.motivo = cita.getMotivo();
        this.fechaCita = cita.getFecha();
        this.fechaPago = pago.getFechaPago();
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

    public String getCosto() {
        return costo;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Date getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(Date fechaCita) {
        this.fechaCita = fechaCita;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }
    
    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        return "ReciboPago\n" +
                "nombreCliente; " + nombreCliente + "\n" +
                ", idCita: " + idCita + "\n" +
                ", costo; " + costo + "\n" +
                ", motivo: " + motivo + "\n" +
                ", fechaCita: " + dateFormat.format(fechaCita) +"\n" +
                ", fechaPago: " + dateFormat.format(fechaPago);
    }
    
}
