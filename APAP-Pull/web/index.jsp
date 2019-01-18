<%-- 
    Document   : index
    Created on : Jan 16, 2019, 11:19:43 PM
    Author     : Carlos
--%>

<%@page import="java.io.File"%>
<%@page import="app.LeerArchivo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/css/materialize.min.css">
        <link rel="stylesheet" href="css/master.css"/>
        <title>Asociación Popular de Ahorros y Préstamos</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Carlos Eduardo Torres">
        <link rel="icon" href="images\icon.png"/>
    </head>

    <body>

        <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/js/materialize.min.js"></script>

        <header>

        </header>

        <nav>
            <div class="nav-wrapper">
                <a href="index.jsp" class="brand-logo"><img id="logo" src="images/logo1.png" alt="logo"/></a>
                <ul id="nav-mobile" class="right hide-on-med-and-down">
                    <li id="nomina"><a href="nomina.jsp">Nómina</a></li>
                    <li id="detalle_nomina"><a href="detalle_nomina.jsp">Detalle de Nómina</a></li>
                </ul>
            </div>
        </nav> 
        <br/><br/><br/>

        <section class="container white">

            <h5>Elija el archivo:</h5>
            <br/><br/>
            <div class="row center">
                <div class="col l12 s12 m12">
                    <div class="card">
                        <div class="card-content">
                            <form action="index.jsp" method="POST">
                                <div class="file-field input-field">
                                    <div class="btn">
                                        <span>Archivo</span>
                                        <input type="file">
                                    </div>
                                    <div class="file-path-wrapper">
                                        <input class="file-path validate" type="text" name="file" size="50">
                                    </div>
                                </div>
                                <br/>
                                <input class="btn waves-effect waves-light" name="enviar" type="submit" value="Leer Archivo">
                            </form>

                            <%
                                if (request.getParameter("enviar") != null) {

                                    String nombreArchivo = request.getParameter("file").toString();

                                    File archivo = new File("C://Users/Carlos/Desktop/PROGRAMACION Y DESARROLLO/JAVA/Proyectos JAVA/APAP/web/archivos/" + nombreArchivo);

                                    if (archivo.exists()) {

                                        LeerArchivo la = new LeerArchivo();

                                        LeerArchivo.muestraContenido("C://Users/Carlos/Desktop/PROGRAMACION Y DESARROLLO/JAVA/Proyectos JAVA/APAP/web/archivos/" + nombreArchivo);

                            %>        

                            <script>
                                alert('Archivo leido correctamente.');
                            </script>

                            <%                            } else {
                            %>        

                            <script>
                                alert('Ponga el archivo en la carpeta correspondiente.');
                            </script>

                            <%
                                    }

                                }
                            %>

                        </div>
                    </div>
                </div>
            </div>
        </section>
        <br/><br/>
        <footer class="page-footer">
            <div class="container">
                <div class="row">
                    <div class="col l6 s12">
                        <h5 class="white-text">Footer Content</h5>
                        <p class="grey-text text-lighten-4">You can use rows and columns here to organize your footer content.</p>
                    </div>
                    <div class="col l4 offset-l2 s12">
                        <h5 class="white-text">Links</h5>
                        <ul>
                            <li><a class="grey-text text-lighten-3" href="#!">Link 1</a></li>
                            <li><a class="grey-text text-lighten-3" href="#!">Link 2</a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="footer-copyright">
                <div class="container">
                    © 2014 Copyright Text
                    <a class="grey-text text-lighten-4 right" href="#!">More Links</a>
                </div>
            </div>
        </footer>
    </body>
</html>