package Linear.Vectors;

import java.util.Arrays;
public class Vector {
    private int dim;
    private float[] elements;

    public Vector(int dim, float[] elements) {
        if(dim != elements.length){
            throw new Error("Quantidade de elementos incompatível com as dimensões do vetor");
        }

        this.dim = dim;
        this.elements = elements;
    }

    public int getDim(){
        return this.dim;
    }

    public float get(int i) {
        return elements[i];
    }

    public void set(int i, float value) {
        elements[i] = value;
    }

    public float[] getElements(){ return elements; }

    @Override
    public String toString(){
        return Arrays.toString(elements);
    }
}
