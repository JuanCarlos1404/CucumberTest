package cibertec.edu.pe.RetoT3.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class CarritoDeCompras {
    private final List<Producto> productos;

    public CarritoDeCompras() {
        this.productos = new ArrayList<>();
    }
    public List<Producto> getProductos() {
        return productos;
    }

    public void agregarProducto(Producto producto) {
        Producto productoExistente = productos.stream()
                .filter(p -> p.getId() == producto.getId())
                .findFirst()
                .orElse(null);

        if (productoExistente != null) {
            productoExistente.setCantidad(productoExistente.getCantidad() + producto.getCantidad());
        } else {
            productos.add(producto);
        }
    }

    public void eliminarProducto(int idProducto) {
        productos.removeIf(p -> p.getId() == idProducto);
    }

    public double calcularTotal() {
        return productos.stream()
                .mapToDouble(p -> p.getPrecio() * p.getCantidad())
                .sum();
    }
}