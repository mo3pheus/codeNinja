package domain.misc;

public class CosineComputation {
    int   dimension = 0;
    int[] vectorA   = null;
    int[] vectorB   = null;

    public CosineComputation(int dimension) {
        this.dimension = dimension;
        vectorA = new int[dimension];
        vectorB = new int[dimension];
    }

    public double getCosineMeasure() {
        return computeDotProduct() / (getMagnitude(vectorA) * getMagnitude(vectorB));
    }

    private double computeDotProduct() {
        double sum = 0.0d;
        for (int i = 0; i < dimension; i++) {
            sum += vectorA[i] * vectorB[i];
        }

        return sum;
    }

    private double getMagnitude(int[] a) {
        double sum = 0.0d;
        for (int i : a) {
            sum += Math.pow(i, 2.0d);
        }
        return Math.sqrt(sum);
    }
}
