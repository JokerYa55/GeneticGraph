package gen_algoritm.implementation;

import gen_algoritm.PopulationInterface;
import gen_algoritm.PopulationItemInterface;
import gen_algoritm.SelectionInterface;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author vasil
 */
public class GraphSelection implements SelectionInterface {

    @Override
    public PopulationInterface selection(PopulationInterface population) {
        population.getPipulationItemList().sort((PopulationItemInterface o1, PopulationItemInterface o2) -> {
            if (((Double) o1.getCriteriaResult()) >= ((Double) o2.getCriteriaResult())) {
                return 1;
            } else {
                return -1;
            }
        });
        List temp = population.getPipulationItemList().stream().limit(2).
                collect(Collectors.toList());
        population.getPipulationItemList().clear();
        population.getPipulationItemList().addAll(temp);
        return population;
    }

}
