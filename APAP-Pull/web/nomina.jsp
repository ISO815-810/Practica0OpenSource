<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSetMetaData"%>
<%@page import="app.Nomina"%>
<%@page import="java.sql.ResultSet"%>
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
        <br/><br/>

        <section class="container white">

            <h5>Nómina:</h5>
            <br/>
            <table class="bordered highlight">
            <tr>
                <th bgcolor="#147AB9" class="white-text">Fecha de transmisión</th>
                <th bgcolor="#147AB9" class="white-text">RNC</th> 
                <th bgcolor="#147AB9" class="white-text">Tipo de registro</th>
                <th bgcolor="#147AB9" class="white-text">No. de cuenta</th>
                <th bgcolor="#147AB9" class="white-text">Fecha de corte</th>
            </tr>
            
            <% 
                
               Nomina nomina = new Nomina();
                
               ResultSet rs = null;
               rs = nomina.obtenerDatos();
               ResultSetMetaData rsmd = rs.getMetaData();
        
        try {
            while (rs.next()){
                    out.print("<tr>");
                    out.print("<th>");
                    out.print(rs.getString(1));
                    out.print("</th>");
                    
                    out.print("<th>");
                    out.print(rs.getString(2));
                    out.print("</th>");
                    
                    out.print("<th>");
                    out.print(rs.getString(3));
                    out.print("</th>");
                    
                    out.print("<th>");
                    out.print(rs.getString(4));
                    out.print("</th>");
                    
                    out.print("<th>");
                    out.print(rs.getString(5));
                    out.print("</th>");
                    
                    out.print("</tr>");
                
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
                
            %>
            
        </table>
            
            
        </section>

        <br/><br/><br/><br/><br/><br/>

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