/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.Citas;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Vista.Citas.GUIAgendCita;
import Vista.Citas.GUIEliminarCita;
import Vista.Citas.GUIConsultarCitas;
import Vista.Citas.GUICitas;


public class ControladorCitas implements ActionListener {
    
    private JButton agendar, eliminar, consultar;
    private GUICitas citas;
    private GUIAgendCita guiAgendar;
    private GUIEliminarCita guiEliminar;
    private GUIConsultarCitas guiConsultar;
    

    public ControladorCitas(JButton agendar, JButton eliminar, JButton consultar, GUICitas citas) {
        this.agendar = agendar;
        this.eliminar = eliminar;
        this.consultar = consultar;
        this.citas = citas;
  
    }
    
    
    
    public void actionPerformed(ActionEvent ae){
        Object seleccion = ae.getSource();
        if(seleccion == this.agendar){
            this.guiAgendar = new GUIAgendCita();
            citas.setContenido(guiAgendar.getContenido());
        }
        if(seleccion == this.eliminar){
            this.guiEliminar = new GUIEliminarCita();
            citas.setContenido(guiEliminar.getContenido());
        }
        if(seleccion == this.consultar){
            this.guiConsultar = new GUIConsultarCitas();
            citas.setContenido(guiConsultar.getContenido());
        }
    }

    

}
