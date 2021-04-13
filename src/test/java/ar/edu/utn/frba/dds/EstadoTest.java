package ar.edu.utn.frba.dds;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EstadoTest {
  @Test
  public void unaPrendaNuevaNoModificaSuPrecioBase() {
    Estado nuevo = new Nuevo();
    Assertions.assertEquals(42, nuevo.modificarPrecio(42));
  }

  @Test
  public void unaPrendaEnPromocionRestaValorFijo() {
    Estado promo = new Promocion(22);
    Assertions.assertEquals(20, promo.modificarPrecio(42));
  }

  @Test
  public void unaPrendaEnLiquidacionRecortaElPrecioALaMitad() {
    Estado liqui = new Liquidacion();
    Assertions.assertEquals(21, liqui.modificarPrecio(42));
  }
}
