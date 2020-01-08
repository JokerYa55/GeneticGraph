package gen_algoritm;

import java.util.List;

/**
 *
 * @param <T> -Тип аргумента функции
 * @param <V> - Тип функции оценки критерия
 */
public interface PopulationInterface {

    List<PopulationItemInterface> getPipulationItemList();

    int nextStep();

    int getPopulationItemCount();
    
    PopulationItemInterface addPopulationItem(PopulationItemInterface item);
    
    int getStepNum();
}
