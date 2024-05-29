package modeloDAD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import config.conexion;
import modelo.Empleados;

public class EmpleadosDAO {
    conexion cn = new conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public List<Empleados> listarEmpleados() {
        List<Empleados> list = new ArrayList<>();
        String sql = "SELECT * FROM empleados";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Empleados emp = new Empleados();
                emp.setId(rs.getInt("id"));
                emp.setNombre(rs.getString("nombre"));
                emp.setApellido(rs.getString("apellido"));
                emp.setTelefono(rs.getInt("telefono"));
                emp.setDireccion(rs.getString("direccion"));
                emp.setCorreo(rs.getString("correo"));
                list.add(emp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public Empleados getEmpleado(int id) {
        Empleados emp = new Empleados();
        String sql = "SELECT * FROM empleados WHERE id=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                emp.setId(rs.getInt("id"));
                emp.setNombre(rs.getString("nombre"));
                emp.setApellido(rs.getString("apellido"));
                emp.setTelefono(rs.getInt("telefono"));
                emp.setDireccion(rs.getString("direccion"));
                emp.setCorreo(rs.getString("correo"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return emp;
    }

    public boolean addEmpleados(Empleados emp) {
        String sql = "INSERT INTO empleados (id, nombre, apellido, telefono, direccion, correo) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, emp.getId());
            ps.setString(2, emp.getNombre());
            ps.setString(3, emp.getApellido());
            ps.setInt(4, emp.getTelefono());
            ps.setString(5, emp.getDireccion());
            ps.setString(6, emp.getCorreo());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean editEmpleados(Empleados emp) {
        String sql = "UPDATE empleados SET nombre=?, apellido=?, telefono=?, direccion=?, correo=? WHERE id=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, emp.getNombre());
            ps.setString(2, emp.getApellido());
            ps.setInt(3, emp.getTelefono());
            ps.setString(4, emp.getDireccion());
            ps.setString(5, emp.getCorreo());
            ps.setInt(6, emp.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean eliminar(int id) {
        String sql = "DELETE FROM empleados WHERE id=?";
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
