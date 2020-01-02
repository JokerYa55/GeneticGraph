package gen_algoritm.implementation;

import gen_algoritm.AlelInterface;

/**
 *
 * @author admin
 */
public class GraphicAlel implements AlelInterface<Double> {

    private String name;
    private Double value;

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

}
