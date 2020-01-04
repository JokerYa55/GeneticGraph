package gen_algoritm.implementation;

import gen_algoritm.CalcInterface;
import gen_algoritm.CalcResultInterface;
import static java.lang.Math.sin;
import java.util.logging.Logger;

public class BaseFuncItem implements CalcInterface<Double, Double, Double> {

    private static final Logger LOG = Logger.getLogger(BaseFuncItem.class.getName());

    @Override
    public CalcResultInterface<Double, Double> calc(Double x) {
        CalcResultInterface<Double, Double> result = new FuncItemResult();
        result.setX(x);
        result.setY(sin(x));
        return result;
    }

    @Override
    public CalcResultInterface<Double, Double> calc(Double x, Double... param) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
