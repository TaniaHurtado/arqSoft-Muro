/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic.Controller;

import DataAccess.DAO.UsuarioDAO;
import DataAccess.Entity.Usuario;
import javax.faces.context.FacesContext;

/**
 *
 * @author arqsoft2017i
 */
public class IniciarSesion {
    
    private String message;
    
    public void setMessage(String message){
        this.message = message;
    }
    
    public String getMessage(){
        return this.message;
    }
    
    public Usuario iniciarSesion(String nick, String contrasena){
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuario = usuarioDAO.buscarUsuario(nick,contrasena);
        setMessage(usuarioDAO.getmessage());
        if(getMessage().equals("Encontrado")){            
            return usuario;
        }else{
            return null; 
        }
    }
}
