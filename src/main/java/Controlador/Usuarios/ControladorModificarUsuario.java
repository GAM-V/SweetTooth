/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.Usuarios;

import Modelo.USUARIOS.GestorUsuario;
import Modelo.USUARIOS.Usuario;
import Vista.Usuarios.GUIModificarUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.*;

public class ControladorModificarUsuario implements ActionListener{
    
    private GUIModificarUsuario guiModificarUsuario;
    private GestorUsuario gestorUsuario;
    private JTextField nombreUsuario, contraseña, correo;
    private JComboBox nivelAcceso, usuarioOpcion;
    private JButton confirmarRegistro;

    public ControladorModificarUsuario(GUIModificarUsuario guiModificarUsuario, JTextField nombreUsuario, JTextField contraseña, JTextField correo, JComboBox nivelAcceso,JComboBox usuarioOpcion,  JButton confirmarRegistro) {
        this.guiModificarUsuario = guiModificarUsuario;
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
        this.correo = correo;
        this.nivelAcceso = nivelAcceso;
        this.usuarioOpcion = usuarioOpcion;
        this.confirmarRegistro = confirmarRegistro;
        this.gestorUsuario = new GestorUsuario();
        nivelAcceso.removeAllItems();
        nivelAcceso.addItem("1");
        nivelAcceso.addItem("2");
        setOpciones();
    }
    
    public void vaciarContenido(){
        this.nombreUsuario.setText("");
        this.correo.setText("");
        this.contraseña.setText("");
        this.nivelAcceso.setSelectedItem(null);
    }
    
    private void setOpciones(){
        usuarioOpcion.removeAllItems();
        List<Usuario> usuarios = gestorUsuario.getListaUsuarios();
        for(Usuario usuario: usuarios){
            usuarioOpcion.addItem(usuario.getNombreUsuario());
        }
    }
    
    private void setInformacionUsuario(String nombreUsuario){
        List<Usuario> usuarios = gestorUsuario.getListaUsuarios();
        for(Usuario usuario : usuarios){
            if(usuario.getNombreUsuario().equals(nombreUsuario)){
                this.nombreUsuario.setText(usuario.getNombreUsuario());
                this.correo.setText(usuario.getCorreo());
                this.contraseña.setText(usuario.getContrasena());
                this.nivelAcceso.setSelectedItem(usuario.getNivelAcceso());
            }
        }        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object seleccion = ae.getSource();
        if(seleccion == usuarioOpcion){
            if(usuarioOpcion.getSelectedItem() != null){
                setInformacionUsuario(usuarioOpcion.getSelectedItem().toString());
                
            }
        }
        if(seleccion == confirmarRegistro){
            if(!nombreUsuario.getText().isEmpty() && !contraseña.getText().isEmpty() && !correo.getText().isEmpty()&& nivelAcceso.getSelectedItem()!= null && usuarioOpcion.getSelectedItem() != null){                
                boolean usuarioModificado = gestorUsuario.modificarUsuario(usuarioOpcion.getSelectedItem().toString(), nombreUsuario.getText(), correo.getText(), contraseña.getText(), nivelAcceso.getSelectedItem().toString());
                if(usuarioModificado){
                    setOpciones();
                    gestorUsuario.desplegarMensaje("Usuario Modificado");
                }else{
                    gestorUsuario.desplegarMensaje("Error al modificar el usuario");                
                }
            }else{
                gestorUsuario.desplegarMensaje("Ningun campo debe estar vacio");
            }
        }
    }
    
}
