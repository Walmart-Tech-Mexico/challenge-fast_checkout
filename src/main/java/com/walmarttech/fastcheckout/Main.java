package com.walmarttech.fastcheckout;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Reto para el desarrollador: Caja Rápida");

        // TODO: Definir el tiempo total disponible en minutos.
        // El desarrollador debe establecer este valor.
        int tiempoTotal = 30; // Ejemplo: 30 minutos disponibles.

        // TODO: Simular tiempos de atención para diferentes clientes (en minutos).
        // El desarrollador debe crear y/o modificar este array con diferentes tiempos.
        int[] tiemposAtencion = {5, 3, 10, 2, 7}; // Ejemplo: Tiempos de atención en minutos.

        // Validar entradas
        if (tiempoTotal <= 0) {
            System.err.println("Error: El tiempo total debe ser mayor a 0.");
            return;
        }
        if (tiemposAtencion.length == 0) {
            System.err.println("Error: La lista de tiempos de atención no puede estar vacía.");
            return;
        }

        // TODO: Implementar la lógica para maximizar el número de clientes atendidos.
        // El desarrollador debe ordenar los tiempos de atención y calcular cuántos clientes
        // se pueden atender en el tiempo total disponible.

        int clientesAtendidos = 0; // Inicialización. El desarrollador debe calcular el valor correcto.
        int tiempoAcumulado = 0; // Inicialización. El desarrollador debe actualizar este valor.


        // *** Inicio del área que el desarrollador debe implementar ***
        // Imprimir array original
        System.out.println("Tiempos de atención originales: " + Arrays.toString(tiemposAtencion));
        // 1. Ordenar los tiempos de atención (investigar cómo usar java.util.Arrays.sort()).

        // Ordenar tiempos de atención de menor a mayor para maximizar clientes atendidos
        java.util.Arrays.sort(tiemposAtencion);

        // Imprimir array ordenado
        System.out.println("Tiempos de atención ordenados: " + Arrays.toString(tiemposAtencion));

        // 2. Iterar sobre los tiempos de atención ordenados y calcular:
        //    - Cuántos clientes se pueden atender.
        //    - El tiempo acumulado total.
        for (int tiempo : tiemposAtencion) {
            if (tiempoAcumulado + tiempo > tiempoTotal) {
                break;
            }
            tiempoAcumulado += tiempo;
            clientesAtendidos++;
        }

        // *** Fin del área que el desarrollador debe implementar ***

        // Imprimir el número máximo de clientes que se pueden atender en el tiempo dado.
        // El resultado debe ser calculado por el desarrollador.
        System.out.printf("Número máximo de clientes atendidos en %d minutos: %d%n", tiempoTotal, clientesAtendidos);
        System.out.printf("Tiempo total utilizado: %d minutos%n", tiempoAcumulado);
    }
}