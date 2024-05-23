/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.Citas;

import Modelo.CITAS.Cita;
import Modelo.CITAS.GestorCitas;
import Modelo.Pacientes.Paciente;
import Vista.Citas.GUIEliminarCita;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.*;

public class ControladorEliminarCita implements ActionListener{
    
    private JComboBox CBCitaOpcion, CBPaciente;
    private JButton Confirmar;
    private GestorCitas gestorCitas;
    private GUIEliminarCita guiEliminarCita;

    public ControladorEliminarCita(GUIEliminarCita guiEliminarCita, JComboBox CitaOpcion, JComboBox Paciente, JButton Confirmar) {
        this.guiEliminarCita = guiEliminarCita;
        this.CBCitaOpcion = CitaOpcion;
        this.CBPaciente = Paciente;
        this.Confirmar = Confirmar;
        this.gestorCitas = new GestorCitas();
        
    }
    
    public void iniciarContenido(){
        CBCitaOpcion.removeAllItems();
        CBPaciente.removeAllItems();
        List<Paciente> pacientes = gestorCitas.obtenerListaPacientes();
        for(Paciente paciente : pacientes){
            CBPaciente.addItem(paciente.getNombre());
        }
        if(CBCitaOpcion.getSelectedItem()!= null){            
            CBCitaOpcion.setSelectedItem(null);
        }
        guiEliminarCita.vaciarContenido();
    }
    
    private void actualizarOpcionesCitas(){
        // Verificar si el objeto seleccionado en CBPaciente no es nulo
        if (CBPaciente.getSelectedItem() != null) {
            // Obtener el nombre del paciente seleccionado
            String nombrePaciente = CBPaciente.getSelectedItem().toString();
            // Limpiar los elementos existentes en el JComboBox CBCitaOpcion
            CBCitaOpcion.removeAllItems();
            // Obtener la lista de citas del gestor de citas
            List<Cita> citas = gestorCitas.obtenerListaCitas();
            // Iterar sobre la lista de citas
            for (Cita cita : citas) {
                // Verificar si la cita pertenece al paciente seleccionado
                if (cita.getNombrePaciente().equals(nombrePaciente)) {
                    // Agregar el ID de la cita al JComboBox CBCitaOpcion
                    CBCitaOpcion.addItem(cita.getId());
                }
            }
        }
    }


    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object seleccion = ae.getSource();
        if (seleccion == CBPaciente) {
            actualizarOpcionesCitas();
        }
        if (seleccion == CBCitaOpcion) {
            if (CBCitaOpcion.getSelectedItem() != null) {
                List<Cita> citas = gestorCitas.obtenerListaCitas();
                for (Cita cita : citas) {
                    if (cita.getId().equals(CBCitaOpcion.getSelectedItem().toString())) {
                        guiEliminarCita.desplegarContenido(cita);
                    }
                }
            }
        }
        if (seleccion == Confirmar) {
            if (CBPaciente.getSelectedItem() != null && CBCitaOpcion.getSelectedItem() != null) {
                List<Cita> citas = gestorCitas.obtenerListaCitas();
                for (Cita cita : citas) {
                    if (cita.getId().equals(CBCitaOpcion.getSelectedItem().toString())) {
                        gestorCitas.eliminarCita(cita.getId());
                        iniciarContenido(); // Para limpiar la GUI después de eliminar la cita
                    }
                }
            } else {
                gestorCitas.desplegarMensaje("Ningún campo debe estar vacío");
            }
        }
    }

    
}
