package ar.edu.utn.frba.dds;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EstadoTest {
  @Test
  public void unaPrendaNuevaNoModificaSuPrecioBase() {
    Estado nuevo = new Nuevo();
    assertEquals(42, nuevo.modificarPrecio(42));
  }

  @Test
  public void unaPrendaEnPromocionRestaValorFijo() {
    Estado promo = new Promocion(22);
    assertEquals(20, promo.modificarPrecio(42));
  }

  @Test
  public void unaPrendaEnLiquidacionRecortaElPrecioALaMitad() {
    Estado liqui = new Liquidacion();
    assertEquals(21, liqui.modificarPrecio(42));
  }
}
