package gen_algoritm;

/**
 * Элемент полуляции
 *
 * @author admin
 * @param <P> - Тмип аргумента функции
 * @param <T> - Тип гена
 * @param <V> - Тип Функции оценки эффективности
 */
public interface PopulationItemInterface<P, T, V> {

    String getName();

    T getGen();

    V getCriteriaResult(); // Получить значение критерия для оценки

    PopulationItemInterface<P, T, V> init();
}
