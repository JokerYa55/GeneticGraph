package gen_algoritm.implementation;

import gen_algoritm.CalcInterface;
import gen_algoritm.GenInterface;
import gen_algoritm.PopulationInterface;
import gen_algoritm.PopulationItemInterface;
import static java.lang.Math.random;
import java.util.Random;

public class GraphicItem implements PopulationItemInterface<GenInterface<Double>, Double> {

    private final GenInterface<Double> gen = new GraphicGen();
    private final String name;
    private final CalcInterface<Double, Double, Double> func;
    private Double criteriaResult = 0d;

    public GraphicItem(String name, CalcInterface<Double, Double, Double> func) {
        this.name = name;
        this.func = func;
        init();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Double getCriteriaResult() {
        return criteriaResult;
    }

    @Override
    public GenInterface<Double> getGen() {
        return gen;
    }

    @Override
    public PopulationItemInterface<GenInterface<Double>, Double> init() {
        Random random = new Random();
        this.gen.getGen().clear();
        for (int i = 0; i < 4; i++) {
            GraphicAlel alel = new GraphicAlel();
            if (random.nextBoolean()) {
                alel.setValue(-random.nextDouble());
            } else {
                alel.setValue(random.nextDouble());
            }

            this.gen.getGen().add(alel);
        }
        return this;
    }

}
