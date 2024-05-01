package org.example;

import java.util.List;

public class Viaje {
  Direccion inicio;
  List<Parada> destino;
  int tiempoTotal = 0;

  public Viaje(Direccion inicio, List<Parada> destino) {
    this.inicio = inicio;
    this.destino = destino;
  }

  public int calcularTiempoDeDemoraAproximado(CalculadorDemora calculadorDemora, DistanciaMatrixAPI calculadorDistancia) {

    for (Parada parada : destino) {
      if(tiempoTotal == 0){
        tiempoTotal += calculadorDemora.getTiempoPorDistancia(calculadorDistancia.getDistancia(inicio, parada.getDireccion())) + parada.gettiempoDeDemora();
      }
      if (destino.size() == destino.indexOf(parada)+1) {
        break;
      }
      tiempoTotal += calculadorDemora.getTiempoPorDistancia(calculadorDistancia.getDistancia(parada.getDireccion(), destino.get(destino.indexOf(parada) + 1).getDireccion())) + destino.get(destino.indexOf(parada) + 1).gettiempoDeDemora();
    }
    return tiempoTotal;
  }

}
