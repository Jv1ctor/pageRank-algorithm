package Linear.util;

import Linear.Matrices.Matrix;
import Linear.Vectors.Vector;

import java.util.Arrays;

public class HomogeneousTransform {

     public static Matrix toHomogeneousVector(Vector vector, float hElement){
        float[] elements = vector.getElements();
        float[] elementsHomogeneous = Arrays.copyOf(elements, elements.length + 1);
        elementsHomogeneous[elementsHomogeneous.length - 1] = hElement;

        return new Matrix(vector.getDim() + 1, 1, elementsHomogeneous);
    }

    public static Vector fromHomogeneousVector(Matrix matrix){
        float[] elementsMatrixHomo = matrix.getElements();
        float[] elementsVector = Arrays.copyOf(elementsMatrixHomo, elementsMatrixHomo.length - 1);

        return new Vector(matrix.getRows() - 1, elementsVector);
    }


    public static Matrix toHomogeneousOperatorLinear(Matrix matrixA){
       int hRows = matrixA.getRows() + 1;
       int hColumns = matrixA.getColumns() + 1;
       Matrix hMatrix = new Matrix(hRows, hColumns, new float[hRows * hColumns]);

       for(int i = 0; i < hMatrix.getRows(); i++){
         for (int j = 0; j < hMatrix.getColumns(); j++){
           if(j < hMatrix.getColumns() - 1 && i < hMatrix.getRows() - 1){
             hMatrix.set(i, j, matrixA.get(i, j));
           }
         }
       }
       hMatrix.set(hRows - 1, hColumns - 1,1);

       return hMatrix;
    }

    public static Matrix toHomogenousOperatorLinear(Matrix matrixA, Vector vectorX){
        int hColumns = matrixA.getColumns() + 1;
        Matrix hMatrix = toHomogeneousOperatorLinear(matrixA);


        for(int i = 0; i < vectorX.getDim(); i++){
            hMatrix.set(i, hColumns - 1, vectorX.get(i));
        }


        return hMatrix;
    }
}

