package cibertec.edu.pe.RetoT3;

import cibertec.edu.pe.RetoT3.model.CarritoDeCompras;
import cibertec.edu.pe.RetoT3.model.Producto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CarritoDeComprasTest {
    private CarritoDeCompras carrito;

    @BeforeEach
    void setUp() {
        carrito = new CarritoDeCompras();
    }

    @Test
    void agregarProductoNuevo_alCarrito() {
        Producto producto = new Producto(1, "Manzanas", 2.50, 3);
        carrito.agregarProducto(producto);

        assertEquals(1, carrito.getProductos().size());
        assertEquals(7.50, carrito.calcularTotal());
    }

    @Test
    void actualizarCantidadProductoExistente() {
        Producto producto = new Producto(1, "Manzanas", 2.50, 3);
        carrito.agregarProducto(producto);

        carrito.agregarProducto(new Producto(1, "Manzanas", 2.50, 2));

        assertEquals(1, carrito.getProductos().size());
        assertEquals(5, carrito.getProductos().get(0).getCantidad());
    }

    @Test
    void calcularTotalCarrito() {
        carrito.agregarProducto(new Producto(1, "Manzanas", 2.50, 3));
        carrito.agregarProducto(new Producto(2, "Plátanos", 1.20, 5));

        assertEquals(13.50, carrito.calcularTotal());
    }

    @Test
    void eliminarProductoDelCarrito() {
        Producto producto = new Producto(1, "Manzanas", 2.50, 3);
        carrito.agregarProducto(producto);

        carrito.eliminarProducto(1);

        assertEquals(0, carrito.getProductos().size());
        assertEquals(0.0, carrito.calcularTotal());
    }
}