package ar.edu.utn.frba.dds;

import java.time.LocalDate;
import java.util.Collection;

public class VentaTarjeta extends Venta {
  private final int cuotas;
  private final double coeficiente;

  public VentaTarjeta(Collection<Prenda> prendas, LocalDate fecha, int cuotas, double coeficiente) {
    super(prendas, fecha);
    this.cuotas = cuotas;
    this.coeficiente = coeficiente;
  }

  @Override
  double precioVenta() {
    return cuotas * coeficiente + 1.01 * super.precioVenta();
  }
}
