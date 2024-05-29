<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="config.conexion" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Farmacia Mi Empresa</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <style>
        body {
            font-family: 'Open Sans', sans-serif;
            margin: 0;
            background-color: #f0f8ff;
        }
        header {
            background-color: #2d6a4f;
            color: white;
            padding: 1em 0;
            text-align: center;
        }
        nav {
            background-color: #1b4332;
            overflow: hidden;
            text-align: center;
        }
        nav a {
            display: inline-block;
            color: white;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
        }
        nav a:hover {
            background-color: #0b3d20;
        }
        .container {
            padding: 20px;
            text-align: center;
        }
        .container h1 {
            color: #2d6a4f;
        }
        .container p {
            background-color: #d4edda;
            color: #155724;
            padding: 1em;
            border-radius: 8px;
            display: inline-block;
        }
        footer {
            background-color: #1b4332;
            color: white;
            text-align: center;
            padding: 10px 0;
            position: fixed;
            width: 100%;
            bottom: 0;
        }
    </style>
</head>
<body>
    <header>
        <h1>Bienvenido a Nuestra Farmacia</h1>
    </header>
    <nav>
        <a href="index.jsp">Inicio</a>
        <a href="ControladorClientes?accion=listarClientes">Listar Clientes</a>
        <a href="ControladorEmpleados?accion=listarEmpleados">Listar Empleados</a>
        <a href="ControladorProductos?accion=listarProductos">Productos</a>
        <a href="consultas.jsp">Consultas</a>
        <a href="#">Contáctanos</a>
    </nav>
    <div class="container">
        <h1>Bienvenido a Nuestra Página Principal</h1>
        <% 
            // Establecer la conexión a la base de datos
            Connection con = null;
            try {
                conexion db = new conexion(); // Crear una instancia de la clase conexion
                con = db.getConnection(); // Llamar al método getConnection() desde la instancia
                if (con != null) {
                    out.println("<p>Conexión a la base de datos exitosa</p>");
                } else {
                    out.println("<p>Error al conectar a la base de datos</p>");
                }
            } catch (Exception e) {
                out.println("<p>Error al conectar a la base de datos: " + e.getMessage() + "</p>");
            } finally {
                // Cerrar la conexión
                try {
                    if (con != null) {
                        con.close();
                    }
                } catch (SQLException e) {
                    out.println("<p>Error al cerrar la conexión: " + e.getMessage() + "</p>");
                }
            }
        %>
    </div>
    <footer>
        <p>© 2024 Mi Empresa. Todos los derechos reservados.</p>
        <p>Dirección: Calle Falsa 123, Ciudad, País | Tel: +123 456 7890</p>
    </footer>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6Mmd0wny57oP1KDdOgjl6x9Kp77wTvtHf89YEVLTgWNodsNPLX2" crossorigin="anonymous"></script>
</body>
</html>
