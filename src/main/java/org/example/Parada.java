package org.example;

public class Parada {
  Direccion direccion;
  Integer tiempoDeDemora;

  public Parada(Direccion direccion, Integer tiempoDeDemora) {
    this.direccion = direccion;
    this.tiempoDeDemora = tiempoDeDemora;
  }

  public Direccion getDireccion() {
    return this.direccion;
  }

  public Integer gettiempoDeDemora() {
    return this.tiempoDeDemora;
  }
}
