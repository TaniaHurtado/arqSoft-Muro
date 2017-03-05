/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic.Controller;

import DataAccess.Entity.Usuario;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 *
 * @author arqsoft2017i
 */
@WebServlet("/sesionUsuario")
public class sesionUsuario extends HttpServlet {
    private static final long serialVersionUID = 1L;
    static private Usuario usuarioActual;
    
    public sesionUsuario(){}
    
    public void setusuarioActual(Usuario usuario){
        usuarioActual = usuario;
    }
    
    public Integer getusuarioId(){
        return usuarioActual.getUsuarioId();
    }
    
    public String getusuarioNombre(){
        return usuarioActual.getUsuarioNombre();
    }
    
    public Usuario getusuarioActual(){
        return usuarioActual;
    }
}
