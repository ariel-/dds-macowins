package ar.edu.utn.frba.dds;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Macowins {
  private List<Venta> ventas = new ArrayList<>();

  public double ganancias(LocalDate dia) {
    return ventas.stream()
                 .filter(venta -> venta.esDeFecha(dia))
                 .mapToDouble(Venta::precioVenta)
                 .sum();
  }

  public void registrarVenta(Venta venta) {
    ventas.add(venta);
  }
}
