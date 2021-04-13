package ar.edu.utn.frba.dds;

public class Prenda {
  private final double precioBase;
  private final Tipo tipo;
  private final Estado estado;

  public Prenda(double precioBase, Tipo tipo, Estado estado) {
    this.precioBase = precioBase;
    this.tipo = tipo;
    this.estado = estado;
  }

  public Tipo getTipo() {
    return tipo;
  }

  double calculoPrecio() {
    return estado.modificarPrecio(precioBase);
  }
}
