/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.Autenticacion;

import Modelo.Autenticacion.GestorAutentificacion;
import Modelo.USUARIOS.Usuario;
import Vista.Autenticacion.GUIIniciarSecion;
import Vista.Autenticacion.GUIPrincipalAdmin;
import Vista.Autenticacion.GUIPrincipalRecepcionista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class ControladorIncicioSesion implements ActionListener{
    private GUIIniciarSecion guiIniciarSecion;
    private JTextField nombreUsuario, contraseña;
    private JButton login, limpiar;
    private GestorAutentificacion gestorAutentificacion;
    
    public ControladorIncicioSesion(GUIIniciarSecion guiIniciarSecion, JTextField nombreUsuario, JTextField contraseña, JButton login, JButton limpiar) {
        this.guiIniciarSecion = guiIniciarSecion;
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
        this.login = login;
        this.limpiar = limpiar;
        this.gestorAutentificacion = new GestorAutentificacion();
    }
    
    private void desplegarMenuAdministrador(String nombre){
        GUIPrincipalAdmin menu = new GUIPrincipalAdmin(nombre);

        menu.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                // Cerrar solo la ventana activa
                menu.dispose();
            }
        });

        menu.setVisible(true);
        menu.setLocationRelativeTo(null);
        guiIniciarSecion.setVisible(false);
    }
    
    private void desplegarMenuRecepcionista(String nombre){
        GUIPrincipalRecepcionista menu = new GUIPrincipalRecepcionista(nombre);

        menu.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                // Cerrar solo la ventana activa
                menu.dispose();
            }
        });

        menu.setVisible(true);
        menu.setLocationRelativeTo(null);
        guiIniciarSecion.setVisible(false);
    }
    
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object seleccion = ae.getSource();
        if(seleccion == login){
            if(!nombreUsuario.getText().isEmpty() && !contraseña.getText().isEmpty()){

                Usuario usuario = gestorAutentificacion.buscarUsuario(nombreUsuario.getText());
                if (usuario != null){
                    if (usuario.getContrasena().equals(contraseña.getText())){
                        if(usuario.getNivelAcceso().equals("1")){
                            desplegarMenuAdministrador(usuario.getNombreUsuario());
                        }
                        if(usuario.getNivelAcceso().equals("2")){
                            desplegarMenuRecepcionista(usuario.getNombreUsuario());
                        }

                    }else{
                        gestorAutentificacion.desplegarMensaje("La contraseña es incorrecta");
                    }

                }else{
                    gestorAutentificacion.desplegarMensaje("El usuaio no existe ");
                } 
            }else{
                gestorAutentificacion.desplegarMensaje("Ingresa nombre de usuario y contraseña");
            }
        }
        if(seleccion == limpiar){
            nombreUsuario.setText("");
            contraseña.setText("");
        }
    }
    
}
