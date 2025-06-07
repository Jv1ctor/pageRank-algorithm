package Linear.Transforms;

import Linear.util.HomogeneousTransform;
import Linear.Matrices.MatrixOperators;
import Linear.Matrices.Matrix;
import Linear.Vectors.Vector;

public final class Translate {

  private static Vector translate(Vector vector, Vector vectorOperator, Matrix identity){
    Matrix inputMatrix = HomogeneousTransform.toHomogeneousVector(vector, 1);

    Matrix hTranslateMatrix = HomogeneousTransform.toHomogenousOperatorLinear(identity, vectorOperator);
    Matrix result = MatrixOperators.dot(hTranslateMatrix, inputMatrix);

    return HomogeneousTransform.fromHomogeneousVector(result);
  }

  public static Vector translate2D(Vector vector, float dx, float dy){
    Matrix identity = Matrix.identity(2);
    Vector vectorOperator = new Vector(2, new float[]{dx, dy});


    return translate(vector, vectorOperator, identity);
  }

  public static Vector translate3D(Vector vector, float dx, float dy, float dz){
    Matrix identity = Matrix.identity(3);
    Vector vectorOperator = new Vector(3, new float[]{dx, dy, dz});

    return translate(vector, vectorOperator, identity);
  }

}
