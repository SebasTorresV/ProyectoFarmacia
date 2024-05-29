package controlador;

import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import modelo.Clientes;
import modeloDAD.ClientesDAO;

public class UserController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String accion = request.getParameter("accion");
        ClientesDAO dao = new ClientesDAO();

        if ("login".equals(accion)) {
            String correo = request.getParameter("correo");
            String password = request.getParameter("password");
            Clientes cli = dao.login(correo, password);
            if (cli != null) {
                HttpSession session = request.getSession();
                session.setAttribute("user", cli);

                // Verificar el rol del usuario
                if ("admin".equals(cli.getRol())) {
                    response.sendRedirect("indexA.jsp");
                } else {
                    response.sendRedirect("index.jsp");
                }
            } else {
                request.setAttribute("error", "Correo o contraseña incorrectos");
                RequestDispatcher rd = request.getRequestDispatcher("vistas/login.jsp");
                rd.forward(request, response);
            }
        } else if ("register".equals(accion)) {
            Clientes cli = new Clientes();
            cli.setNombre(request.getParameter("nombre"));
            cli.setApellido(request.getParameter("apellido"));
            cli.setTelefono(request.getParameter("telefono"));
            cli.setDireccion(request.getParameter("direccion"));
            cli.setCorreo(request.getParameter("correo"));
            cli.setPassword(request.getParameter("password"));
            cli.setRol("user"); // Asegurarse de establecer un rol por defecto

            dao.register(cli);
            response.sendRedirect("vistas/login.jsp");
        } else if ("logout".equals(accion)) {
            HttpSession session = request.getSession();
            session.invalidate();
            response.sendRedirect("index.jsp"); // Redirigir a index.jsp después de cerrar sesión
        } else if ("loginPage".equals(accion)) {
            RequestDispatcher rd = request.getRequestDispatcher("vistas/login.jsp");
            rd.forward(request, response);
        } else if ("registerPage".equals(accion)) {
            RequestDispatcher rd = request.getRequestDispatcher("vistas/register.jsp");
            rd.forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "User Controller";
    }
}
