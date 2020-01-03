package gen_algoritm.implementation;

import gen_algoritm.GenInterface;
import gen_algoritm.PopulationItem;

public class GraphicItem implements PopulationItem<GenInterface<Double>, Double> {

    private final GenInterface<Double> gen = new GraphicGen();
    private String name;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Double getCriteriaResult() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GenInterface<Double> getGen() {
        return gen;
    }

}
