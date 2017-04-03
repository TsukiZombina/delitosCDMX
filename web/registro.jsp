<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:gral_layout title="Delitos CDMX: Registro">
    
    <jsp:attribute name="head_area">
        <link href="css/custom/formularios.css" rel="stylesheet">
    </jsp:attribute>
        
    <jsp:attribute name="body_area">
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
                                    <input class="form-control" id="txtusuario" name="user" required="" tabindex="4" type="text">
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
    </jsp:attribute>
        
    <jsp:attribute name="script_area">
        <script src="js/password.js"></script>
    </jsp:attribute>

</t:gral_layout>
