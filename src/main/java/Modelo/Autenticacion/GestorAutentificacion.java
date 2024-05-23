/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Autenticacion;

import Modelo.Persistencia;
import Modelo.USUARIOS.Usuario;

public class GestorAutentificacion {
    private Persistencia persistencia;

    public GestorAutentificacion() {
        this.persistencia = new Persistencia();
    }
    
    public void verificarYCrearDirectorio(){
        persistencia.verificarYCrearDirectorio();
    }
    
    public Usuario buscarUsuario(String nombreUsuario){
        return persistencia.buscarUsuario(nombreUsuario);
    }
    
    public void desplegarMensaje(String mensaje){
        persistencia.desplegarMensaje(mensaje);
    }
    
}
