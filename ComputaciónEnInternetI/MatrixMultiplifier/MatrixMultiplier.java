public class MatrixMultiplier {
    
    public static int[][] multiply(int[][] matrixA, int[][] matrixB) {
        int rowsA = matrixA.length;
        int colsA = matrixA[0].length;
        int colsB = matrixB[0].length;

        // Verificar si las dimensiones de las matrices son compatibles para la multiplicación
        if (colsA != matrixB.length) {
            throw new IllegalArgumentException("Las dimensiones de las matrices no son compatibles para la multiplicación.");
        }

        int[][] result = new int[rowsA][colsB];

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
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

    // Ejemplo de uso para probar la multiplicación de matrices
    public static void main(String[] args) {
        int[][] matrixA = {{1, 2, 3}, {4, 5, 6}};
        int[][] matrixB = {{7, 8}, {9, 10}, {11, 12}};
        
        // Medir el tiempo de ejecución de la multiplicación de matrices
        long executionTime = measureExecutionTime(() -> {
            int[][] result = multiply(matrixA, matrixB);
            System.out.println("Resultado de la multiplicación:");
            printMatrix(result);
        });

        System.out.println("Tiempo de ejecución: " + executionTime + " nanosegundos");
    }

    // Método auxiliar para imprimir una matriz
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
