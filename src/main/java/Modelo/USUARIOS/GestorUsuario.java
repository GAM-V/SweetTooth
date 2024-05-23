/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.USUARIOS;

import Modelo.Persistencia;
import java.util.LinkedList;
import java.util.List;

public class GestorUsuario {

    private Persistencia persistencia;

    public GestorUsuario() {
        
        persistencia = new Persistencia();
    }
    
    public List<Usuario> getListaUsuarios(){
        return persistencia.getListaUsuarios();
    }
    
    public Boolean registrarUsuario(String nombre, String correo, String contraseña, String nivelAcceso){
        
        Usuario usuario = new Usuario();
        usuario.setNombreUsuario(nombre);
        usuario.setCorreo(correo);
        usuario.setContrasena(contraseña);
        usuario.setNivelAcceso(nivelAcceso);
        List<Usuario> usuarios = persistencia.getListaUsuarios();
        usuarios.add(usuario);
        persistencia.actualizarDataBaseUsuarios(usuarios);
        return true;
    }
    
    public Boolean eliminarUsuario(String nombreUsuario){
        List<Usuario> usuarios = persistencia.getListaUsuarios();
        List<Usuario> temp = new LinkedList<>();
        for(Usuario usuario : usuarios){
            if(!usuario.getNombreUsuario().equals(nombreUsuario)){
                temp.add(usuario);
            }
        }
        persistencia.actualizarDataBaseUsuarios(temp);
        if(usuarios.size() != temp.size()){
            return true;
        }else{
            return false;
        }
    }
    
    public Usuario consultarUsuario(String nombreUsuario){
        List<Usuario> usuarios = persistencia.getListaUsuarios();
        for(Usuario usuario : usuarios){
            if(usuario.getNombreUsuario().equals(nombreUsuario)){
                return usuario;
            }
        }
        return null;
    }
    
    public Boolean modificarUsuario(String nombre, String nombreModif, String correo, String contraseña, String nivelAcceso){
        List<Usuario> usuarios = persistencia.getListaUsuarios();
        boolean usuarioModificado = false;
        
        for(Usuario usuario : usuarios){
            if(usuario.getNombreUsuario().equals(nombre)){
                usuario.setNombreUsuario(nombreModif);
                usuario.setCorreo(correo);
                usuario.setContrasena(contraseña);
                usuario.setNivelAcceso(nivelAcceso);
                usuarioModificado = true;
            }
        }
        persistencia.actualizarDataBaseUsuarios(usuarios);
        return usuarioModificado;
    }
    
    public void desplegarMensaje(String mensaje){
        persistencia.desplegarMensaje(mensaje);
    }
    
}
