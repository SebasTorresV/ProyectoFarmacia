<%@page import="modelo.Productos"%>
<%@page import="modeloDAD.ProductosDAO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Listado de Productos</title>
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
        <h1>Listado de Productos</h1>
    </header>
    <nav>
        <a href="../index.jsp">Inicio</a>
        <a href="CarritoController?accion=verCarrito" class="btn btn-primary">Ver Carrito</a>
    </nav>
    <div class="container">
        <h2 class="mt-4">Productos Disponibles</h2>
        <div class="row">
            <%
                ProductosDAO dao = new ProductosDAO();
                List<Productos> productos = dao.listarProductos();
                for (Productos producto : productos) {
            %>
            <div class="col-md-4">
                <div class="card mb-4">
                    <img src="../images/<%= producto.getNombre() %>.jpg" class="card-img-top" alt="<%= producto.getNombre() %>">
                    <div class="card-body">
                        <h5 class="card-title"><%= producto.getNombre() %></h5>
                        <p class="card-text"><%= producto.getDescripcion() %></p>
                        <p class="card-text">Precio: $<%= producto.getPrecio() %></p>
                        <a href="CarritoController?accion=agregar&id=<%= producto.getIdproductos() %>" class="btn btn-primary">Agregar al carrito</a>
                    </div>
                </div>
            </div>
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
