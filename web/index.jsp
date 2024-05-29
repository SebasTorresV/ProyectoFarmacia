<%@page import="modelo.Productos"%>
<%@page import="modeloDAD.ProductosDAO"%>
<%@page import="java.util.List"%>
<%@page import="modelo.Clientes"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Página Principal</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            font-family: 'Open Sans', sans-serif;
            margin: 0;
            background-color: #f8f9fa;
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
        .user-container {
            display: flex;
            align-items: center;
        }
        .user-container img {
            width: 40px;
            height: 40px;
        }
        .user-container span {
            color: white;
            margin-left: 10px;
        }
        .carousel-container {
            width: 100%;
            max-width: 1200px;
            margin: 20px auto;
        }
        .carousel-item img {
            width: 100%;
            height: 65vh;
            object-fit: cover;
        }
        .container {
            flex: 1;
            padding: 20px;
            text-align: center;
        }
        .row {
            justify-content: center;
        }
        footer {
            background-color: #1b4332;
            color: white;
            text-align: center;
            padding: 10px 0;
        }
        .carousel-control-prev, .carousel-control-next {
            width: 5%;
        }
        .carousel-control-prev-icon, .carousel-control-next-icon {
            background-color: rgba(0, 0, 0, 0.5);
            border-radius: 50%;
        }
    </style>
</head>
<body>
    <header>
        <h1>Bienvenido a Nuestra Farmacia</h1>
    </header>
    <nav>
        <a href="index.jsp">Inicio</a>
        <div class="user-container">
            <img src="images/bxs-user-account.svg" alt="Usuario">
            <span>
                <% 
                    Clientes usuario = (Clientes) session.getAttribute("user");
                    if (usuario != null) {
                        out.print("Bienvenido, " + usuario.getNombre());
                    } else {
                        out.print("");
                    }
                %>
            </span>
            <% if (usuario != null) { %>
                <a href="UserController?accion=logout" class="btn btn-outline-light btn-sm ms-3">Cerrar Sesión</a>
            <% } else { %>
                <a href="UserController?accion=loginPage" class="btn btn-outline-light btn-sm ms-3">Iniciar Sesión</a>
            <% } %>
            <a href="CarritoController?accion=verCarrito" class="btn btn-outline-light btn-sm ms-3">Ver Carrito</a>
        </div>
    </nav>

    <div class="carousel-container">
        <div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="carousel" data-bs-interval="3000">
            <div class="carousel-indicators">
                <% for (int i = 0; i < 10; i++) { %>
                <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="<%= i %>" class="<%= (i == 0 ? "active" : "") %>" aria-current="<%= (i == 0 ? "true" : "false") %>" aria-label="Slide <%= (i + 1) %>"></button>
                <% } %>
            </div>
            <div class="carousel-inner">
                <% for (int i = 1; i <= 10; i++) { %>
                <div class="carousel-item <%= (i == 1 ? "active" : "") %>">
                    <img src="images/producto<%= i %>.jpg" class="d-block w-100" alt="Producto <%= i %>">
                </div>
                <% } %>
            </div>
            <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Previous</span>
            </button>
            <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Next</span>
            </button>
        </div>
    </div>

    <div class="container">
        <h1 class="mt-4">Productos</h1>
        <div class="row">
            <%
                ProductosDAO dao = new ProductosDAO();
                List<Productos> list = dao.listarProductos();
                int maxProductos = 10;
                int count = 0;
                for (Productos producto : list) {
                    if (count >= maxProductos) break;
                    count++;
            %>
            <div class="col-md-4">
                <div class="card mb-4">
                    <img src="images/<%= producto.getNombre() %>.jpg" class="card-img-top" alt="<%= producto.getNombre() %>">
                    <div class="card-body">
                        <h5 class="card-title"><%= producto.getNombre() %></h5>
                        <p class="card-text"><%= producto.getDescripcion() %></p>
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
