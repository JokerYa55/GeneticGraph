package gen_algoritm.implementation;

import gen_algoritm.AlelInterface;
import gen_algoritm.CalcInterface;
import gen_algoritm.DublicateInterface;
import gen_algoritm.GenInterface;
import gen_algoritm.PopulationInterface;
import gen_algoritm.PopulationItemInterface;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author vasil
 */
public class GraphDublication implements DublicateInterface {

    private static final Logger LOG = Logger.getLogger(GraphDublication.class.getName());
    private final Double[] x;

    public GraphDublication(Double... x) {
        this.x = x;
    }

    @Override
    public PopulationInterface dublicate(PopulationInterface population) {
        LOG.info("-------------- dublicate --------------");
        // Получаем среднии значения генов;
        List<PopulationItemInterface> itemList = population.getPipulationItemList();
        int parentCount = population.getPipulationItemList().size();
        final GenInterface<Double> genNew = new GraphicGen(5);
        List<Double[]> genList = new ArrayList();
        itemList.forEach((t) -> {
            GenInterface<AlelInterface<Double>> gen = (GenInterface<AlelInterface<Double>>) t.getGen();
            genList.add(gen.getGenAsArray());
        });
        genList.forEach((t) -> {
            for (int i = 0; i < t.length; i++) {
                AlelInterface<Double> alel = genNew.getGenAlel(i);
                alel.setValue(alel.getValue() + t[i]);
                genNew.setGenAlel(i, alel);
            }
        });

        genNew.getGenAsList().forEach((t) -> {
            t.setValue(t.getValue() / parentCount);
        });

        // Порождаем новые элементы популяции с новым геном
        CalcInterface<Double, Double, AlelInterface<Double>> genFunc = new FuncItem();
        CalcInterface<Double, Double, Double> baseFunc = new BaseFuncItem();
        // Создаем элемент для копирования
        for (int i = population.getPipulationItemList().size(); i < population.getPopulationItemCount(); i++) {
            PopulationItemInterface item = population.addPopulationItem(new GraphicItem("f_" + population.getStepNum() + "_" + i,
                    genFunc,
                    baseFunc, x, genNew));
        }
//        population.getPipulationItemList().forEach((t) -> {
//            System.out.println(String.format("criteria 4 = %s name = %s", t.getCriteriaResult(), t.getName()));
//        });

        LOG.info("-------------- dublicate end ----------");
        return population;
    }

}
