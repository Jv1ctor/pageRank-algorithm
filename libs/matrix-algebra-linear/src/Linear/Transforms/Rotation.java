package Linear.Transforms;

import Linear.util.HomogeneousTransform;
import Linear.Matrices.Matrix;
import Linear.Matrices.MatrixOperators;
import Linear.Vectors.Vector;

public final class Rotation {

  private static Vector rotation(Vector vector, Matrix operator){
    Matrix inputMatrix = HomogeneousTransform.toHomogeneousVector(vector, 1);
    Matrix hRotationMatrix = HomogeneousTransform.toHomogeneousOperatorLinear(operator);

    Matrix result = MatrixOperators.dot(hRotationMatrix, inputMatrix);

    return HomogeneousTransform.fromHomogeneousVector(result);
  }

  public static Vector rotation2D(Vector vector, int angle){
    float angleRad = (float) Math.toRadians(angle);

    float[] elements = { (float)Math.cos(angleRad), (float)(-Math.sin(angleRad)), (float) Math.sin(angleRad), (float) Math.cos(angleRad) };
    Matrix rotationMatrix = new Matrix(2, 2, elements);


    return rotation(vector, rotationMatrix);
  }

  public static Vector rotation3DX(Vector vector, int angle){
    float angleRad = (float) Math.toRadians(angle);

    float[] elements = { 1, 0, 0, 0, (float) Math.cos(angleRad), (float)(- Math.sin(angleRad)), 0, (float) Math.sin(angleRad), (float) Math.cos(angleRad)};
    Matrix rotationMatrix3DX = new Matrix(3, 3, elements);

    return rotation(vector, rotationMatrix3DX);
  }

  public static Vector rotation3DY(Vector vector, int angle){
    float angleRad = (float) Math.toRadians(angle);

    float[] elements = { (float) Math.cos(angleRad), 0, (float)(Math.sin(angleRad)), 0, 1, 0, (float)(-Math.sin(angleRad)), 0, (float) Math.cos(angleRad)};
    Matrix rotationMatrix3DY = new Matrix(3, 3, elements);

    return rotation(vector, rotationMatrix3DY);
  }

  public static Vector rotation3DZ(Vector vector, int angle){
    float angleRad = (float) Math.toRadians(angle);

    float[] elements = { (float)Math.cos(angleRad), (float)(-Math.sin(angleRad)), (float) Math.sin(angleRad), (float) Math.cos(angleRad) };
    Matrix rotationMatrix2d = new Matrix(2, 2, elements);

    Matrix rotationMatrix3DZ = HomogeneousTransform.toHomogeneousOperatorLinear(rotationMatrix2d);

    return rotation(vector, rotationMatrix3DZ);
  }

}
