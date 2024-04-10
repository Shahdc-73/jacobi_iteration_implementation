public class Main {
    public static void main(String[] args) {
        // Example system of linear equations:
        // 2x + y = 5
        // x + 3y + z = 10
        // 3x + 2z = 15

        // Coefficient matrix
        double[][] A = {
                {2, 1, 0},
                {1, 3, 1},
                {3, 0, 2}
        };

        // Right-hand side vector
        double[] b = {5, 10, 15};

        // Initial guess
        double[] x0 = {0, 0, 0};

        // Number of iterations
        int iterations = 100;

        // Perform Jacobi iteration
        double[] x = jacobiIteration(A, b, x0, iterations);

        // Print results
        System.out.println("Solution:");
        for (int i = 0; i < x.length; i++) {
            System.out.println("x[" + i + "] = " + x[i]);
        }
    }

    // Jacobi iteration method
    public static double[] jacobiIteration(double[][] A, double[] b, double[] x0, int iterations) {
        int n = A.length;
        double[] x = new double[n];
        double[] xTemp = new double[n];

        // Perform Jacobi iteration
        for (int k = 0; k < iterations; k++) {
            for (int i = 0; i < n; i++) {
                double sum = 0.0;
                for (int j = 0; j < n; j++) {
                    if (j != i) {
                        sum += A[i][j] * x0[j];
                    }
                }
                xTemp[i] = (b[i] - sum) / A[i][i];
            }
            // Update x0 for the next iteration
            System.arraycopy(xTemp, 0, x0, 0, n);
        }

        // Copy the result to x
        System.arraycopy(x0, 0, x, 0, n);

        return x;
    }
}
