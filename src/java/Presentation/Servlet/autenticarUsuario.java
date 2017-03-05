/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.Servlet;

import BusinessLogic.Controller.IniciarSesion;
import DataAccess.Entity.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "autenticarUsuario", urlPatterns = {"/autenticarUsuario"})
public class autenticarUsuario extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        try {
           //Recogemos variables que son enviadas desde Index.jsp
            String nick = request.getParameter("nick");
            String password = request.getParameter("password");
            IniciarSesion login = new IniciarSesion();
            Usuario usuario = login.iniciarSesion(nick, password);
            if(usuario != null){
                String nombre = usuario.getUsuarioNombre();
                String correo = usuario.getUsuarioCorreo();
                String ID = usuario.getUsuarioId().toString();
                //creamos nuestra sesion
                HttpSession session = request.getSession(true);

                //Obtenemos los obejtos a guardar en session
                session.setAttribute("id", ID);
                session.setAttribute("nombre", nombre);
                session.setAttribute("correo", correo);
                session.setAttribute("nick", nick);

                //pagina a donde se enviara si se encuentra el usuario autenticado
                response.sendRedirect("principal.jsp");
            }else{
                out.println("<html>");
                out.println("<head>");
                out.println("<title> :::Error!::: </title>");
                out.println("</head>");
                out.println("<body bgcolor='#DDEEFF'>");
                out.println("<table border='0' width='50%' align='center'>");
                out.println("</br>");
                out.println("<tr>");
                if(login.getMessage().equals("Invalido")){
                    out.println("<td align='center'> <font face='Courier New, Courier, monospace' color='#FF0000' size='2'>Autenticación erronea! La contraseña es inválida. <a href='home.jsp'>Regresar>></a></font></p></td>");
                }else{
                    out.println("<td align='center'> <font face='Courier New, Courier, monospace' color='#FF0000' size='2'>Autenticación erronea! El usuario no existe. <a href='home.jsp'>Regresar>></a></font></p></td>");
                }
                out.println("</tr>");
                out.println("</table>");
                out.println("</body>");
                out.println("</html>");
            }
        } finally { 
            out.close();
        }
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
