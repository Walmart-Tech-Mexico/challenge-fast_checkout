import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Reto para el desarrollador: Caja Rápida");

        // El desarrollador debe establecer este valor.
        // int tiempoTotal = 0; // Valor inicial incorrecto. DEBE ser modificado.
        int tiempoTotal = 20;

        // El desarrollador debe crear y/o modificar este array con diferentes tiempos.
        int[] tiemposAtencion = {
            10, 30, 1, 3, 4, 5, 10, 20, 30
        }; // Array vacío. DEBE ser llenado con datos.

        // El desarrollador debe ordenar los tiempos de atención y calcular cuántos clientes
        // se pueden atender en el tiempo total disponible.

        int clientesAtendidos = 0; // Inicialización. El desarrollador debe calcular el valor correcto.
        int tiempoAcumulado = 0; // Inicialización. El desarrollador debe actualizar este valor.

        // *** Inicio del área que el desarrollador debe implementar ***

        // 1. Ordenar los tiempos de atención (investigar cómo usar java.util.Arrays.sort()).
        Arrays.sort(tiemposAtencion);

        // 2. Iterar sobre los tiempos de atención ordenados y calcular:
        //    - Cuántos clientes se pueden atender.
        //    - El tiempo acumulado total.

        for (int tiempoCliente : tiemposAtencion) {
            if (tiempoCliente > tiempoTotal) break;
            if (tiempoCliente < 0) continue;

            if (tiempoAcumulado + tiempoCliente <= tiempoTotal) {
                clientesAtendidos++;
                tiempoAcumulado += tiempoCliente;
                continue;
            }
            break;
        }

        // *** Fin del área que el desarrollador debe implementar ***

        // Imprimir el número máximo de clientes que se pueden atender en el tiempo dado.
        // El resultado debe ser calculado por el desarrollador.
        System.out.println("Número máximo de clientes atendidos en " + tiempoTotal + " minutos: " + clientesAtendidos);
    }
}