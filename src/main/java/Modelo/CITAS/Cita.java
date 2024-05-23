/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.CITAS;
import java.util.Date;

public class Cita {
    
    private String id;
    private Date fecha;
    private String hora;
    private String nombrePaciente;
    private String nombreDentista;
    private String duracion;
    private String motivo;
    private boolean pagada;

    public Cita() {
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public String getNombreDentista() {
        return nombreDentista;
    }

    public void setNombreDentista(String nombreDenstista) {
        this.nombreDentista = nombreDenstista;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public boolean getPagada() {
        return pagada;
    }

    public void setPagada(boolean pagada) {
        this.pagada = pagada;
    }
    
    

    public String toString() {
        return "Cita{" +
                "id='" + id + '\'' +
                ", fecha='" + fecha + '\'' +
                ", hora='" + hora + '\'' +
                ", nombrePaciente='" + nombrePaciente + '\'' +
                ", nombreDentista='" + nombreDentista + '\'' +
                ", duracion='" + duracion + '\'' +
                ", motivo='" + motivo + '\'' +
                ", pagada='" + pagada + '\'' +
                '}';
    }
    
    
}
