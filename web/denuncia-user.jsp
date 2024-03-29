<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:user_layout title="Delitos CDMX: Denuncia">

    <jsp:attribute name="head_area">
        <link href="css/bootstrap-datepicker3.min.css" rel="stylesheet">
        <link href="css/clockpicker.css" rel="stylesheet">
        <link href="css/custom/formularios.css" rel="stylesheet">
    </jsp:attribute>

    <jsp:attribute name="body_area">
        <section>
            <div class="content center-block">
                <div class="content-title"><span class="glyphicon glyphicon-stop icon-title"></span> Denuncia de Delito</div>
                <div class="main">
                    <form method="post"  class="form-horizontal" action="registroReporte">
                        <fieldset>
                            <legend>Fecha y Hora del Delito</legend>
                            <div class="form-group ">
                                <label for="txtfecha" class="control-label col-xs-12 col-sm-1">Fecha</label>
                                <span class="col-xs-12 col-sm-5">
                                    <input id="txtfecha" class="form-control" name="fecha" placeholder="Formato AAAA-MM-DD" required="" tabindex="1" type="text">
                                </span>
                                <label for="txthora" class="control-label col-xs-12 col-sm-1">Hora</label>
                                <span class="col-xs-12 col-sm-5">
                                    <input id="txthora" class="form-control" name="hora" placeholder="Formato de 24 hrs" required="" tabindex="2" type="text"> 
                                </span>
                            </div>
                        </fieldset>
                        <fieldset>
                            <legend>Tipo de Delito</legend>
                            <div class="form-group">
                                <label for="slcdelito" class="control-label col-xs-12 col-sm-1">Delito</label>
                                <div class="col-xs-12 col-sm-11">
                                    <select class="form-control" id="slcdelito" name="delito" required="" tabindex="3" size="1">
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
                                <label for="txtcalle1" class="control-label col-xs-12 col-sm-1">Calle 1</label>
                                <span class="col-xs-12 col-sm-5">
                                    <input class="form-control" id="txtcalle1" name="calle1" required="" tabindex="4" type="text">
                                </span>
                                <label for="txtcalle2" class="control-label col-xs-12 col-sm-1">Calle 2</label>
                                <span class="col-xs-12 col-sm-5">
                                    <input class="form-control" id="txtcalle2" name="calle2" tabindex="5" type="text">
                                </span>
                            </div>
                            <div class="form-group">
                                <label for="txtcolonia" class="control-label col-xs-12 col-sm-1">Colonia</label>
                                <span class="col-xs-12 col-sm-5">
                                    <input class="form-control" id="txtcolonia" name="colonia" required="" tabindex="6" type="text"> 
                                </span>
                                <label for="slcdeleg" class="control-label col-xs-12 col-sm-1">Delegacion</label>
                                <span class="col-xs-12 col-sm-5">
                                    <select class="form-control" id="slcdeleg" name="delegacion" required="" tabindex="7" size="1">
                                        <option value="1" selected disabled hidden></option>
                                        <option value="2">Alvaro Obregon</option>
                                        <option value="3">Azcapotzalco</option>
                                        <option value="4">Benito Juarez</option>
                                        <option value="5">Coyoacan</option>
                                        <option value="6">Cuajimalpa de Morelos</option>
                                        <option value="7">Cuauhtemoc</option>
                                        <option value="8">Gustavo A Madero</option>
                                        <option value="9">Iztacalco</option>
                                        <option value="10">Iztapalapa</option>
                                        <option value="11">La Magdalena Contreras</option>
                                        <option value="12">Miguel Hidalgo</option>
                                        <option value="13">Milpa Alta</option>
                                        <option value="14">Tlahuac</option>
                                        <option value="15">Tlalpan</option>
                                        <option value="16">Venustiano Carranza</option>
                                        <option value="17">Xochimilco</option>
                                    </select> 
                                </span>
                            </div>
                            <div class="form-group">
                                <span class="col-xs-12 col-sm-12">
                                    <input class="btn btn-primary pull-right" id="search" name="search" tabindex="8" value="Buscar" onclick="buscar()" type="button">
                                </span>
                            </div>
                            <div class="form-group">
                                <div id="map_canvas" class="col-xs-12 col-sm-12"></div>
                            </div>
                            <div class="form-group">
                                <label for="txtcoordy" class="control-label col-xs-12 col-sm-1">Latitud</label>
                                <span class="col-xs-12 col-sm-5">
                                    <input class="form-control" id="txtcoordy" name="coordy" tabindex="9" type="text" readonly> 
                                </span>
                                <label for="txtcoordx" class="control-label col-xs-12 col-sm-1">Longitud</label>
                                <span class="col-xs-12 col-sm-5">
                                    <input class="form-control" id="txtcoordx" name="coordx" tabindex="10" type="text" readonly> 
                                </span>
                            </div>
                        </fieldset>
                        <fieldset>
                            <legend>Detalles o Descripci&oacute;n del Delito</legend>
                            <div class="form-group ">
                                <span class="col-xs-12 col-sm-12">
                                    <textarea id="txtdesc" class="form-control" rows="3" name="descripcion" tabindex="11"></textarea>
                                </span>
                            </div>
                        </fieldset>
                        <input class="btn btn-primary col-sm-offset-9" name="clean" tabindex="11" value="Limpiar" type="reset">
                        <input class="btn btn-primary pull-right" name="submit" tabindex="12" value="Registrar" type="submit">
                    </form>
                </div> <!-- /article -->
            </div>
        </section> <!-- / #main-content -->
    </jsp:attribute>

    <jsp:attribute name="script_area">
        <script src="js/bootstrap-datepicker.min.js"></script>
        <script src="js/locale/bootstrap-datepicker.es.min.js"></script>
        <script src="js/clockpicker.js"></script>
        <script src="js/maps.js"></script>
        <script type="text/javascript">
            $('#txtfecha').datepicker({
                language: 'es',
                format: 'yyyy-mm-dd',
                orientation: 'bottom',
                autoclose: true,
                todayHighlight: true
            });
        </script>
        <script type="text/javascript">
            $('#txthora').clockpicker({
                placement: 'bottom',
                align: 'left',
                autoclose: 'true',
                donetext: 'Listo'
            });
        </script>
        <script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBFdGqr8PaEFVR01HPYRn0FdRP1xAT08QA&callback=load_map"></script>
    </jsp:attribute>

</t:user_layout>
