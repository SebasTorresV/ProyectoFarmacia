/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


public class Empleados {
    int id;
    String nombre;
    String apellido;
    int telefono;
    String direccion;
    String correo;
//
//    public Clientes(String nombre, String apellido, int telefono, String direccion, String correo) {
//        this.nombre = nombre;
//        this.apellido = apellido;
//        this.telefono = telefono;
//        this.direccion = direccion;
//        this.correo = correo;
//    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }  
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
