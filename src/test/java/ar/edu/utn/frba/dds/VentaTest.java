package ar.edu.utn.frba.dds;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;

public class VentaTest {
  static Venta venta, ventaTarjeta;

  @BeforeAll
  static void inicializarVentas() {
    Estado nuevo = new Nuevo();
    Estado descuento = new Promocion(30);
    Estado liquidacion = new Liquidacion();

    Prenda sacoNuevo = new Prenda(99.99, Tipo.SACO, nuevo);
    Prenda camisaTemporadaAnterior = new Prenda(80, Tipo.CAMISA, descuento);
    Prenda pantalonSaldo = new Prenda(200, Tipo.PANTALON, liquidacion);

    Collection<Prenda> prendas = Arrays.asList(sacoNuevo, camisaTemporadaAnterior, pantalonSaldo);

    LocalDate unaFecha = LocalDate.of(2020, 1, 1);
    venta = new Venta(prendas, unaFecha);
    ventaTarjeta = new VentaTarjeta(prendas, unaFecha, 3, 20);
  }

  @Test
  public void conocerCantidadVendida() {
    Assertions.assertEquals(3, venta.cantidadVendida());
  }

  @Test
  public void ventaEnEfectivoNoModificaPrecio() {
    Assertions.assertEquals(99.99 + 50 + 100, venta.precioVenta());
  }

  @Test
  public void ventaTarjetaAplicaRecargo() {
    Assertions.assertEquals(3 * 20 + (99.99 + 50 + 100) * 1.01, ventaTarjeta.precioVenta());
  }
}
