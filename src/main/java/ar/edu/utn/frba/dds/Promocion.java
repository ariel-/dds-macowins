package ar.edu.utn.frba.dds;

public class Promocion implements Estado {
  double descuento;

  public Promocion(double descuento) {
    this.descuento = descuento;
  }

  @Override
  public double modificarPrecio(double precio) {
    return precio - descuento;
  }
}
