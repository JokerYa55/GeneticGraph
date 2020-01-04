package gen_algoritm;

import java.util.List;

/**
 *
 * @param <T> -Тип гена
 * @param <V> - Тип функции оценки критерия
 */
public interface PopulationInterface {

    List<PopulationItemInterface> getPipulationItemList();
    int nextStep();

}
