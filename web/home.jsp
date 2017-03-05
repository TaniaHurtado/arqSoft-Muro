<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="assets/css/home.css"/>
    </head>
    <body>
        <div class="wrapper">
            <section class="wrapper-header">
                <div class="content-header container">
                    <h1 class="title">ArqSoft Muro</h1>
                    <div class="login">
                        <form class="loginForm clearfix" action="autenticarUsuario" method="post">
                            <div class="loginInput form-group">
                                <label>Nombre de Usuario:</label>
                                <input class="form-control" type="text" name="nick" placeholder="Username">
                            </div>
                            <div class="loginInput form-group">
                                <label>Contraseña</label>
                                <input class="form-control" type="password" name="password" placeholder="Password">
                            </div>
                            <button class="loginSubmit btn btn-secondary" type="submit">Iniciar Sesion</button>
                        </form>
                    </div>
                </div>
            </section>
            <section class="wrapper-body">
                <div class="container">
                    <div class="row">
                        <div class="image col-md-6">
                            <img src="assets/images/svg/UN.svg" alt="UN" title="UN" class="logo img-responsive">
                        </div>
                        <div class="register col-md-6">
                            <h2 class="registerTitle">Regístrate</h2>
                            <form class="registerForm clearfix" action="registrarUsuario" method="post">
                                <div class="registerInput form-group">
                                    <label>Nombre:</label>
                                    <input class="form-control" type="text" name="nombre" placeholder="Name">
                                </div>
                                <div class="registerInput form-group">
                                    <label>Nombre de usuario:</label>
                                    <input class="form-control" type="text" name="nick" placeholder="Username">
                                </div>
                                <div class="registerInput form-group">
                                    <label>Correo electrónico</label>
                                    <input class="form-control" type="text" name="correo" placeholder="Email">
                                </div>
                                <div class="registerInput form-group">
                                    <label>Contraseña</label>
                                    <input class="form-control" type="password" name="password" placeholder="Password">
                                </div>
                                <button class="registerSubmit btn btn-success" type="submit">Crear usuario</button>
                            </form>
                        </div>
                    </div>
                </div>
            </section>
        </div>
        <script src="assets/js/jquery-3.1.1.min.js"></script>
        <script src="assets/bootstrap/js/bootstrap.min.js"></script>
        <script type="javascript">
            $(document).ready(function(){
                
            });
        </script>
    </body>
</html>