package ar.edu.utn.frba.dds;

public class Promocion implements Estado {
  public Promocion(double descuento) {
  }

  @Override
  public double modificarPrecio(double precio) {
    return 0;
  }
}
