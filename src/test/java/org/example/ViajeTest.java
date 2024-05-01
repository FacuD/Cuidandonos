package org.example;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

public class ViajeTest {
  Direccion inicio = new Direccion(0, 0);
  List<Parada> destino = new ArrayList<>();

  @Test
  public void calculaElTiempoDelViajeConDemoraEntreParadas() {
    DistanciaMatrixAPI calculadorDistancia = mock(DistanciaMatrixAPI.class);

    Direccion direccion1 = new Direccion(1, 1);
    Direccion direccion2 = new Direccion(2, 2);
    Direccion direccion3 = new Direccion(3, 3);
    when(calculadorDistancia.getDistancia(inicio, direccion1)).thenReturn(100);
    when(calculadorDistancia.getDistancia(direccion1, direccion2)).thenReturn(100);
    when(calculadorDistancia.getDistancia(direccion2, direccion3)).thenReturn(100);

    CalculadorDemora calculadorDemora = mock(CalculadorDemora.class);
    when(calculadorDemora.getTiempoPorDistancia(100)).thenReturn(25);

    Parada parada1 = new Parada(direccion1, 10);
    Parada parada2 = new Parada(direccion2, 20);
    Parada parada3 = new Parada(direccion3, 30);
    destino.add(parada1);
    destino.add(parada2);
    destino.add(parada3);
    Viaje viaje = new Viaje(inicio, destino);
    Assertions.assertEquals(viaje.calcularTiempoDeDemoraAproximado(calculadorDemora, calculadorDistancia), 135);
  }

  @Test void calculaElTiempoDelViajeSinDemoraEntreParadas() {
    DistanciaMatrixAPI calculadorDistancia = mock(DistanciaMatrixAPI.class);

    Direccion direccion1 = new Direccion(1, 1);
    Direccion direccion2 = new Direccion(2, 2);
    Direccion direccion3 = new Direccion(3, 3);
    when(calculadorDistancia.getDistancia(inicio, direccion1)).thenReturn(100);
    when(calculadorDistancia.getDistancia(direccion1, direccion2)).thenReturn(100);
    when(calculadorDistancia.getDistancia(direccion2, direccion3)).thenReturn(100);

    CalculadorDemora calculadorDemora = mock(CalculadorDemora.class);
    when(calculadorDemora.getTiempoPorDistancia(100)).thenReturn(25);

    Parada parada1 = new Parada(direccion1, 0);
    Parada parada2 = new Parada(direccion2, 0);
    Parada parada3 = new Parada(direccion3, 0);
    destino.add(parada1);
    destino.add(parada2);
    destino.add(parada3);
    Viaje viaje = new Viaje(inicio, destino);
    Assertions.assertEquals(viaje.calcularTiempoDeDemoraAproximado(calculadorDemora, calculadorDistancia), 75);
  }

}
