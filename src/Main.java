import Linear.Matrices.Matrix;
import Linear.util.Format;
import Linear.util.SortMatrix;

public class Main {
    public static void main(String[] args) {
        Matrix m1 = new Matrix(4, 4, new float[]{0, 0, 1, 1, 1, 0, 0 ,0, 1, 0, 0, 1, 1, 1,1, 0});
        Matrix m2 = new Matrix(10, 10, new float[]{
                0, 1, 0, 0, 1, 0, 0, 1, 0, 0,
                0, 0, 0, 0, 1, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 1, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 1, 1, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 1, 0, 0,
                0, 1, 1, 1, 1, 0, 0, 1, 0, 1,
                0, 0, 0, 0, 0, 0, 0, 0, 0, 1,
                0, 0, 0, 0, 1, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 1, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 1, 0, 0, 0, 0,
        });
        Matrix q5 = new Matrix(4, 4, new float[]{
                0, 0, 1, 0,
                1, 0, 0 , 0,
                1, 1, 0, 0,
                0, 1, 0, 0
        });

        Matrix q6 = new Matrix(4, 4, new float[]{
                0, 1, 1, 0,
                0, 0, 1, 0,
                1, 0, 0, 1,
                1, 0, 0, 0
        });

        Matrix q7 = new Matrix(5, 5, new float[]{
                0, 1, 1, 1, 0,
                1, 0, 0, 0, 1,
                0, 0, 0, 0, 1,
                0, 1, 0, 0, 0,
                0, 1, 1, 0, 0
        });

        Matrix q8 = new Matrix(10, 10, new float[]{
                0, 1, 1, 0, 1, 1, 0, 0, 0, 1,
                0, 0, 1, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0, 0, 1,
                0, 1, 1, 0, 0, 1, 1, 0, 0, 1,
                0, 0, 0, 1, 0, 0, 0, 0, 0, 0,
                0, 1, 0, 0, 0, 0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 0, 0, 1, 0,
                0, 0, 0, 0, 0, 1, 0, 0, 0, 0,
                0, 1, 1, 0, 0, 1, 0, 1, 0, 1,
                0, 0, 0, 0, 0, 1, 0, 0, 0, 0,
        });

        Matrix result = PageRank.hitsAuthority(q8);

        // por operarmos matrizes com float a precisao precisa ser ajustada por conta da baixa precisao do tipo float
        Format formatted = new Format(result, 5, SortMatrix.DEFAULT);


        System.out.println(formatted);
    }

}