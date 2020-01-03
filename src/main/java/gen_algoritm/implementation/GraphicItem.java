package gen_algoritm.implementation;

import gen_algoritm.AlelInterface;
import gen_algoritm.CalcInterface;
import gen_algoritm.CalcResultInterface;
import gen_algoritm.GenInterface;
import gen_algoritm.PopulationItemInterface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class GraphicItem implements PopulationItemInterface<Double, GenInterface<Double>, Double> {

    private final GenInterface<Double> gen = new GraphicGen();
    private final String name;
    private final CalcInterface<Double, Double, Double> func;
    private Double criteriaResult = 0d;
    private List<CalcResultInterface<Double, Double>> resultList = new ArrayList<>();

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
    public PopulationItemInterface<Double, GenInterface<Double>, Double> init() {
        Random random = new Random();
        this.gen.getGenAsList().clear();
        for (int i = 0; i < 4; i++) {
            GraphicAlel alel = new GraphicAlel();
            if (random.nextBoolean()) {
                alel.setValue(-random.nextDouble());
            } else {
                alel.setValue(random.nextDouble());
            }

            this.gen.getGenAsList().add(alel);
        }
        return this;
    }

    // Получить расчитаные значения функции в точках
    public List<CalcResultInterface<Double, Double>> getResultList() {
        return resultList;
    }

    public GraphicItem calc(Double... x) {
        for (Double itemX : x) {
            CalcResultInterface<Double, Double> res = new FuncItemResult();
            res.setX(itemX);
            res.setY(func.calc(itemX, gen.getGenAsArray()).getY());
            resultList.add(res);
        }
        return this;
    }

}
