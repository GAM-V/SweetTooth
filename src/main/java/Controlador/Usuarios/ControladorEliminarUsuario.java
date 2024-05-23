/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.Usuarios;

import Modelo.USUARIOS.GestorUsuario;
import Modelo.USUARIOS.Usuario;
import Vista.Usuarios.GUIEliminarUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.*;

public class ControladorEliminarUsuario implements ActionListener{
    
    private GUIEliminarUsuario guiEliminarUsuario;
    private GestorUsuario gestorUsuarios;
    private JLabel nombre, correo, tipo;
    private JComboBox usuarioOpcion;
    private JButton eliminar;

    public ControladorEliminarUsuario(GUIEliminarUsuario guiEliminarUsuario, JLabel nombre, JLabel correo, JLabel tipo, JComboBox usuarioOpcion, JButton eliminar) {
        this.guiEliminarUsuario = guiEliminarUsuario;
        this.nombre = nombre;
        this.correo = correo;
        this.tipo = tipo;
        this.usuarioOpcion = usuarioOpcion;
        this.eliminar = eliminar;
        this.gestorUsuarios = new GestorUsuario();
        vaciarContenido();
        setOpciones();
        usuarioOpcion.setSelectedItem(null);
    }
    
    private void vaciarContenido(){
        this.nombre.setText("");
        this.correo.setText("");
        this.tipo.setText("");
    }
    
    public void mostrarInformacion(String nombre){
        Usuario usuario = gestorUsuarios.consultarUsuario(nombre);
        vaciarContenido();
        if(usuario != null){
            String Nombre = "Nombre: " + usuario.getNombreUsuario();
            String correo = "Correo: " + usuario.getCorreo();
            String tipo = "Nivel: " + usuario.getNivelAcceso();
            this.nombre.setText(Nombre);
            this.correo.setText(correo);
            this.tipo.setText(tipo);
        }
    }
    
    private void setOpciones(){
        this.usuarioOpcion.removeAllItems();
        List<Usuario> usuarios = gestorUsuarios.getListaUsuarios();
        for(Usuario usuario: usuarios){
            usuarioOpcion.addItem(usuario.getNombreUsuario());
        }
    }
    
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object seleccion = ae.getSource();
        if(seleccion == usuarioOpcion){
            vaciarContenido();
            if(usuarioOpcion.getSelectedItem() != null){
                mostrarInformacion(usuarioOpcion.getSelectedItem().toString());
                
            }
        }
        if(seleccion == eliminar){
            if(usuarioOpcion.getSelectedItem() != null){
                boolean eliminado = gestorUsuarios.eliminarUsuario(usuarioOpcion.getSelectedItem().toString());
                if(eliminado){
                    gestorUsuarios.desplegarMensaje("Usuario eliminado");
                    vaciarContenido();
                    setOpciones();
                }else{
                    gestorUsuarios.desplegarMensaje("EL usuario no se pudo eliminar");                    
                }
            }else{
                gestorUsuarios.desplegarMensaje("Selecciona un usuario");
            }
        }
    }
    
}
