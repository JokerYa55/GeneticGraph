package gen_algoritm;

/**
 * Элемент полуляции
 *
 * @author admin
 */
public interface PopulationItem<T> {

    String getName();

    T getCriteriaResult(); // Получить значение критерия для оценки
}
