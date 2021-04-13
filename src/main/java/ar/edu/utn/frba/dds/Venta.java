package ar.edu.utn.frba.dds;

import java.time.LocalDate;
import java.util.Collection;

public class Venta {
  private final Collection<Prenda> prendas;
  private final LocalDate fecha;

  public Venta(Collection<Prenda> prendas, LocalDate fecha) {
    this.prendas = prendas;
    this.fecha = fecha;
  }

  public LocalDate getFecha() {
    return fecha;
  }

  int cantidadVendida() {
    return prendas.size();
  }

  double precioVenta() {
    return prendas.stream()
                  .mapToDouble(Prenda::calculoPrecio)
                  .sum();
  }
}
