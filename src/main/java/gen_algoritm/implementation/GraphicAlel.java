package gen_algoritm.implementation;

import gen_algoritm.AlelInterface;

public class GraphicAlel implements AlelInterface<Double> {

    private String name;
    private Double value;

    public GraphicAlel() {
    }

    public GraphicAlel(String name) {
        this.name = name;
    }

    public GraphicAlel(String name, Double value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public Double getValue() {
        return value;
    }

    @Override
    public void setValue(Double val) {
        value = val;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "GraphicAlel{" + "name=" + name + ", value=" + value + '}';
    }

}
