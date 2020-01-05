package gen_algoritm.implementation;

import gen_algoritm.AlelInterface;
import gen_algoritm.CalcInterface;
import gen_algoritm.GenInterface;
import gen_algoritm.PopulationInterface;
import gen_algoritm.PopulationItemInterface;
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

    public Population(int populationCount) {
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

    @Override
    public int nextStep() {
        stepNum++;
        // Отбор
        // Размножение
        // Мутация

        return stepNum;
    }

}