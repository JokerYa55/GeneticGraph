package gen_item;

import java.util.ArrayList;
import java.util.List;

public class BotBase {

    // Результаты вычисления функции
    private final List<ResultItem> resultList = new ArrayList<>();
    // sin(x)
    private final Double[] x;

    public BotBase(Double... x) {
        this.x = x;
    }


    public void calc() {
        CalcInterface genFunc = new GenFunc();
        for (int i = 0; i < x.length; i++) {
            ResultItem item = new ResultItem();
            item.setX(x[i]);
            item.setFx(genFunc.calc(x[i]));
            resultList.add(item);
        }
    }

    public List<ResultItem> getResultList() {
        return resultList;
    }

}
