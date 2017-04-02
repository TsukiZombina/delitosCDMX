<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<!--
 author:    Arturo Camargo
 mail:      scarturocamargo@gmail.com
 license:   Copyright Â© SC Soluciones en Computacion 2017
-->
<html>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>Delitos CDMX</title>
    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/bootstrap-social.css" rel="stylesheet">
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link href="css/custom/base.css" rel="stylesheet">
    <link href="css/custom/formularios.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <body>
        <div class="container">
            <header class="img-header center-block">
                <img src="img\Logo_CDMX.png" alt="Logo CDMX" />
            </header>
            <nav class="navbar navbar-default center-block">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand">Delitos CDMX</a>
                    </div>
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav">
                            <li><a href="index.html"><span class="glyphicon glyphicon-home"></span> Inicio</a></li>
                            <li><a href="denuncia.html"><span class="glyphicon glyphicon-list-alt"></span> Denuncia</a></li>
                        </ul>
                        <ul class="nav navbar-nav navbar-right">
                            <li><a href="registro.html"><span class="glyphicon glyphicon-pencil"></span> Registro</a></li>
                            <li><a href="login.html"><span class="glyphicon glyphicon-log-in"></span> Iniciar Sesion</a></li>
                        </ul>
                    </div>
                </div>
            </nav>

            <section>
                <div class="content center-block">
                    <div class="content-title"><span class="glyphicon glyphicon-stop icon-title"></span> Acceso a la plataforma</div>
                    <div class="main">
                        <form method="post"  class="form-horizontal" action="registroUsuario">
                            <fieldset>
                                <legend>Datos Generales</legend>
                                <div class="form-group">
                                    <label for="txtname" class="control-label col-xs-12 col-sm-3">Nombre(s)</label>
                                    <div class="col-xs-12 col-sm-9">
                                        <input id="txtname" name="name" required="" tabindex="1" type="text" class="form-control"> 
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="txtlast" class="control-label col-xs-12 col-sm-3">Apellidos</label>
                                    <span class="col-xs-6 col-sm-5">
                                        <input class="form-control" id="txtlast" name="lastname" tabindex="2" type="text"  placeholder="Primer apellido" required=""> 
                                    </span>
                                    <span class="col-xs-6 col-sm-4">
                                        <input class="form-control" id="txtlast2" name="lastname2" tabindex="3" type="text" placeholder="Segundo apellido"> 
                                    </span>
                                </div>
                            </fieldset>
                            <fieldset>
                                <legend>Datos de Inicio de Sesion</legend>
                                <div class="form-group">
                                    <label for="txtusuario" class="control-label col-xs-12 col-sm-3">Usuario</label>
                                    <div class="col-xs-12 col-sm-9">
                                        <input class="form-control" id="txtmatricula" name="matricula" required="" tabindex="4" type="text">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="txtpass" class="control-label col-xs-12 col-sm-3">Contrase&ntilde;a</label>
                                    <div class="col-xs-12 col-sm-9">
                                        <input class="form-control" id="txtpass" name="password" required="" type="password" tabindex="5"> 
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="txtpass2" class="control-label col-xs-12 col-sm-3">Confirmar Contrase&ntilde;a</label>
                                    <div class="col-xs-12 col-sm-9">
                                        <input class="form-control" id="txtpass2" name="password2" required="" type="password" tabindex="6"> 
                                    </div>
                                </div>
                            </fieldset>
                            <fieldset>
                                <legend>Datos de Contacto</legend>
                                <div class="form-group">
                                    <label for="txtemail" class="control-label col-xs-12 col-sm-3">Correo electr&oacute;nico</label>
                                    <div class="col-xs-12 col-sm-9">
                                        <input class="form-control" id="txtemail" name="email" placeholder="usuario@mydomain.com" required="" type="email" tabindex="6"> 
                                    </div>
                                </div>
                            </fieldset>
                            <input class="btn btn-primary col-sm-offset-3" name="clean" tabindex="7" value="Limpiar" type="reset">
                            <input class="btn btn-primary pull-right" name="submit" tabindex="8" value="Registrar" type="submit">
                        </form>
                    </div> <!-- /article -->
                </div>
            </section> <!-- / #main-content -->

            <section>
                <div class="content center-block">
                    <div class="content-title"><span class="glyphicon glyphicon-stop icon-title"></span> Visita nuestras redes sociales</div>
                    <div class="add">
                        <ul class="social-box">
                            <li><a target="_blank" href="https://www.youtube.com/channel/UChVnsQidFu4suRNgnvpnoCw" class="btn btn-social-icon btn-youtube btn-lg">
                                    <span class="fa fa-youtube"></span>
                                </a>
                            </li>
                            <li><a target="_blank" href="https://www.facebook.com/GobiernoCDMX" class="btn btn-social-icon btn-facebook btn-lg">
                                    <span class="fa fa-facebook"></span>
                                </a>
                            </li>
                            <li><a target="_blank" href="https://twitter.com/GobCDMX" class="btn btn-social-icon btn-twitter btn-lg">
                                    <span class="fa fa-twitter"></span>
                                </a>
                            </li>
                            <li><a target="_blank" href="https://www.instagram.com/gobiernocdmx/" class="btn btn-social-icon btn-instagram btn-lg">
                                    <span class="fa fa-instagram"></span>
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
            </section>

            <footer class="footer navbar-fixed-bottom">
                <div class="container">
                    <p class="text-muted">&copy; 2017 <a href="">SC Soluciones en Computaci&oacute;n</a></p>
                </div>
            </footer>
        </div>
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="js/jquery.min.js"></script>
        <script src="js/password.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
