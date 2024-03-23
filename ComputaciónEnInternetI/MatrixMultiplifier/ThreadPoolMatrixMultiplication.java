import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolMatrixMultiplication {
    
    public static int[][] multiply(int[][] matrixA, int[][] matrixB, int numThreads) {
        int rowsA = matrixA.length;
        int colsA = matrixA[0].length;
        int colsB = matrixB[0].length;

        // Verificar si las dimensiones de las matrices son compatibles para la multiplicación
        if (colsA != matrixB.length) {
            throw new IllegalArgumentException("Las dimensiones de las matrices no son compatibles para la multiplicación.");
        }

        int[][] result = new int[rowsA][colsB];

        ExecutorService executor = Executors.newFixedThreadPool(numThreads);

        // Dividir el trabajo entre múltiples hilos
        for (int i = 0; i < rowsA; i++) {
            final int row = i;
            executor.execute(() -> {
                for (int j = 0; j < colsB; j++) {
                    for (int k = 0; k < colsA; k++) {
                        result[row][j] += matrixA[row][k] * matrixB[k][j];
                    }
                }
            });
        }

        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return result;
    }

    // Método para medir el tiempo de ejecución
    public static long measureExecutionTime(Runnable task) {
        long startTime = System.nanoTime();
        task.run();
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    // Ejemplo de uso para probar la multiplicación de matrices con ThreadPool
    public static void main(String[] args) {
        int[][] matrixA = {{1, 2, 3}, {4, 5, 6}};
        int[][] matrixB = {{7, 8}, {9, 10}, {11, 12}};
        
        int numThreads = 5; // Número de hilos en el ThreadPool

        // Medir el tiempo de ejecución de la multiplicación de matrices con ThreadPool
        long executionTime = measureExecutionTime(() -> {
            int[][] result = multiply(matrixA, matrixB, numThreads);
            System.out.println("Resultado de la multiplicación con ThreadPool:");
            MatrixMultiplier.printMatrix(result);
        });

        System.out.println("Tiempo de ejecución: " + executionTime + " nanosegundos");
    }
}

