package Linear.util;

import Linear.Matrices.Matrix;

import java.util.Arrays;
import java.util.Comparator;


public class Format{
    private Matrix matrix;
    private int precision;
    private SortMatrix order = SortMatrix.DEFAULT;

    public Format(Matrix matrix, int precision, SortMatrix order){
        this.matrix = matrix;
        this.precision = precision;
        this.order = order;
    }

    private float[] orderBy(float[] elements, SortMatrix order){
        switch (order){
            case ASC -> Arrays.sort(elements);
            case DESC -> {
                float[] orderElements = new float[elements.length];
                System.arraycopy(elements, 0, orderElements, 0,elements.length);
                Arrays.sort(orderElements);

                for(int i = 0; i < elements.length; i++){
                    elements[i] = orderElements[elements.length - 1 - i];
                }

            }
        }


        return elements;
    }

    public String toString(){
        StringBuilder text = new StringBuilder();
        int cols = matrix.getColumns();
        float[] elements = matrix.getElements();

        // Define largura mínima e casas decimais, ex: "%10.5f" → largura 10, 5 casas decimais
        String formatStr = "%" + (this.precision + 5) + "." + this.precision + "f";

        for (int i = 0; i < elements.length; i++) {
            text.append(String.format(formatStr, this.orderBy(elements, this.order)[i])).append("  ");

            if ((i + 1) % cols == 0) {
                text.append("\n");
            }
        }

        return text.toString();
    }
}
