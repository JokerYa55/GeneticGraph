package gen_algoritm.implementation;

import gen_algoritm.AlelInterface;
import gen_algoritm.CalcInterface;
import gen_algoritm.DublicateInterface;
import gen_algoritm.GenInterface;
import gen_algoritm.MutationInterface;
import gen_algoritm.PopulationInterface;
import gen_algoritm.PopulationItemInterface;
import gen_algoritm.SelectionInterface;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class Population implements PopulationInterface {

    private static final Logger LOG = Logger.getLogger(Population.class.getName());
    private final List<PopulationItemInterface> populationItemList;
    private int stepNum = 0;
    private SelectionInterface selctionGraph = new GraphSelection();
    private DublicateInterface dublicateGraph = new GraphDublication();
    private MutationInterface mutatationGraph = new GraphMutation();
    private final Double[] x;
    private int populationItemCount;

    public Population(int populationCount, Double... x) {
        this.populationItemCount = populationCount;
        this.x = x;
        populationItemList = new ArrayList<>(populationCount);
        CalcInterface<Double, Double, AlelInterface<Double>> genFunc = new FuncItem();
        CalcInterface<Double, Double, Double> baseFunc = new BaseFuncItem();
        for (int i = 0; i < populationCount; i++) {
            PopulationItemInterface<Double, GenInterface<Double>, Double> populationItem = new GraphicItem("f_" + i, genFunc, baseFunc);
            populationItemList.add(populationItem);
        }
    }

    @Override
    public List<PopulationItemInterface> getPipulationItemList() {
        return populationItemList;
    }

    private void calc() {
        populationItemList.forEach((t) -> {
            t.calc(x);
        });
    }

    @Override
    public int getPopulationItemCount() {
        return populationItemCount;
    }

    @Override
    public PopulationItemInterface addPopulationItem(PopulationItemInterface item) {
        populationItemList.add(item);
        return item;
    }

    @Override
    public int nextStep() {
        stepNum++;
        LOG.info(String.format("************** step num = %s *****************", stepNum));
        calc();
        // Отбор
        selctionGraph.selection(this);
        // Размножение
        dublicateGraph.dublicate(this);
        //calc();
        // Скрещивание
        // Мутация
        //mutatationGraph.mutate(this);
        calc();
        return stepNum;
    }

}
