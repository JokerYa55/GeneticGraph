package gen_algoritm;

import java.util.List;

/**
 *
 * @author admin
 * @param <T> -Тип гена
 * @param <V> - Тип функции оценки критерия
 */
public interface PopulationInterface<P, T, V> {

    List<PopulationItemInterface<P, T, V>> getPipulationItemList();
}
