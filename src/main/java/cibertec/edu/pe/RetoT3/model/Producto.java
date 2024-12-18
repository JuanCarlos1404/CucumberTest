package cibertec.edu.pe.RetoT3.model;

public class Producto {
    private int id;
    private String nombre;
    private double precio;
    private int cantidad;

    // Constructor con todos los campos
    public Producto(int id, String nombre, double precio, int cantidad) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    // Setters
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}