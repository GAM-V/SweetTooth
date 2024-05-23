/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.Citas;

import Modelo.CITAS.Cita;
import Modelo.CITAS.GestorCitas;
import Modelo.Pacientes.Paciente;
import Vista.Citas.GUIConsultarCitas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.*;

public class ControladorConsultarCita implements ActionListener{
    
    private GUIConsultarCitas guiConsultarCitas;
    private JComboBox CBCitaOpcion, CBPaciente;
    private JButton consultar;
    private GestorCitas gestorCitas;

    public ControladorConsultarCita(GUIConsultarCitas guiEliminarCita, JComboBox CBCitaOpcion, JComboBox CBPaciente, JButton consultar) {
        this.guiConsultarCitas = guiEliminarCita;
        this.CBCitaOpcion = CBCitaOpcion;
        this.CBPaciente = CBPaciente;
        this.consultar = consultar;
        this.gestorCitas = new GestorCitas();
    }
    
    public void iniciarContenido(){
        CBCitaOpcion.removeAllItems();
        CBPaciente.removeAllItems();
        List<Paciente> pacientes = gestorCitas.obtenerListaPacientes();
        for(Paciente paciente : pacientes){
            CBPaciente.addItem(paciente.getNombre());
        }
        CBCitaOpcion.setSelectedItem(null);
        guiConsultarCitas.vaciarContenido();
    }
    
    private void actualizarOpcionesCitas(){
        // Verificar si el objeto seleccionado en el JComboBox no es nulo
        if (CBPaciente.getSelectedItem() != null) {
            // Limpiar los elementos existentes en el JComboBox
            CBCitaOpcion.removeAllItems();
            // Obtener el nombre del paciente seleccionado
            String nombrePaciente = CBPaciente.getSelectedItem().toString();
            // Obtener la lista de citas del gestor de citas
            List<Cita> citas = gestorCitas.obtenerListaCitas();
            // Iterar sobre la lista de citas
            for (Cita cita : citas) {
                // Verificar si la cita pertenece al paciente seleccionado
                if (nombrePaciente.equals(cita.getNombrePaciente())) {
                    // Agregar el ID de la cita al JComboBox
                    CBCitaOpcion.addItem(cita.getId());
                }
            }
        } 
    }

    

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object seleccion = ae.getSource();
        if(seleccion == CBPaciente){
            actualizarOpcionesCitas();
        }
        if(seleccion == consultar){
            if(CBPaciente.getSelectedItem() != null && CBCitaOpcion.getSelectedItem() != null){
                List<Cita> citas  = gestorCitas.obtenerListaCitas();
                for(Cita cita : citas){
                    if(cita.getId().equals(CBCitaOpcion.getSelectedItem().toString())){
                        guiConsultarCitas.desplegarContenido(cita);
                    }
                }
            }else{
                gestorCitas.desplegarMensaje("Ningún campo debe estar vacio");
            } 
        }
    }
    
}
