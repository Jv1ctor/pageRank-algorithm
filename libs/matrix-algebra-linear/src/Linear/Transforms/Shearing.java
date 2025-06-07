package Linear.Transforms;

import Linear.util.HomogeneousTransform;
import Linear.Matrices.Matrix;
import Linear.Matrices.MatrixOperators;
import Linear.Vectors.Vector;

public class Shearing {

  private static Vector shearing(Vector vector, Matrix operator){
    Matrix inputMatrix = HomogeneousTransform.toHomogeneousVector(vector, 1);
    Matrix hOperatorMatrix = HomogeneousTransform.toHomogeneousOperatorLinear(operator);

    Matrix result = MatrixOperators.dot(hOperatorMatrix, inputMatrix);

    return HomogeneousTransform.fromHomogeneousVector(result);
  }

  public static Vector shearing2D(Vector vector, float kx,float ky){
    Matrix shearOperator = Matrix.identity(2);
    shearOperator.set(0,1, kx);
    shearOperator.set(1, 0, ky);
//    Matrix shearOperator = new Matrix(2, 2, new float[]{1, kx, ky, 1});

    return shearing(vector, shearOperator);
  }
}
