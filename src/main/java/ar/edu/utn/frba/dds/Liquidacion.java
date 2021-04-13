package ar.edu.utn.frba.dds;

public class Liquidacion implements Estado {
  @Override
  public double modificarPrecio(double precio) {
    return precio * 0.5;
  }
}
