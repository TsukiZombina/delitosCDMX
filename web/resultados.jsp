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
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/bootstrap-social.css" rel="stylesheet">
    <link href="css/bootstrap-table.css" rel="stylesheet">
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link href="css/bootstrap-datepicker3.min.css" rel="stylesheet">
    <link href="css/clockpicker.css" rel="stylesheet">
    <link href="css/custom/base.css" rel="stylesheet">
    <link href="css/custom/tablas.css" rel="stylesheet">

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
                            <li><a href="index-user.html"><span class="glyphicon glyphicon-home"></span> Inicio</a></li>
                            <li ><a href="perfil.html"><span class="glyphicon glyphicon-user"></span> Perfil</a></li>
                        </ul>
                        <ul class="nav navbar-nav navbar-right">
                            <li><a href="denuncia-user.html"><span class="glyphicon glyphicon-plus"></span> Reporte</a></li>
                            <li><a href="consulta.html"><span class="glyphicon glyphicon-search"></span> Consultas</a></li>
                            <li ><a href="index.html"><span class="glyphicon glyphicon-log-out"></span> Salir</a></li>
                        </ul>
                    </div>
                </div>
            </nav>

            <section>
                <div class="content center-block">
                    <div class="content-title"><span class="glyphicon glyphicon-stop icon-title"></span> Resultados de Delitos</div>
                    <div class="main">
                        <table id="table" 
                               data-toggle="table" 
                               data-show-columns="true" 
                               data-id-field="id" 
                               data-pagination="true" 
                               data-locale="es-MX">
                            <thead>
                                <tr>
                                    <th data-field="id" data-switchable="false" data-sortable="true">ID</th>
                                    <th data-field="fecha" data-switchable="false" data-sortable="true">Fecha</th>
                                    <th data-field="hora" data-switchable="false" data-sortable="true">Hora</th>
                                    <th data-field="calle1" data-switchable="false">Calle 1</th>
                                    <th data-field="calle2" data-visible="false">Calle 2</th>
                                    <th data-field="colonia" data-switchable="false" data-sortable="true">Colonia</th>
                                    <th data-field="delegacion" data-switchable="false" data-sortable="true">Delegaci&oacute;n</th>
                                    <th data-field="coordX" data-visible="false">Coordenada X</th>
                                    <th data-field="coordY" data-visible="false">Coordenada Y</th>
                                    <th data-field="cuadrante" data-visible="false">Cuadrante</th>
                                    <th data-field="delito" data-switchable="false" data-sortable="true">Delito</th>
                                    <th data-field="descripcion" data-visible="false">Descripci&oacute;n</th>
                                </tr>
                            </thead>
                        </table>
                    </div> <!-- /article -->
                </div>
            </section> <!-- / #main-content -->

            <footer class="footer navbar-fixed-bottom">
                <div class="container">
                    <p class="text-muted">&copy; 2017 <a href="">SC Soluciones en Computaci&oacute;n</a></p>
                </div>
            </footer>
        </div>
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="js/jquery.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="js/bootstrap.min.js"></script>
        <script src="js/bootstrap-datepicker.min.js"></script>
        <script src="js/bootstrap-table.min.js"></script>
        <!-- put your locale files after bootstrap-datepicker.js / bootstrap-table.js -->
        <script src="js/locale/bootstrap-table-es-MX.min.js"></script>
        <script src="js/locale/bootstrap-datepicker.es.min.js"></script>
        <script src="js/clockpicker.js"></script>
        <script src="js/maps.js"></script>
    </body>
</html>