<%@page import="modelo.Empleados"%>
<%@page import="modeloDAD.EmpleadosDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Editar Empleados</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
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
        .form-container {
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0px 0px 10px 0px rgba(0,0,0,0.1);
            padding: 40px;
            margin-top: 20px;
        }
        .form-control:focus {
            border-color: #80bdff;
            box-shadow: 0 0 0 0.25rem rgb(0 123 255 / 25%);
        }
        .form-label {
            font-weight: bold;
        }
        .container {
            flex: 1;
            padding-top: 20px;
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
        <h1>Bienvenido a Nuestra Farmacia</h1>
    </header>
    <nav>
        <a href="#">Inicio</a>
        <a href="ControladorClientes?accion=listarClientes">Listar Clientes</a>
        <a href="ControladorEmpleados?accion=listarEmpleados">Listar Empleados</a>
        <a href="ControladorProductos?accion=listarProductos">Productos</a>
    </nav>
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="form-container">
                    <h1 class="mb-4 text-center">Editar Empleado</h1>
                    <%
                        EmpleadosDAO dad = new EmpleadosDAO();
                        int id = Integer.parseInt((String)request.getAttribute("idEmp"));
                        Empleados emp = dad.getEmpleado(id);
                    %>
                    <form action="ControladorEmpleados" method="POST">
                        <div class="mb-3">
                            <label for="txtid" class="form-label">ID:</label>
                            <input class="form-control" type="text" id="txtid" name="txtid" value="<%= emp.getId() %>" readonly>
                        </div>
                        <div class="mb-3">
                            <label for="txtNombre" class="form-label">Nombre:</label>
                            <input class="form-control" type="text" id="txtNombre" name="txtNombre" value="<%= emp.getNombre() %>">
                        </div>
                        <div class="mb-3">
                            <label for="txtApellido" class="form-label">Apellido:</label>
                            <input class="form-control" type="text" id="txtApellido" name="txtApellido" value="<%= emp.getApellido() %>">
                        </div>
                        <div class="mb-3">
                            <label for="txtTelefono" class="form-label">Teléfono:</label>
                            <input class="form-control" type="text" id="txtTelefono" name="txtTelefono" value="<%= emp.getTelefono() %>">
                        </div>
                        <div class="mb-3">
                            <label for="txtDireccion" class="form-label">Dirección:</label>
                            <input class="form-control" type="text" id="txtDireccion" name="txtDireccion" value="<%= emp.getDireccion() %>">
                        </div>
                        <div class="mb-3">
                            <label for="txtCorreo" class="form-label">Correo Electrónico:</label>
                            <input class="form-control" type="text" id="txtCorreo" name="txtCorreo" value="<%= emp.getCorreo() %>">
                        </div>
                        <div class="text-center">
                            <button class="btn btn-primary" type="submit" name="accion" value="updateEmpleado">Guardar Cambios</button>
                        </div>
                    </form>
                    <div class="text-center mt-3">
                        <a href="ControladorEmpleados?accion=listarEmpleados" class="btn btn-secondary"><i class="fas fa-arrow-left me-2"></i>Regresar</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <footer>
        <p>© 2024 Mi Empresa. Todos los derechos reservados.</p>
        <p>Dirección: Calle Falsa 123, Ciudad, País | Tel: +123 456 7890</p>
    </footer>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6Mmd0wny57oP1KDdOgjl6x9Kp77wTvtHf89YEVLTgWNodsNPLX2" crossorigin="anonymous"></script>
    <!-- Font Awesome -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/js/all.min.js"></script>
</body>
</html>
