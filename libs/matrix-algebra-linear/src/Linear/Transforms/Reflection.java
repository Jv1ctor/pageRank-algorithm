package Linear.Transforms;

import Linear.util.HomogeneousTransform;
import Linear.Matrices.Matrix;
import Linear.Matrices.MatrixOperators;
import Linear.Vectors.Vector;

public class Reflection {

  private static Vector reflection(Vector vector, Matrix operator){
    Matrix inputMatrix = HomogeneousTransform.toHomogeneousVector(vector, 1);
    Matrix hOperatorMatrix = HomogeneousTransform.toHomogeneousOperatorLinear(operator);

    Matrix result = MatrixOperators.dot(hOperatorMatrix, inputMatrix);

    return HomogeneousTransform.fromHomogeneousVector(result);
  }


  public static Vector reflection2DX(Vector vector){
    Matrix reflectionOperator = Matrix.identity(2);
    reflectionOperator.set(1, 1, -1);
//    Matrix reflectionOperator = new Matrix(2, 2, new float[]{1, 0, 0, -1});

    return reflection(vector, reflectionOperator);
  }

  public static Vector reflection2DY(Vector vector){
    Matrix reflectionOperator = Matrix.identity(2);
    reflectionOperator.set(0, 0, -1);
//    Matrix reflectionOperator = new Matrix(2, 2, new float[]{-1, 0, 0, 1});

    return reflection(vector, reflectionOperator);
  }

  public static Vector reflection3DXY(Vector vector){
    Matrix reflectionOperator = Matrix.identity(3);
    reflectionOperator.set(2, 2, -1);
//    Matrix reflectionOperator = new Matrix(3, 3, new float[]{1, 0, 0, 0, 1, 0, 0, 0, -1});

    return reflection(vector, reflectionOperator);
  }

  public static Vector reflection3DYZ(Vector vector){
    Matrix reflectionOperator = Matrix.identity(3);
    reflectionOperator.set(0, 0, -1);
//    Matrix reflectionOperator = new Matrix(3, 3, new float[]{-1, 0, 0, 0, 1, 0, 0, 0, 1});

    return reflection(vector, reflectionOperator);
  }

  public static Vector reflection3DXZ(Vector vector){
    Matrix reflectionOperator = Matrix.identity(3);
    reflectionOperator.set(1, 1, -1);
//    Matrix reflectionOperator = new Matrix(3, 3, new float[]{1, 0, 0, 0, -1, 0, 0, 0, 1});

    return reflection(vector, reflectionOperator);
  }

}
