/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.Servlet;

import BusinessLogic.Controller.GestionarUsuario;
import BusinessLogic.Controller.ManejoComentario;
import BusinessLogic.Controller.ManejoPublicacion;
import DataAccess.Entity.Comentario;
import DataAccess.Entity.Publicacion;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author arqsoft2017i
 */
@WebServlet(name = "mostrarPublicaciones", urlPatterns = {"/mostrarPublicaciones"})
public class mostrarPublicaciones extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Crear el objeto de sesión actual y obtener el id del usuario loggeado
        // por medio de getAttribute()
        HttpSession session = request.getSession();
        Integer id = Integer.valueOf(session.getAttribute("id").toString());
        // Crear objeto de GestionarUsuario para obtener la lista de amigos
        GestionarUsuario buscarAmigos = new GestionarUsuario();
        List<Integer> listaAmigos = buscarAmigos.amigos(id);
        // Crear un controlador para manejo de publicaciones y otro para comentarios
        ManejoPublicacion mp = new ManejoPublicacion();
        ManejoComentario mc = new ManejoComentario();      
        //List<Comentario> comentarios = mc.comentarios(publicaciones.get(0).getPublicacionId());
        Map<Publicacion, List<Comentario>> publicaciones = new HashMap<Publicacion, List<Comentario>>();
        for(Integer i : listaAmigos) {
            List<Publicacion> publicacion = publicacion = mp.publicaciones(i);            
            for(Publicacion p : publicacion) {
                publicaciones.put(p, mc.comentarios(p.getPublicacionId()));
            }
        }        
        session.setAttribute("publicaciones", publicaciones);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}