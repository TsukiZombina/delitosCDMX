<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>

<t:user_layout title="Delitos CDMX: Resultados">

    <jsp:attribute name="head_area">
        <link href="css/bootstrap-table.css" rel="stylesheet">
        <link href="css/bootstrap-datepicker3.min.css" rel="stylesheet">
        <link href="css/clockpicker.css" rel="stylesheet">
        <link href="css/custom/formularios.css" rel="stylesheet">
        <link href="css/custom/tablas.css" rel="stylesheet">
    </jsp:attribute>

    <jsp:attribute name="body_area">
        <section>
            <div class="content center-block">
                <div class="content-title"><span class="glyphicon glyphicon-stop icon-title"></span> Resultados de Delitos</div>
                <div class="main">
                    <table id="table" 
                           data-toggle="table" 
                           data-show-columns="true"
                           data-id-field="id" 
                           data-pagination="true" 
                           data-locale="es-MX"
                           data-page-size="5">
                        <thead>
                            <tr>
                                <th data-field="id" data-switchable="false" data-sortable="true">ID</th>
                                <th data-field="fecha" data-switchable="false" data-sortable="true">Fecha</th>
                                <th data-field="hora" data-switchable="false" data-sortable="true">Hora</th>
                                <th data-field="calle1" data-switchable="false">Calle 1</th>
                                <th data-field="calle2" data-visible="false">Calle 2</th>
                                <th data-field="colonia" data-switchable="false" data-sortable="true">Colonia</th>
                                <th data-field="delegacion" data-switchable="false" data-sortable="true">Delegaci&oacute;n</th>
                                <th data-field="coord_x" data-visible="false">Coordenada X</th>
                                <th data-field="coord_y" data-visible="false">Coordenada Y</th>
                                <th data-field="cuadrante" data-visible="false">Cuadrante</th>
                                <th data-field="delito" data-switchable="false" data-sortable="true">Delito</th>
                                <th data-field="descripcion" data-visible="false">Descripci&oacute;n</th>
                                <th data-field="consulta" data-switchable="false">Consulta</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${listaResultados}" var="i" >
                                <tr>
                                    <td>${i.getId_reporte()}</td>
                                    <td>${i.getFecha()}</td>
                                    <td>${i.getHora()}</td>
                                    <td>${i.getCalle1()}</td>
                                    <td>${i.getCalle2()}</td>
                                    <td>${i.getColonia().getnombre_colonia()}</td>
                                    <td>${i.getDelegacion().getnombre_delegacion()}</td>
                                    <td>${i.getCoord_x()}</td>
                                    <td>${i.getCoord_y()}</td>
                                    <td>${i.getCuadrante()}</td>
                                    <td>${i.getDelito().getNombre_delito()}</td>
                                    <td>${i.getDescripcion()}</td>
                                    <!--<td><form method="post" action="datosDelito"><input type="hidden" name="idButton" value="${i.getId_reporte()}"><input class="btn btn-primary" value="Ver" type="submit"></form></td>-->
                                </tr>
                            </c:forEach>
                        </tbody> 
                    </table>
                </div> <!-- /article -->
            </div>
        </section> <!-- / #main-content -->
    </jsp:attribute>

    <jsp:attribute name="script_area">
        <script src="js/bootstrap-datepicker.min.js"></script>
        <script src="js/bootstrap-table.min.js"></script>
        <!-- put your locale files after bootstrap-datepicker.js / bootstrap-table.js -->
        <script src="js/locale/bootstrap-table-es-MX.min.js"></script>
        <script src="js/locale/bootstrap-datepicker.es.min.js"></script>
        <script src="js/clockpicker.js"></script>
    </jsp:attribute>

</t:user_layout>


