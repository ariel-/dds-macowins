package ar.edu.utn.frba.dds;

public class ItemVenta {
  private final Prenda prenda;
  private final int cantidad;

  // caso para cantidad = 1
  public ItemVenta(Prenda prenda) {
    this.prenda = prenda;
    this.cantidad = 1;
  }

  public ItemVenta(Prenda prenda, int cantidad) {
    this.prenda = prenda;
    this.cantidad = cantidad;
  }

  public int getCantidad() {
    return cantidad;
  }

  public double calculoPrecio() {
    return cantidad * prenda.calculoPrecio();
  }
}
