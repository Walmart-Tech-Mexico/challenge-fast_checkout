import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("Reto para el desarrollador: Caja Rápida");

        // TODO: Definir el tiempo total disponible en minutos.
        // El desarrollador debe establecer este valor.
        int tiempoTotal = 120; // Valor inicial incorrecto. DEBE ser modificado.

        // TODO: Simular tiempos de atención para diferentes clientes (en minutos).
        // El desarrollador debe crear y/o modificar este array con diferentes tiempos.
        int[] tiemposAtencion = generateTimes(10,5,tiempoTotal);// Array vacío. DEBE ser llenado con datos.
        System.out.println(String.format("Tiempos obtenidos %s", Arrays.toString(tiemposAtencion)));
        // TODO: Implementar la lógica para maximizar el número de clientes atendidos.
        // El desarrollador debe ordenar los tiempos de atención y calcular cuántos clientes
        // se pueden atender en el tiempo total disponible.
        Arrays.sort(tiemposAtencion);
        System.out.println(String.format("Tiempos ordenados %s", Arrays.toString(tiemposAtencion)));

        int clientesAtendidos = 0; // Inicialización. El desarrollador debe calcular el valor correcto.
        int tiempoAcumulado = 0; // Inicialización. El desarrollador debe actualizar este valor.
        int currentClient=0;
        while(tiempoAcumulado +tiemposAtencion[currentClient]<= tiempoTotal){
            clientesAtendidos++;
            tiempoAcumulado+=tiemposAtencion[currentClient];
            currentClient++;
        }
        // *** Inicio del área que el desarrollador debe implementar ***

        // 1. Ordenar los tiempos de atención (investigar cómo usar java.util.Arrays.sort()).

        // 2. Iterar sobre los tiempos de atención ordenados y calcular:
        //    - Cuántos clientes se pueden atender.
        //    - El tiempo acumulado total.

        // *** Fin del área que el desarrollador debe implementar ***

        // Imprimir el número máximo de clientes que se pueden atender en el tiempo dado.
        // El resultado debe ser calculado por el desarrollador.
        System.out.printf("Número máximo de clientes atendidos en %s minutos: %s%n",tiempoTotal,clientesAtendidos);
        System.out.printf("Para atender el siguiente cliente, se necesitan %s minutos extra%n",(tiempoAcumulado +tiemposAtencion[currentClient])-tiempoTotal);
    }

    public static int[] generateTimes(int size,int min, int ma){
        return new Random().ints(size,min,ma).toArray();
    }
}