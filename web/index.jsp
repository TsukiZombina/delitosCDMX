<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:gral_layout title="Delitos CDMX">

    <jsp:attribute name="head_area">  
    </jsp:attribute>

    <jsp:attribute name="body_area">
        <section>
            <div class="content center-block">
                <div class="content-title"><span class="glyphicon glyphicon-stop icon-title"></span>¡Bienvenidos!</div>
                <div class="main">
                    <div id="myCarousel" class="carousel slide" data-ride="carousel">
                        <!-- Wrapper for slides -->
                        <div class="carousel-inner" role="listbox">
                            <div class="item active">
                                <img src="img\index1.jpg" alt="Bellas Artes">
                                <div class="carousel-caption">
                                    <p>Palacio de Bellas Artes</p>
                                </div>
                            </div>

                            <div class="item">
                                <img src="img\index2.jpg" alt="Angel de la Independencia">
                                <div class="carousel-caption">
                                    <p>Angel de la Independencia</p>
                                </div>
                            </div>

                            <div class="item">
                                <img src="img\index3.jpg" alt="Torre Latino">
                                <div class="carousel-caption">
                                    <p>Torre Latinoamericana</p>
                                </div>
                            </div>

                            <div class="item">
                                <img src="img\index4.jpg" alt="Revolucion">
                                <div class="carousel-caption">
                                    <p>Monumento a la Revoluci&oacute;n</p>
                                </div>
                            </div>
                        </div>

                        <!-- Left and right controls -->
                        <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
                            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                            <span class="sr-only">Previous</span>
                        </a>
                        <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
                            <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                            <span class="sr-only">Next</span>
                        </a>
                    </div>
                    <p>Si tienes una cuenta, recuerda iniciar sesi&oacute;n en la parte superior de esta p&aacute;gina.</p>
                    <p>¡Denuncia, estas en tu derecho!</p>
                </div> <!-- /article -->
            </div>
        </section> <!-- / #main-content -->
    </jsp:attribute>

    <jsp:attribute name="script_area">  
    </jsp:attribute>

</t:gral_layout>
