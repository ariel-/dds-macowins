package ar.edu.utn.frba.dds;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VentaTest {
  static Venta venta, ventaTarjeta;

  @BeforeAll
  static void inicializarVentas() {
    Estado nuevo = new Nuevo();
    Estado descuento = new Promocion(30);
    Estado liquidacion = new Liquidacion();

    ItemVenta sacoNuevo = new ItemVenta(new Prenda(99.99, Tipo.SACO, nuevo));
    ItemVenta camisaTemporadaAnterior = new ItemVenta(new Prenda(80, Tipo.CAMISA, descuento));
    ItemVenta pantalonSaldo = new ItemVenta(new Prenda(200, Tipo.PANTALON, liquidacion));

    List<ItemVenta> items = Arrays.asList(sacoNuevo, camisaTemporadaAnterior, pantalonSaldo);

    LocalDate unaFecha = LocalDate.of(2020, 1, 1);
    venta = new Venta(items, unaFecha);
    ventaTarjeta = new VentaTarjeta(items, unaFecha, 3, 20);
  }

  @Test
  public void conocerCantidadVendida() {
    assertEquals(3, venta.cantidadVendida());
  }

  @Test
  public void ventaEnEfectivoNoModificaPrecio() {
    assertEquals(99.99 + 50 + 100, venta.precioVenta());
  }

  @Test
  public void ventaTarjetaAplicaRecargo() {
    assertEquals(3 * 20 + (99.99 + 50 + 100) * 1.01, ventaTarjeta.precioVenta());
  }
}
