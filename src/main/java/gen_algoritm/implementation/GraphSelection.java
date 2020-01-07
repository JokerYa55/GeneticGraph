package gen_algoritm.implementation;

import gen_algoritm.PopulationInterface;
import gen_algoritm.PopulationItemInterface;
import gen_algoritm.SelectionInterface;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author vasil
 */
public class GraphSelection implements SelectionInterface {

    private static final Logger LOG = Logger.getLogger(GraphSelection.class.getName());

    @Override
    public PopulationInterface selection(PopulationInterface population) {
        LOG.info("selection");
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
        LOG.info(String.format("itemList = %s", population.getPipulationItemList()));
        return population;
    }

}
