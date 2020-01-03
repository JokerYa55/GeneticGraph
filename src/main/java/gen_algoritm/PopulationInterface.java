package gen_algoritm;

import java.util.List;

/**
 *
 * @author admin
 * @param <T> -Тип гена
 * @param <V> - Тип функции оценки критерия
 */
public interface PopulationInterface<T, V> {

    List<PopulationItem<T, V>> getPipulationItemList();
}
