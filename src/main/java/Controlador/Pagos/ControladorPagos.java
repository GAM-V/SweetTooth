/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.Pagos;

import Modelo.CITAS.Cita;
import Modelo.Pacientes.Paciente;
import Modelo.Pagos.GestorPagos;
import Vista.Pagos.GUIPagos;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.*;

public class ControladorPagos implements ActionListener{
    private GUIPagos guiPagos;
    private JButton confirmar;
    private JComboBox paciente, citas;
    private JTextField numeroTarjeta, titular, cvv;
    private JDateChooser fechaVencimiento;
    private GestorPagos gestorPagos;
    

    public ControladorPagos(GUIPagos guiPagos, JButton confirmar, JComboBox paciente, JComboBox citas, JTextField numeroTarjeta, JTextField titular, JTextField cvv, JDateChooser fechaVencimiento) {
        this.guiPagos = guiPagos;
        this.confirmar = confirmar;
        this.paciente = paciente;
        this.citas = citas;
        this.numeroTarjeta = numeroTarjeta;
        this.titular = titular;
        this.cvv = cvv;
        this.fechaVencimiento = fechaVencimiento;
        this.gestorPagos = new GestorPagos();        
        this.citas.removeAllItems();
        this.paciente.removeAllItems();
        setContenido();
    }

    private void limiarCampos(){
        citas.setSelectedItem(null);
        paciente.setSelectedItem(null);
        numeroTarjeta.setText("");
        titular.setText("");
        cvv.setText("");
        fechaVencimiento.setDate(null);
    }
    
    private void setContenido(){
        List<Paciente> pacientes = gestorPagos.getPacientes();
        if(!pacientes.isEmpty()){
            for(Paciente paciente : pacientes){
                this.paciente.addItem(paciente.getNombre());
            }
        }
        this.paciente.setSelectedItem(null);
    }
    
    private void setCitas(List<Cita> citasPendientes){
        citas.removeAllItems();
        if(!citasPendientes.isEmpty()){                    
            for(Cita cita: citasPendientes){
                citas.addItem(cita.getId());
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object seleccion = ae.getSource();
        if(seleccion == confirmar){
            if(paciente.getSelectedItem() != null && citas.getSelectedItem() != null && numeroTarjeta.getText() != null && titular.getText() != null && cvv.getText() != null && fechaVencimiento.getDate() != null){
                boolean pagoRealizado = gestorPagos.realizarPago(citas.getSelectedItem().toString(), paciente.getSelectedItem().toString(), numeroTarjeta.getText(), titular.getText(), fechaVencimiento.getDate(), cvv.getText());
                if(pagoRealizado){
                    gestorPagos.desplegarMensaje("Pago realizado");
                    limiarCampos();
                }else{
                    gestorPagos.desplegarMensaje("Error al realizar el pago");
                }
            }else{
                gestorPagos.desplegarMensaje("Ningun campo debe estar vacio");
            }
        }
        if(seleccion == paciente){
            if(paciente.getSelectedItem() != null){
                List<Cita> citasPendientes = gestorPagos.obtenerCitasPendientes(paciente.getSelectedItem().toString());      
                setCitas(citasPendientes);
            }
        }

    }
    
}
