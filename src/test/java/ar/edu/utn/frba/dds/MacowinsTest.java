package ar.edu.utn.frba.dds;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.IntStream;

public class MacowinsTest {
  @Test
  void gananciasDeHoyNoIncluyeOtrosDias() {
    Macowins macowins = new Macowins();

    Collection<Prenda> prendas = Arrays.asList(new Prenda(22, Tipo.PANTALON, new Nuevo()),
                                               new Prenda(44, Tipo.CAMISA, new Liquidacion()),
                                               new Prenda(34, Tipo.SACO, new Promocion(12)));

    macowins.registrarVenta(new Venta(prendas, LocalDate.of(2021, 9, 14)));
    IntStream.range(0, 5).forEach(i -> macowins.registrarVenta(new Venta(prendas, LocalDate.of(2020, 1, 1))));
    IntStream.range(0, 7).forEach(i -> macowins.registrarVenta(new Venta(prendas, LocalDate.of(2019, 12, 4))));

    Assertions.assertEquals(7 * 22 * 3, macowins.ganancias(LocalDate.of(2019, 12, 4)));
  }
}
