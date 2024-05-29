package controlador;

import java.io.IOException;
import java.util.List;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Clientes;
import modeloDAD.ClientesDAO;

public class ControladorClientes extends HttpServlet {

    private static final String LISTAR_CLIENTES = "vistas/listarClientes.jsp";
    private static final String ADD_CLIENTES = "vistas/addClientes.jsp";
    private static final String EDIT_CLIENTES = "vistas/editClientes.jsp";
    private ClientesDAO dao = new ClientesDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acceso = "";
        String action = request.getParameter("accion");

        switch (action) {
            case "listarClientes":
                List<Clientes> clientes = dao.listarClientes();
                request.setAttribute("clientes", clientes);
                acceso = LISTAR_CLIENTES;
                break;
            case "addCliente":
                acceso = ADD_CLIENTES;
                break;
            case "edit":
                int id = Integer.parseInt(request.getParameter("id"));
                request.setAttribute("idCli", id);
                acceso = EDIT_CLIENTES;
                break;
            case "delete":
                int deleteId = Integer.parseInt(request.getParameter("id"));
                dao.eliminar(deleteId);
                List<Clientes> clientesActualizados = dao.listarClientes();
                request.setAttribute("clientes", clientesActualizados);
                acceso = LISTAR_CLIENTES;
                break;
            default:
                List<Clientes> defaultClientes = dao.listarClientes();
                request.setAttribute("clientes", defaultClientes);
                acceso = LISTAR_CLIENTES;
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
            case "saveCliente":
                String id = request.getParameter("txtid");
                String nom = request.getParameter("txtNombre");
                String ape = request.getParameter("txtApellido");
                String tele = request.getParameter("txtTelefono");
                String direc = request.getParameter("txtDireccion");
                String correo = request.getParameter("txtCorreo");

                Clientes cli = new Clientes();
                cli.setId(Integer.parseInt(id));
                cli.setNombre(nom);
                cli.setApellido(ape);
                cli.setTelefono(tele); // Cambiado a String
                cli.setDireccion(direc);
                cli.setCorreo(correo);
                dao.addClientes(cli);
                List<Clientes> clientesActualizados = dao.listarClientes();
                request.setAttribute("clientes", clientesActualizados);
                acceso = LISTAR_CLIENTES;
                break;
            case "updateCliente":
                int updateId = Integer.parseInt(request.getParameter("txtid"));
                String updateNom = request.getParameter("txtNombre");
                String updateApe = request.getParameter("txtApellido");
                String updateTele = request.getParameter("txtTelefono");
                String updateDirec = request.getParameter("txtDireccion");
                String updateCorreo = request.getParameter("txtCorreo");

                Clientes updateCli = new Clientes();
                updateCli.setId(updateId);
                updateCli.setNombre(updateNom);
                updateCli.setApellido(updateApe);
                updateCli.setTelefono(updateTele); // Cambiado a String
                updateCli.setDireccion(updateDirec);
                updateCli.setCorreo(updateCorreo);
                dao.editClientes(updateCli);
                List<Clientes> clientesActualizados2 = dao.listarClientes();
                request.setAttribute("clientes", clientesActualizados2);
                acceso = LISTAR_CLIENTES;
                break;
            default:
                acceso = LISTAR_CLIENTES;
                break;
        }

        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Controlador de Clientes";
    }
}
