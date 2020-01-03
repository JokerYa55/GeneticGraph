package gen_algoritm;

/**
 * Элемент полуляции
 *
 * @author admin
 * @param <T> - Тип гена
 * @param <V> - Тип Функции оценки эффективности
 */
public interface PopulationItem<T, V> {

    String getName();

    T getGen();

    V getCriteriaResult(); // Получить значение критерия для оценки
}
