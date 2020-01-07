package gen_algoritm.implementation;

import gen_algoritm.DublicateInterface;
import gen_algoritm.PopulationInterface;
import gen_algoritm.PopulationItemInterface;
import java.util.List;

/**
 *
 * @author vasil
 */
public class GraphDublication implements DublicateInterface {

    @Override
    public PopulationInterface dublicate(PopulationInterface population) {
        // Получаем среднии значения генов;
        List<PopulationItemInterface> itemList = population.getPipulationItemList();
        
        
        return population;
    }

}
