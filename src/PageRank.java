import Linear.Matrices.Matrix;
import Linear.Matrices.MatrixOperators;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class PageRank {

    private static Matrix onesMatrix(int rows){
        float[] elements = new float[rows];

        Arrays.fill(elements, 1);

        return new Matrix(rows, 1, elements);
    }

    private static float norm(Matrix vector){
        double sumExp = IntStream.range(0, vector.getRows())
                .mapToObj(i -> vector.get(i, 0))
                .reduce((float) 0, (acc, item) -> (float) (acc + Math.pow(item, 2)));

//        System.out.println("valor"+sumExp);
        return (float) Math.sqrt(sumExp);
    }

    private static Matrix ponderNormalize(Matrix ponderMatrix, Matrix vector){
        Matrix ponderVect = MatrixOperators.dot(ponderMatrix, vector);

        float unitVector = 1 / norm(ponderVect);


        return (Matrix) MatrixOperators.times(unitVector, ponderVect);
    }

    public static Matrix hitsAuthority(Matrix matrixAdj){

        Matrix transposeAdj = MatrixOperators.transpose(matrixAdj);
        Matrix a0 = MatrixOperators.dot(
                transposeAdj,
                onesMatrix(transposeAdj.getRows())
        );

        Matrix a0Normalize = (Matrix) MatrixOperators.times(1 / norm(a0), a0);



        Matrix result = a0;
        double tot = 0.0001;
        int iter = 1000;

        for(int i = 0; i < iter; i++){
            Matrix an = ponderNormalize(MatrixOperators.dot(transposeAdj, matrixAdj), a0Normalize);

            Matrix err = MatrixOperators.sum(an, (Matrix) MatrixOperators.times(-1f, a0Normalize));
            float biggerValueErr = IntStream.range(0, an.getElements().length)
                    .mapToObj(idx -> Math.abs(err.getElements()[idx]))
                    .max(Comparator.naturalOrder())
                    .orElse(Float.NEGATIVE_INFINITY);

            if(tot >= biggerValueErr){
                result = an;
                break;
            }

            a0Normalize = an;
        }


        return result;
    }
}
