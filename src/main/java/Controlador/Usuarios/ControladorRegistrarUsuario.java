/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.Usuarios;

import Modelo.USUARIOS.GestorUsuario;
import Modelo.USUARIOS.Usuario;
import Vista.Usuarios.GUIRegistrarUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.*;

public class ControladorRegistrarUsuario implements ActionListener{
    private GUIRegistrarUsuario guiRegistrarUsuario;
    private GestorUsuario gestorUsuario;
    private JTextField nombreUsuario, contraseña, correo;
    private JComboBox nivelAcceso;
    private JButton confirmarRegistro;

    public ControladorRegistrarUsuario(JTextField nombreUsuario, JTextField contraseña, JTextField correo, JComboBox nivelAcceso, JButton confirmarRegistro, GUIRegistrarUsuario guiRegistrarUsuario) {
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
        this.correo = correo;
        this.nivelAcceso = nivelAcceso;
        this.confirmarRegistro = confirmarRegistro;
        this.gestorUsuario = new GestorUsuario();
        this.guiRegistrarUsuario = guiRegistrarUsuario;
        vaciarContenido();
    }
    
    public void vaciarContenido(){
        nombreUsuario.setText("");
        correo.setText("");
        contraseña.setText("");
        nivelAcceso.setSelectedIndex(0);
    }
    
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object seleccion = ae.getSource();
        // TODO add your handling code here:
        if(seleccion == confirmarRegistro){
            
            if(!nombreUsuario.getText().isEmpty() && !contraseña.getText().isEmpty() && !correo.getText().isEmpty()&& nivelAcceso.getSelectedItem()!= null){
                List<Usuario> usuarios = gestorUsuario.getListaUsuarios();
                boolean usuarioOcupado= false;
                for(Usuario usuario: usuarios){
                    if(usuario.getNombreUsuario().equals(nombreUsuario.getText())){
                        usuarioOcupado = true;
                    }                    
                }
                if(usuarioOcupado){
                    gestorUsuario.desplegarMensaje("El nombre de usuario ya esta ocupado");
                }else{
                    boolean registrado = gestorUsuario.registrarUsuario(nombreUsuario.getText(), correo.getText(), contraseña.getText(), nivelAcceso.getSelectedItem().toString());
                    if (registrado){
                        gestorUsuario.desplegarMensaje("Usuario registrado");
                        vaciarContenido();
                    }else{
                        gestorUsuario.desplegarMensaje("Error al registrar el usuario");
                    }                
                }
            }else{
                gestorUsuario.desplegarMensaje("Ningun campo debe estar vacio");
            }
        }
    }
    
}
