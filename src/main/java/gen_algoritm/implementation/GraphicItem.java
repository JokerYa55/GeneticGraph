package gen_algoritm.implementation;

import gen_algoritm.CalcInterface;
import gen_algoritm.CalcResultInterface;
import gen_algoritm.GenInterface;
import gen_algoritm.PopulationItemInterface;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GraphicItem implements PopulationItemInterface<Double, GenInterface<Double>, Double> {

    private GenInterface<Double> gen = new GraphicGen();
    private final String name;
    // Функция для генов
    private final CalcInterface<Double, Double, Double> genFunc;
    // Функция базовая
    private final CalcInterface<Double, Double, Double> baseFunc;
    private Double criteriaResult = 0d;
    // Результаты вычисления базовой функции на интервале
    private final List<CalcResultInterface<Double, Double>> baseResultList = new ArrayList<>();
    // Результаты вычисления гена на интервале.
    private final List<CalcResultInterface<Double, Double>> genResultList = new ArrayList<>();

    public GraphicItem(String name, CalcInterface<Double, Double, Double> genFunc, CalcInterface<Double, Double, Double> baseFunc) {
        this.name = name;
        this.genFunc = genFunc;
        this.baseFunc = baseFunc;
        init();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Double getCriteriaResult() {
        baseResultList.forEach((t) -> {
        });
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
        return genResultList;
    }

    public GraphicItem calc(Double... x) {
        for (Double itemX : x) {
            CalcResultInterface<Double, Double> res = new FuncItemResult();
            res.setX(itemX);
            res.setY(genFunc.calc(itemX, gen.getGenAsArray()).getY());
            genResultList.add(res);
        }
        return this;
    }

    public void setGen(GenInterface<Double> gen) {
        this.gen = gen;
    }

}
