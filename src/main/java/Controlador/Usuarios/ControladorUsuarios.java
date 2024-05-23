/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.Usuarios;
import Modelo.USUARIOS.GestorUsuario;
import Vista.Usuarios.GUIUsuarios;
import Vista.Usuarios.GUIRegistrarUsuario;
import Vista.Usuarios.GUIMostrarInformacionUsuario;
import Vista.Usuarios.GUIEliminarUsuario;
import Vista.Usuarios.GUIModificarUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ControladorUsuarios implements ActionListener{
    private GestorUsuario gestorUsuario;
    private JButton registrar, mostrar, eliminar, modificar; 
    private GUIUsuarios guiUsuarios;
    private GUIRegistrarUsuario guiRegistrarUsuario;
    private GUIModificarUsuario guiModificarUsuario;
    private GUIEliminarUsuario guiEliminarUsuario;
    private GUIMostrarInformacionUsuario guiMostrarInformacionUsuario;

    public ControladorUsuarios(JButton registrar, JButton mostrar, JButton eliminar, JButton modificar, GUIUsuarios guiUsuarios) {
        this.registrar = registrar;
        this.mostrar = mostrar;
        this.eliminar = eliminar;
        this.modificar = modificar;
        this.guiUsuarios = guiUsuarios;
        this.gestorUsuario = new GestorUsuario();   

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object seleccion = ae.getSource();
        if(seleccion == registrar){
            this.guiRegistrarUsuario = new GUIRegistrarUsuario();
            guiUsuarios.setContenido(guiRegistrarUsuario.getContenido());
        }
        if(seleccion == mostrar){
            this.guiMostrarInformacionUsuario = new GUIMostrarInformacionUsuario();
            guiUsuarios.setContenido(guiMostrarInformacionUsuario.getContenido());
        }
        if(seleccion == eliminar){
            this.guiEliminarUsuario = new GUIEliminarUsuario();
            guiUsuarios.setContenido(guiEliminarUsuario.getContenido());
        }
        if(seleccion == modificar){
            this.guiModificarUsuario = new GUIModificarUsuario();
            guiUsuarios.setContenido(guiModificarUsuario.getContenido());
        }
    }
}
