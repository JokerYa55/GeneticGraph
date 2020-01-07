package gen_algoritm;

import java.util.List;

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

    PopulationItemInterface<P, T, V> calc(P... x);

    List<CalcResultInterface<P, P>> getBaseResultList();

    List<CalcResultInterface<P, P>> getGenResultList();
    
    void setGen(T gen);
}