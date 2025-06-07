package Linear.util;

import Linear.Matrices.Matrix;

public interface MatrixIdentity {
   static Matrix generateIdentity(int dim){
      Matrix matrix = new Matrix(dim, dim, new float[dim * dim]);

      for(int i = 0; i < dim; i++){
        matrix.set(i, i, 1);
      }

      return  matrix;
  }

}
