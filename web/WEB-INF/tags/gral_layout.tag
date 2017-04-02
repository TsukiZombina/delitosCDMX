<!DOCTYPE html>
<!--
 authors:   Arturo Camargo Mayen, Zelzin Marcela Márquez Navarrete, Adrian Vilchis
 mail:      scarturocamargo@gmail.com
 license:   Copyright © SC Soluciones en Computación 2017
-->
<%@tag description="General Wrapper" pageEncoding="UTF-8"%>

<%@attribute name="title"%>
<%@attribute name="head_area" fragment="true" %>
<%@attribute name="body_area" fragment="true" %>
<%@attribute name="script_area" fragment="true" %>

<html>
    <head>
        <title>${title}</title>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

        <!-- Bootstrap -->
        <link href="css/bootstrap.min.css" rel="stylesheet">

        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
            <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->

        <link href="css/bootstrap-social.css" rel="stylesheet">
        <link href="css/font-awesome.min.css" rel="stylesheet">
        <link href="css/custom/base.css" rel="stylesheet">
        <jsp:invoke fragment="head_area"/>
    </head>

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
                            <li><a href="index.jsp"><span class="glyphicon glyphicon-home"></span> Inicio</a></li>
                            <li><a href="denuncia.jsp"><span class="glyphicon glyphicon-list-alt"></span> Denuncia</a></li>
                        </ul>
                        <ul class="nav navbar-nav navbar-right">
                            <li><a href="registro.jsp"><span class="glyphicon glyphicon-pencil"></span> Registro</a></li>
                            <li><a href="login.jsp"><span class="glyphicon glyphicon-log-in"></span> Iniciar Sesion</a></li>
                        </ul>
                    </div>
                </div>
            </nav>

            <jsp:invoke fragment="body_area"/>

        </div>

        <footer class="footer">
            <div class="container">
                <div class="social-text">Visita nuestras redes sociales</div>
                <ul class="social-box">
                    <li><a target="_blank" href="https://www.youtube.com/channel/UChVnsQidFu4suRNgnvpnoCw" class="btn btn-social-icon btn-lg btn-footer">
                            <span class="fa fa-youtube"></span>
                        </a>
                    </li>
                    <li><a target="_blank" href="https://www.facebook.com/GobiernoCDMX" class="btn btn-social-icon btn-lg btn-footer">
                            <span class="fa fa-facebook"></span>
                        </a>
                    </li>
                    <li><a target="_blank" href="https://twitter.com/GobCDMX" class="btn btn-social-icon btn-lg btn-footer">
                            <span class="fa fa-twitter"></span>
                        </a>
                    </li>
                    <li><a target="_blank" href="https://www.instagram.com/gobiernocdmx/" class="btn btn-social-icon btn-lg btn-footer">
                            <span class="fa fa-instagram"></span>
                        </a>
                    </li>
                </ul>
                <p class="text-muted">&copy; 2017 <a href="">SC Soluciones en Computaci&oacute;n</a></p>
            </div>
        </footer>

        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="js/jquery.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="js/bootstrap.min.js"></script>
        <jsp:invoke fragment="script_area"/>
    </body>
</html>