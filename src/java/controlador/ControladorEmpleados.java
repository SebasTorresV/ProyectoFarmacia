package controlador;

import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Empleados;
import modeloDAD.EmpleadosDAO;

public class ControladorEmpleados extends HttpServlet {

    private static final String LISTAR_EMPLEADOS = "vistas/listarEmpleados.jsp";
    private static final String ADD_EMPLEADOS = "vistas/addEmpleados.jsp";
    private static final String EDIT_EMPLEADOS = "vistas/editEmpleados.jsp";
    private Empleados emp = new Empleados();
    private EmpleadosDAO dao = new EmpleadosDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acceso = "";
        String action = request.getParameter("accion");

        switch (action) {
            case "listarEmpleados":
                acceso = LISTAR_EMPLEADOS;
                break;
            case "addEmpleado":
                acceso = ADD_EMPLEADOS;
                break;
            case "edit":
                request.setAttribute("idEmp", request.getParameter("id"));
                acceso = EDIT_EMPLEADOS;
                break;
            case "delete":
                int deleteId = Integer.parseInt(request.getParameter("id"));
                dao.eliminar(deleteId);
                acceso = LISTAR_EMPLEADOS;
                break;
            default:
                acceso = LISTAR_EMPLEADOS;
                break;
        }

        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("accion");
        String acceso = "";

        switch (action) {
            case "saveEmpleado":
                String id = request.getParameter("txtid");
                String nom = request.getParameter("txtNombre");
                String ape = request.getParameter("txtApellido");
                String tele = request.getParameter("txtTelefono");
                String direc = request.getParameter("txtDireccion");
                String correo = request.getParameter("txtCorreo");

                emp.setId(Integer.parseInt(id));
                emp.setNombre(nom);
                emp.setApellido(ape);
                emp.setTelefono(Integer.parseInt(tele));
                emp.setDireccion(direc);
                emp.setCorreo(correo);
                if (dao.addEmpleados(emp)) {
                    acceso = LISTAR_EMPLEADOS;
                } else {
                    request.setAttribute("error", "No se pudo guardar el empleado.");
                    acceso = ADD_EMPLEADOS;
                }
                break;
            case "updateEmpleado":
                int updateId = Integer.parseInt(request.getParameter("txtid"));
                String updateNom = request.getParameter("txtNombre");
                String updateApe = request.getParameter("txtApellido");
                String updateTele = request.getParameter("txtTelefono");
                String updateDirec = request.getParameter("txtDireccion");
                String updateCorreo = request.getParameter("txtCorreo");

                emp.setId(updateId);
                emp.setNombre(updateNom);
                emp.setApellido(updateApe);
                emp.setTelefono(Integer.parseInt(updateTele));
                emp.setDireccion(updateDirec);
                emp.setCorreo(updateCorreo);
                if (dao.editEmpleados(emp)) {
                    acceso = LISTAR_EMPLEADOS;
                } else {
                    request.setAttribute("error", "No se pudo actualizar el empleado.");
                    acceso = EDIT_EMPLEADOS;
                }
                break;
            default:
                acceso = LISTAR_EMPLEADOS;
                break;
        }

        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Controlador de Empleados";
    }
}
