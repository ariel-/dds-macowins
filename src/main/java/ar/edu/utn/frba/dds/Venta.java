package ar.edu.utn.frba.dds;

import java.time.LocalDate;
import java.util.Collection;

public class Venta {
  private final Collection<ItemVenta> items;
  private final LocalDate fecha;

  public Venta(Collection<ItemVenta> items, LocalDate fecha) {
    this.items = items;
    this.fecha = fecha;
  }

  public boolean esDeFecha(LocalDate unaFecha) {
    return fecha.isEqual(unaFecha);
  }

  int cantidadVendida() {
    return items.stream().mapToInt(ItemVenta::getCantidad).sum();
  }

  double precioVenta() {
    return items.stream()
                  .mapToDouble(ItemVenta::calculoPrecio)
                  .sum();
  }
}
