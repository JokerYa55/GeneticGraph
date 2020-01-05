package gen_item;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Bot {

    private static int count = 0;
    // Результаты вычисления функции
    private final BotResult result = new BotResult();
    // ax^3 + bx^2 + cx + d
    private double a, b, c, d;
    private Double[] x;
    private final String name;

    public Bot(Double... x) {
        this.x = x;
        initDnk();
        count++;
        name = "f_" + count;
        result.setName(name);
    }

    public void initDnk() {
        Random random = new Random();
        if (random.nextBoolean()) {
            this.a = -random.nextDouble();
        } else {
            this.a = -random.nextDouble();
        }
        if (random.nextBoolean()) {
            this.b = -random.nextDouble();
        } else {
            this.b = random.nextDouble();
        }
        if (random.nextBoolean()) {
            this.c = -random.nextDouble();
        } else {
            this.c = random.nextDouble();
        }
        if (random.nextBoolean()) {
            this.d = -random.nextDouble();
        } else {
            this.d = random.nextDouble();
        }
    }

    public void calc() {
        BotFunc funk = new BotFunc();
        CalcInterface genFunc = new GenFunc();
        List<ResultItem> resultList = new ArrayList();
        for (int i = 0; i < x.length; i++) {
            ResultItem item = new ResultItem();
            item.setX(x[i]);
            item.setFx(funk.calc(x[i], a, b, c, d));
            resultList.add(item);
        }
        result.setResltCalc(resultList);

    }

    public BotResult getResult() {
        return result;
    }

}
