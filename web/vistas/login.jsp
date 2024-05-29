<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Iniciar Sesión</title>
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
            overflow: hidden;
            text-align: center;
        }
        nav a {
            display: inline-block;
            color: white;
            padding: 14px 16px;
            text-decoration: none;
        }
        nav a:hover {
            background-color: #0b3d20;
        }
        .container {
            flex: 1;
            display: flex;
            justify-content: center;
            align-items: center;
        }
        .form-container {
            background-color: #ffffff;
            border-radius: 8px;
            box-shadow: 0px 4px 8px rgba(0,0,0,0.1);
            padding: 2rem;
            width: 100%;
            max-width: 400px;
        }
        .form-label {
            color: #2d6a4f;
        }
        .btn-primary {
            background-color: #2d6a4f;
            border: none;
        }
        .btn-primary:hover {
            background-color: #1b4332;
        }
        .link-primary {
            color: #2d6a4f;
        }
        .link-primary:hover {
            color: #1b4332;
        }
        footer {
            background-color: #1b4332;
            color: white;
            text-align: center;
            padding: 10px 0;
            width: 100%;
            bottom: 0;
            position: fixed;
        }
    </style>
</head>
<body>
    <header>
        <h1>Bienvenido a Nuestra Farmacia</h1>
    </header>
    <nav>
        <a href="index.jsp">Inicio</a>
    </nav>
    <div class="container">
        <div class="form-container">
            <h1 class="mb-4 text-center">Iniciar Sesión</h1>
            <form action="UserController" method="POST">
                <input type="hidden" name="accion" value="login">
                <!-- Email input -->
                <div class="form-outline mb-4">
                    <label class="form-label" for="correo">Correo Electrónico</label>
                    <input type="email" id="correo" name="correo" class="form-control" required />
                </div>

                <!-- Password input -->
                <div class="form-outline mb-4">
                    <label class="form-label" for="password">Contraseña</label>
                    <input type="password" id="password" name="password" class="form-control" required />
                </div>

                <!-- Submit button -->
                <div class="text-center">
                    <button type="submit" class="btn btn-primary w-100 mb-4">Iniciar Sesión</button>
                </div>

                <div class="text-center mt-3">
                    <p>¿No tienes una cuenta? <a href="UserController?accion=registerPage" class="link-primary">Regístrate</a></p>
                </div>
            </form>
        </div>
    </div>
    <footer>
        <p>© 2024 Mi Empresa. Todos los derechos reservados.</p>
        <p>Dirección: Calle Falsa 123, Ciudad, País | Tel: +123 456 7890</p>
    </footer>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6Mmd0wny57oP1KDdOgjl6x9Kp77wTvtHf89YEVLTgWNodsNPLX2" crossorigin="anonymous"></script>
</body>
</html>
