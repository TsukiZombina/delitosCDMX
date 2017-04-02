<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:gral_layout title="Delitos CDMX: Inicio de Sesion">

    <jsp:attribute name="head_area">
        <link href="css/custom/formularios.css" rel="stylesheet">
    </jsp:attribute>

    <jsp:attribute name="body_area">
        <section>
            <div class="content center-block">
                <div class="content-title"><span class="glyphicon glyphicon-stop icon-title"></span> Acceso a la plataforma</div>
                <div class="main">
                    <form class="form-horizontal" method="post" action="accesoUsuario"> 
                        <fieldset>
                            <legend>Datos de Usuario</legend>
                            <div class="form-group">
                                <label for="txtuser" class="control-label col-xs-12 col-sm-3">Usuario</label>
                                <div class="col-xs-12 col-sm-9">
                                    <input class="form-control" id="txtuser" name="user" placeholder="Nombre de usuario" required="" tabindex="1" type="text">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="txtpass" class="control-label col-xs-12 col-sm-3">Contrase&ntilde;a</label>
                                <div class="col-xs-12 col-sm-9">
                                    <input class="form-control" id="txtpass" name="password" required="" type="password" tabindex="2"> 
                                </div>
                            </div>
                            <input class="btn btn-primary pull-right" name="login" tabindex="3" value="Iniciar" type="submit">
                        </fieldset>
                    </form> 
                </div> <!-- /article -->
            </div>
        </section> <!-- / #main-content -->
    </jsp:attribute>

    <jsp:attribute name="script_area">  
    </jsp:attribute>

</t:gral_layout>