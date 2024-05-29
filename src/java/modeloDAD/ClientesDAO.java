package modeloDAD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import config.conexion;
import modelo.Clientes;

public class ClientesDAO {
    conexion cn = new conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public List<Clientes> listarClientes() {
        List<Clientes> list = new ArrayList<>();
        String sql = "SELECT * FROM clientes";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Clientes cli = new Clientes();
                cli.setId(rs.getInt("id"));
                cli.setNombre(rs.getString("nombre"));
                cli.setApellido(rs.getString("apellido"));
                cli.setTelefono(rs.getString("telefono")); // Cambiado a String
                cli.setDireccion(rs.getString("direccion"));
                cli.setCorreo(rs.getString("correo"));
                list.add(cli);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public Clientes getCliente(int id) {
        Clientes cli = new Clientes();
        String sql = "SELECT * FROM clientes WHERE id=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                cli.setId(rs.getInt("id"));
                cli.setNombre(rs.getString("nombre"));
                cli.setApellido(rs.getString("apellido"));
                cli.setTelefono(rs.getString("telefono")); // Cambiado a String
                cli.setDireccion(rs.getString("direccion"));
                cli.setCorreo(rs.getString("correo"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cli;
    }

    public boolean addClientes(Clientes cli) {
        String sql = "INSERT INTO clientes (id, nombre, apellido, telefono, direccion, correo) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, cli.getId());
            ps.setString(2, cli.getNombre());
            ps.setString(3, cli.getApellido());
            ps.setString(4, cli.getTelefono()); // Cambiado a String
            ps.setString(5, cli.getDireccion());
            ps.setString(6, cli.getCorreo());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean editClientes(Clientes cli) {
        String sql = "UPDATE clientes SET nombre=?, apellido=?, telefono=?, direccion=?, correo=? WHERE id=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, cli.getNombre());
            ps.setString(2, cli.getApellido());
            ps.setString(3, cli.getTelefono()); // Cambiado a String
            ps.setString(4, cli.getDireccion());
            ps.setString(5, cli.getCorreo());
            ps.setInt(6, cli.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean eliminar(int id) {
        String sql = "DELETE FROM clientes WHERE id=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
