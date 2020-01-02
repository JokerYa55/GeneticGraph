package gen_algoritm;

/**
 * Мутация
 *
 * @author admin
 */
public interface MutationInterface<T> {

    PopulationItem<T> mutate(PopulationItem<T> item);
}
