import Linear.Matrices.Matrix;
import Linear.Matrices.MatrixOperators;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class PageRank {

    // [1, 1, ..., 1] ^ t
    private static Matrix onesMatrix(int rows){
        float[] elements = new float[rows];

        Arrays.fill(elements, 1);

        return new Matrix(rows, 1, elements);
    }

    // sqrt(a1 ^ 2 + a2 ^ 2 + ... an ^ 2)
    private static float norm(Matrix vector){
        double sumExp = IntStream.range(0, vector.getRows())
                .mapToObj(i -> vector.get(i, 0))
                .reduce((float) 0, (acc, item) -> (float) (acc + Math.pow(item, 2)));

//        System.out.println("valor"+sumExp);
        return (float) Math.sqrt(sumExp);
    }

    private static Matrix ponderNormalize(Matrix ponderMatrix, Matrix vector){
        // Adiciona o peso ao vetor
        Matrix ponderVect = MatrixOperators.dot(ponderMatrix, vector);

        // versor
        float unitVector = 1 / norm(ponderVect);

        // retorna a normalização do vetor com pesos
        return (Matrix) MatrixOperators.times(unitVector, ponderVect);
    }

    public static Matrix hitsAuthority(Matrix matrixAdj){
        Matrix transposeAdj = MatrixOperators.transpose(matrixAdj);

        // a0 = A^t * [1, 1, ..., 1]^t
        Matrix a0 = MatrixOperators.dot(
                transposeAdj,
                onesMatrix(transposeAdj.getRows())
        );


        Matrix result = a0;

        double tot = 0.0001;
        int iter = 1000;

        for(int i = 0; i < iter; i++){
            // an = (A^t * A) * a0 / ||(A^t * A) * a0||
            Matrix an = ponderNormalize(MatrixOperators.dot(transposeAdj, matrixAdj), a0);

            // err = an - a0
            Matrix err = MatrixOperators.sum(an, (Matrix) MatrixOperators.times(-1f, a0));
            float biggerValueErr = IntStream.range(0, err.getElements().length)
                    .mapToObj(idx -> Math.abs(err.getElements()[idx]))
                    .max(Comparator.naturalOrder())
                    .orElse(Float.NEGATIVE_INFINITY);

            if(tot >= biggerValueErr){
                result = an;
                break;
            }

            a0 = an;
        }


        return result;
    }
}
