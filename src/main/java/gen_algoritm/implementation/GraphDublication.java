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
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;

@Log
@AllArgsConstructor
public class GraphDublication implements DublicateInterface {
    private static final int GEN_LEN = 7;
    private final Double[] x;

    @Override
    public PopulationInterface dublicate(PopulationInterface population) {
        log.info("-------------- dublicate --------------");
        // Получаем среднии значения генов;
        List<PopulationItemInterface> itemList = population.getPipulationItemList();
        int parentCount = population.getPipulationItemList().size();
        final GenInterface<Double> genNew = new GraphicGen(GEN_LEN);
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

        log.info("-------------- dublicate end ----------");
        return population;
    }

}
