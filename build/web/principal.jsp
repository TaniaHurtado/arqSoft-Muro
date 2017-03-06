<%@page import="DataAccess.Entity.Publicacion"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"> 
<html> 
    <head> 
        <title>Muro</title>
        <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="assets/css/muro.css"/>
    </head> 
    <body> 
        <jsp:include page="mostrarPublicaciones"/>
        <%     
            String codigo = (String) session.getAttribute("ID");//Recoge la session
            String nombre = (String) session.getAttribute("nombre");//Recoge la session
            String nick = (String) session.getAttribute("nick");//Recoge la session
            String correo = (String) session.getAttribute("correo");//Recoge la session
            List<Publicacion> publicaciones = (List<Publicacion>)session.getAttribute("publicaciones");
        %>
        <div class="wrapper">
            <div class="wrapper-menu">
                <ul class="nav nav-tabs">
                    <li role="item" class="active"><a href="principal.jsp">Inicio</a></li>
                    <li role="item"><a href="profile.jsp"><%=nombre%></a></li>
                    <li role="item"> 
                        <form class="logOut" action="cerrarSesion">
                            <button type="submit">Cerrar Sesion</button>
                        </form>
                    </li>
                </ul>
            </div>
        </div>


        <form action="cerrarSesion"><button type="submit" style="float: right;">Cerrar Sesion</button></form>
        <br/>            
        <h1 style="text-align: center">Bienvenido <%=nombre%></h1>
        <hr/>     
        <h2 style="text-align: center">Crear publicacion</h2>
        <form action="crearPublicacion" method="post" style="text-align: center">
            <label>Contenido:</label><br/>
            <textarea rows="4" cols="50" name="contenido" placeholder="Escribe tu publicacion"></textarea>
            <br/>
            <button type="submit">Crear Publicacion</button>
        </form>
        <br/><br/>
        <div align="center">
            <table border="1" cellpadding="5">
                <caption><h2>Publicaciones</h2></caption>
                <tr>
                    <th>Fecha</th>
                    <th>Contenido</th>
                    <th>Comentarios</th>
                    <th>Crear Comentario</th>
                </tr>
                <c:forEach items="<%=publicaciones%>" var="pb" >
                    <tr>
                        <td>${pb.getPublicacionFecha()}</td>
                        <td>${pb.getPublicacionContenido()}</td>                   
                        <td>  
                            <c:forEach items="${pb.getComentarioCollection()}" var="com" >
                                <tr> 
                                    <td>${com.getComentarioUsuarioId().getUsuarioNombre()}</td>
                                    <td>${com.getComentarioContenido()}</td>
                                </tr>
                            </c:forEach>
                        </td>
                        <td>
                            <form method="post" action="crearComentario">
                                <label>Comentario:</label><br/>
                                <input name="idPub" value="${pb.getPublicacionId()}" style="display: none"/>
                                <textarea rows="3" cols="30" name="comentario" placeholder="Escribe tu comentario"></textarea>
                                <br/>
                                <button type="submit">Crear Comentario</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <script src="assets/js/jquery-3.1.1.min.js"></script>
        <script>
            $(document).ready(function () {
                
            });
        </script>
    </body> 
</html>
