package Linear.Transforms;

import Linear.util.HomogeneousTransform;
import Linear.Matrices.Matrix;
import Linear.Matrices.MatrixOperators;
import Linear.Vectors.Vector;

public class Projection {

  private static Vector projection(Vector vector, Matrix operator){
    Matrix inputMatrix = HomogeneousTransform.toHomogeneousVector(vector, 1);
    Matrix hOperatorMatrix = HomogeneousTransform.toHomogeneousOperatorLinear(operator);

    Matrix result = MatrixOperators.dot(hOperatorMatrix, inputMatrix);

    return HomogeneousTransform.fromHomogeneousVector(result);
  }

  public static Vector projection2DX(Vector vector){
    Matrix projectionOperator = Matrix.identity(2);
    projectionOperator.set(1, 1, 0);
//    Matrix projectionOperator = new Matrix(2, 2, new float[]{1, 0, 0, 0});

    return projection(vector, projectionOperator);
  }

  public static Vector projection2DY(Vector vector){
    Matrix projectionOperator = Matrix.identity(2);
    projectionOperator.set(0, 0, 0);
//    Matrix projectionOperator = new Matrix(2, 2, new float[]{0, 0, 0, 1});

    return projection(vector, projectionOperator);
  }

  public static Vector projection3DXY(Vector vector){
    Matrix projectionOperator = Matrix.identity(3);
    projectionOperator.set(2, 2, 0);
//    Matrix projectionOperator = new Matrix(3, 3, new float[]{1, 0, 0, 0, 1, 0, 0, 0, 0});

    return projection(vector, projectionOperator);
  }

  public static Vector projection3DXZ(Vector vector){
    Matrix projectionOperator = Matrix.identity(3);
    projectionOperator.set(1, 1, 0);
//    Matrix projectionOperator = new Matrix(3, 3, new float[]{1, 0, 0, 0, 0, 0, 0, 0, 1});

    return projection(vector, projectionOperator);
  }

  public static Vector projection3DYZ(Vector vector){
    Matrix projectionOperator = Matrix.identity(3);
    projectionOperator.set(0, 0, 0);
//    Matrix projectionOperator = new Matrix(3, 3, new float[]{0, 0, 0, 0, 1, 0, 0, 0, 1});

    return projection(vector, projectionOperator);
  }
}
