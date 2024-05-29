<%@page import="modelo.Productos"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Carrito de Compras</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            font-family: 'Open Sans', sans-serif;
            background-color: #f8f9fa;
            margin: 0;
            display: flex;
            flex-direction: column;
            min-height: 100vh;
        }
        header {
            background-color: #2d6a4f;
            color: white;
            padding: 1em 0;
            text-align: center;
        }
        nav {
            background-color: #1b4332;
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 0 20px;
        }
        nav a {
            color: white;
            padding: 14px 16px;
            text-decoration: none;
        }
        nav a:hover {
            background-color: #0b3d20;
        }
        .container {
            flex: 1;
            padding: 20px;
        }
        footer {
            background-color: #1b4332;
            color: white;
            text-align: center;
            padding: 10px 0;
        }
    </style>
</head>
<body>
    <header>
        <h1>Carrito de Compras</h1>
    </header>
    <nav>
        <a href="indexA.jsp">Inicio</a>
        <a href="CarritoController?accion=agregarProductos" class="btn btn-primary">Agregar Productos</a>
    </nav>
    <div class="container">
        <h2 class="mt-4">Productos en el Carrito</h2>
        <div class="row">
            <%
                List<Productos> carrito = (List<Productos>) session.getAttribute("carrito");
                if (carrito != null && !carrito.isEmpty()) {
                    for (Productos prod : carrito) {
            %>
            <div class="col-md-4">
                <div class="card mb-4">
                    <img src="../images/<%= prod.getNombre() %>.jpg" class="card-img-top" alt="<%= prod.getNombre() %>">
                    <div class="card-body">
                        <h5 class="card-title"><%= prod.getNombre() %></h5>
                        <p class="card-text"><%= prod.getDescripcion() %></p>
                        <p class="card-text">Precio: $<%= prod.getPrecio() %></p>
                        <a href="CarritoController?accion=eliminar&id=<%= prod.getIdproductos() %>" class="btn btn-danger">Eliminar</a>
                    </div>
                </div>
            </div>
            <% 
                    }
                } else {
            %>
            <p class="text-center">No hay productos en el carrito.</p>
            <% } %>
        </div>
    </div>
    <footer>
        <p>© 2024 Mi Empresa. Todos los derechos reservados.</p>
        <p>Dirección: Calle Falsa 123, Ciudad, País | Tel: +123 456 7890</p>
    </footer>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
