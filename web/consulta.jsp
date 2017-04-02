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
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link href="css/bootstrap-datepicker3.min.css" rel="stylesheet">
    <link href="css/clockpicker.css" rel="stylesheet">
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
                    <div class="content-title"><span class="glyphicon glyphicon-stop icon-title"></span> Consulta de Delitos</div>
                    <div class="main">
                        <form method="post"  class="form-horizontal" action="consultaDelito">
                            <fieldset>
                                <legend>Fecha y Hora de los Delitos</legend>
                                <div class="form-group">
                                    <label class="control-label col-xs-12 col-sm-1">Fechas</label>
                                    <div class="col-xs-12 col-sm-11">
                                        <div class="input-group input-daterange">
                                            <input id="txtfecha1" class="form-control" name="fechaStart" tabindex="1" type="text">
                                            <span class="input-group-addon">a</span>
                                            <input id="txtfecha2" class="form-control" name="fechaEnd" tabindex="2" type="text">
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-xs-12 col-sm-1">Horas</label>
                                    <div class="col-xs-12 col-sm-11">
                                        <div class="input-group">
                                            <input id="txthora1" class="form-control" name="horaStart" tabindex="3" type="text">
                                            <span class="input-group-addon">a</span>
                                            <input id="txthora2" class="form-control" name="horaEnd" tabindex="4" type="text">
                                        </div>
                                    </div>
                                </div>
                            </fieldset>
                            <fieldset>
                                <legend>Tipo de Delito</legend>
                                <div class="form-group">
                                    <label for="slcdelito" class="control-label col-xs-12 col-sm-1">Delito</label>
                                    <div class="col-xs-12 col-sm-11">
                                        <select class="form-control" id="slcdelito" name="Delito" tabindex="3" size="19" multiple>
                                            <option value="" disabled selected hidden></option>
                                            <option value="1">Homicidio doloso</option>
                                            <option value="2">Lesiones por arma de fuego</option>
                                            <option value="3">Robo a bordo de metro c&sol;v</option>
                                            <option value="4">Robo a bordo de metro s&sol;v</option>
                                            <option value="5">Robo a bordo de microbus c&sol;v</option>
                                            <option value="6">Robo a bordo de microbus s&sol;v</option>
                                            <option value="7">Robo a bordo de taxi c&sol;v</option>
                                            <option value="8">Robo a casa habitacion c&sol;v</option>
                                            <option value="9">Robo a cuentahabiente c&sol;v</option>
                                            <option value="10">Robo a negocio c&sol;v</option>
                                            <option value="11">Robo a repartidor c&sol;v</option>
                                            <option value="12">Robo a repartidor s&sol;v</option>
                                            <option value="13">Robo a transe&uacute;nte c&sol;v</option>
                                            <option value="14">Robo a transe&uacute;nte s&sol;v</option>
                                            <option value="15">Robo a transportista c&sol;v</option>
                                            <option value="16">Robo a transportista s&sol;v</option>
                                            <option value="17">Robo de veh&iacute;culo c&sol;v</option>
                                            <option value="18">Robo de veh&iacute;culo s&sol;v</option>
                                            <option value="19">Violaci&oacute;n</option>
                                        </select>
                                    </div>
                                </div>
                            </fieldset>
                            <fieldset>
                                <legend>Lugar del Delito</legend>
                                <div class="form-group ">
                                    <label for="txtcalle1" class="control-label col-xs-12 col-sm-1">Calle</label>
                                    <span class="col-xs-12 col-sm-11">
                                        <input class="form-control" id="txtcalle1" name="calle" tabindex="4" type="text">
                                    </span>
                                </div>
                                <div class="form-group">
                                    <label for="txtcolonia" class="control-label col-xs-12 col-sm-1">Colonia</label>
                                    <span class="col-xs-12 col-sm-5">
                                        <input class="form-control" id="txtcolonia" name="colonia" tabindex="6" type="text"> 
                                    </span>
                                    <label for="txtdeleg" class="control-label col-xs-12 col-sm-1">Delegacion</label>
                                    <span class="col-xs-12 col-sm-5">
                                        <input class="form-control" id="txtdeleg" name="deleg" tabindex="7" type="text"> 
                                    </span>
                                </div>
                            </fieldset>
                            <input class="btn btn-primary col-sm-offset-9" name="clean" tabindex="11" value="Limpiar" type="reset">
                            <input class="btn btn-primary pull-right" name="submit" tabindex="12" value="Registrar" type="submit">
                        </form>
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
        <script src="js/locales/bootstrap-datepicker.es.min.js"></script>
        <script src="js/clockpicker.js"></script>
        <script src="js/maps.js"></script>
        <script type="text/javascript">
            $('.input-daterange').datepicker({
                todayBtn: "linked",
                language: 'es',
                format: 'yyyy-mm-dd',
                orientation: 'bottom',
                todayHighlight: true
            });
        </script>
        <script type="text/javascript">
            $('#txthora1').clockpicker({
                placement: 'bottom',
                align: 'left',
                autoclose: 'true',
                donetext: 'Listo'
            });
        </script>
        <script type="text/javascript">
            $('#txthora2').clockpicker({
                placement: 'bottom',
                align: 'left',
                autoclose: 'true',
                donetext: 'Listo'
            });
        </script>
    </body>
</html>
