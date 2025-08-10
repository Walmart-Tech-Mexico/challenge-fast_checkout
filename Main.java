import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Reto para el desarrollador: Caja Rápida");

        // TODO: Definir el tiempo total disponible en minutos.
        // El desarrollador debe establecer este valor.
        int tiempoTotal = 150; // Valor inicial incorrecto. DEBE ser modificado.

        // TODO: Simular tiempos de atención para diferentes clientes (en minutos).
        // El desarrollador debe crear y/o modificar este array con diferentes tiempos.
        int[] tiemposAtencion = {20,18,19,13,23,11,10,13,12,14,19,14,22}; // Array vacío. DEBE ser llenado con datos.

        // TODO: Implementar la lógica para maximizar el número de clientes atendidos.
        // El desarrollador debe ordenar los tiempos de atención y calcular cuántos clientes
        // se pueden atender en el tiempo total disponible.

        int clientesAtendidos = 0; // Inicialización. El desarrollador debe calcular el valor correcto.
        int tiempoAcumulado = 0; // Inicialización. El desarrollador debe actualizar este valor.

        // *** Inicio del área que el desarrollador debe implementar ***

        // 1. Ordenar los tiempos de atención (investigar cómo usar java.util.Arrays.sort()).
        Arrays.sort(tiemposAtencion);

        // 2. Iterar sobre los tiempos de atención ordenados y calcular:
        for(Integer i: tiemposAtencion){
            if(tiempoAcumulado + i <= tiempoTotal){
                tiempoAcumulado += i;
                clientesAtendidos++;
            }else{
                break;
            }
        }
        //    - Cuántos clientes se pueden atender.
        //    - El tiempo acumulado total.

        // *** Fin del área que el desarrollador debe implementar ***

        // Imprimir el número máximo de clientes que se pueden atender en el tiempo dado.
        // El resultado debe ser calculado por el desarrollador.
        System.out.println("Número máximo de clientes atendidos en " + tiempoTotal + " minutos: " + clientesAtendidos);
        System.out.println("Tiempo total utilizado: " + tiempoAcumulado);
    }


}