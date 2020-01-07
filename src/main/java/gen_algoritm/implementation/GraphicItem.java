package gen_algoritm.implementation;

import gen_algoritm.AlelInterface;
import gen_algoritm.CalcInterface;
import gen_algoritm.CalcResultInterface;
import gen_algoritm.GenInterface;
import gen_algoritm.PopulationItemInterface;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

public class GraphicItem implements PopulationItemInterface<Double, GenInterface<Double>, Double> {

    private static final Logger LOG = Logger.getLogger(GraphicItem.class.getName());

    private GenInterface<Double> gen = new GraphicGen(4);
    private final String name;
    // Функция для генов
    private final CalcInterface<Double, Double, AlelInterface<Double>> genFunc;
    // Функция базовая
    private final CalcInterface<Double, Double, Double> baseFunc;
    private Double criteriaResult = 0d;
    // Результаты вычисления базовой функции на интервале
    private final List<CalcResultInterface<Double, Double>> baseResultList = new ArrayList<>();
    // Результаты вычисления гена на интервале.
    private final List<CalcResultInterface<Double, Double>> genResultList = new ArrayList<>();

    public GraphicItem(String name, CalcInterface<Double, Double, AlelInterface<Double>> genFunc, CalcInterface<Double, Double, Double> baseFunc) {
        //LOG.info(String.format("GraphicItem = %s", name));
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
        //LOG.info(String.format("criteriaResult = %s", criteriaResult));
        return criteriaResult;
    }

    @Override
    public GenInterface<Double> getGen() {
        return gen;
    }

    @Override
    public PopulationItemInterface<Double, GenInterface<Double>, Double> init() {
        //LOG.info("init");
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
            res.setY(genFunc.calc(itemX, gen.getGenAsList().stream().map((t) -> {
                return t; //To change body of generated lambdas, choose Tools | Templates.
            }).toArray(GraphicAlel[]::new)).getY());
            genResultList.add(res);

            CalcResultInterface<Double, Double> res1 = new FuncItemResult();
            res1.setX(itemX);
            res1.setY(baseFunc.calc(itemX).getY());
            baseResultList.add(res1);

        }
        // Считаем функцию критерию
        Double[] baseRes = baseResultList.stream().map((t) -> {
            return t.getY();
        }).toArray(Double[]::new);

        Double[] genRes = genResultList.stream().map((t) -> {
            return t.getY();
        }).toArray(Double[]::new);

        for (int i = 0; i < baseRes.length; i++) {
            criteriaResult = criteriaResult + Math.pow(baseRes[i] - genRes[i], 2);
        }
        criteriaResult = Math.sqrt(criteriaResult);
        return this;
    }

    @Override
    public List<CalcResultInterface<Double, Double>> getBaseResultList() {
        return baseResultList;
    }

    @Override
    public List<CalcResultInterface<Double, Double>> getGenResultList() {
        return genResultList;
    }

    @Override
    public void setGen(GenInterface<Double> gen) {
        this.gen = gen;
    }

    @Override
    public String toString() {
        return "GraphicItem{" + "gen=" + gen + ", name=" + name + ", genFunc=" + genFunc + ", baseFunc=" + baseFunc + ", criteriaResult=" + criteriaResult + ", baseResultList=" + baseResultList + ", genResultList=" + genResultList + '}';
    }

    
    
}
