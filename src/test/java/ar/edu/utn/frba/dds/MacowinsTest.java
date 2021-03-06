package ar.edu.utn.frba.dds;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MacowinsTest {
  @Test
  void gananciasDeHoyNoIncluyeOtrosDias() {
    Macowins macowins = new Macowins();

    List<ItemVenta> items = Arrays.asList(new ItemVenta(new Prenda(22, Tipo.PANTALON, new Nuevo())),
                                          new ItemVenta(new Prenda(44, Tipo.CAMISA, new Liquidacion())),
                                          new ItemVenta(new Prenda(34, Tipo.SACO, new Promocion(12))));

    macowins.registrarVenta(new Venta(items, LocalDate.of(2021, 9, 14)));
    IntStream.range(0, 5).forEach(i -> macowins.registrarVenta(new Venta(items, LocalDate.of(2020, 1, 1))));
    IntStream.range(0, 7).forEach(i -> macowins.registrarVenta(new Venta(items, LocalDate.of(2019, 12, 4))));

    assertEquals(7 * 22 * 3, macowins.ganancias(LocalDate.of(2019, 12, 4)));
  }
}
