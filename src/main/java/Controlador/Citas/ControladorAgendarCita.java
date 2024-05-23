/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.Citas;

import Modelo.CITAS.Agenda;
import Modelo.CITAS.GestorCitas;
import Modelo.Pacientes.Paciente;
import Modelo.Empleados.Empleado;
import Vista.Citas.GUIAgendCita;
import com.toedter.calendar.JCalendar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.*;


public class ControladorAgendarCita implements ActionListener, PropertyChangeListener{
    
    private GUIAgendCita guiAgendarCita;
    private GestorCitas gestorCitas;
    private JComboBox CBDentista, CBHora, CBPAcientes;
    private JButton confirmar;
    private JCalendar calendario;
    private JTextArea Motivo;

    public ControladorAgendarCita(GUIAgendCita guiAgendarCita, JComboBox CBDentista, JComboBox CBHora, JComboBox CBPacientes, JButton confirmar, JCalendar calendario, JTextArea Motivo) {
        this.gestorCitas = new GestorCitas();
        this.guiAgendarCita = guiAgendarCita;
        this.CBDentista = CBDentista;
        this.CBHora = CBHora;
        this.CBPAcientes = CBPacientes;
        this.confirmar = confirmar;
        this.calendario = calendario;
        this.Motivo = Motivo;
        iniciarContenido();
        
    }
    
    private void iniciarContenido(){
        CBDentista.removeAllItems();
        CBPAcientes.removeAllItems();
        CBHora.removeAllItems();
        setDentistas();
        CBDentista.setSelectedItem(null);
        setPacientes();
        CBPAcientes.setSelectedItem(null);
        CBHora.setSelectedItem(null);
        this.Motivo.setText("");
        // Crear un objeto Date para representar el 1 de mayo de 2024
        Calendar calendar = Calendar.getInstance();
        calendar.set(2024, Calendar.MAY, 1);
        Date fechaSeleccionada = calendar.getTime();

        // Seleccionar el día en el JCalendar
        calendario.setDate(fechaSeleccionada);
        actualizarHoras();
        
    }
    
    private void actualizarHoras(){
        // Verificar si hay un elemento seleccionado en el JComboBox CBDentista
        if (CBDentista.getSelectedItem() != null) {
            // Obtener la fecha seleccionada en el JCalendar
            Date fechaSeleccionada = calendario.getDate();
            // Crear una instancia de Calendar y establecer la fecha en el objeto Date
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(fechaSeleccionada);

            // Obtener el día del mes
            int dia = calendar.get(Calendar.DAY_OF_MONTH);

            List<Agenda> agendas = gestorCitas.obtenerListaAgendas();
            for(Agenda agenda: agendas){
                // Verificar si el objeto seleccionado del JComboBox CBDentista no es nulo
                if(CBDentista.getSelectedItem().toString().equals(agenda.getNombre())){
                    List<String> horarios = agenda.obtenerHorariosDisponiblesLista(dia);
                    setHoras(horarios);
                }
            }
        } else {
            // Manejar el caso cuando no hay ningún dentista seleccionado
            // Por ejemplo, puedes mostrar un mensaje de error o realizar otra acción apropiada
            // Aquí, por simplicidad, no se hará nada
        }
    }

    
    public void setDentistas(){
        List<Empleado> dentistas = gestorCitas.obtenerListaDentistas();
        for(Empleado dentista : dentistas){
            CBDentista.addItem(dentista.getNombre());  
        } 
    }
    
    public void setPacientes(){
        List<Paciente> pacientes = gestorCitas.obtenerListaPacientes();
        for(Paciente paciente : pacientes){
            CBPAcientes.addItem(paciente.getNombre());  
        } 
    }
    
    public void setHoras(List<String> horas){
        CBHora.removeAllItems();
        for(String hora : horas){
            CBHora.addItem(hora);  
        } 
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object seleccion = ae.getSource();
        if(seleccion == CBDentista){
            actualizarHoras();
        }
        if(seleccion == confirmar){
            if(calendario.getDate()!= null && CBHora.getSelectedItem() != null && CBPAcientes.getSelectedItem() != null && CBDentista.getSelectedItem() != null && Motivo.getText() != null){
                gestorCitas.registrarCita(calendario.getDate(), CBHora.getSelectedItem().toString(), CBPAcientes.getSelectedItem().toString(), CBDentista.getSelectedItem().toString(), Motivo.getText());
                iniciarContenido();
            }else{
                gestorCitas.desplegarMensaje("Ningún campo debe estar vacio");
            }
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        actualizarHoras();
    }
    
    
}
