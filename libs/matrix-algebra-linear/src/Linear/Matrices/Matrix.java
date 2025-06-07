package Linear.Matrices;
import Linear.util.MatrixIdentity;

public class Matrix implements MatrixIdentity {
    private int rows;
    private int columns;
    private float[] elements;

    public Matrix(int rows, int columns, float[] elements){
        if(elements.length != (rows * columns)){
            throw new IllegalArgumentException("Quantidade de elementos incompatível com as dimensões da matriz");
        }
        this.rows = rows;
        this.columns = columns;
        this.elements = elements;
    }

    public float get(int i, int j){
        int index = i * columns + j;
        return this.elements[index];
    }

    public void set(int i, int j, float value){
        int index = i * columns + j;
        this.elements[index] = value;
    }

    public int getRows() {
        return this.rows;
    }

    public int getColumns(){
        return this.columns;
    }

    public float[] getElements(){ return this.elements; }

    public static Matrix identity(int dim){
        return MatrixIdentity.generateIdentity(dim);
    }

    @Override
    public String toString(){
        StringBuilder text = new StringBuilder();
        for(int i = 0; i < rows * columns; i ++){
            int indexCols = i % columns;
            text.append(elements[i]).append("  ");
            if(indexCols == columns - 1){
                text.append("\n");
            }
        }

        return text.toString();
    }
}
