package gen_algoritm.implementation;

import gen_algoritm.AlelInterface;
import gen_algoritm.CalcInterface;
import gen_algoritm.CalcResultInterface;

/**
 *
 * @author admin
 */
public class FuncItem implements CalcInterface<Double, Double, AlelInterface<Double>> {
    
    @Override
    public CalcResultInterface calc(Double x, AlelInterface<Double>... param) {
        CalcResultInterface result = new FuncItemResult();
        double res = 0;
        int i = 0;
        for (AlelInterface<Double> a : param) {
            res = res + a.getValue() * Math.pow(x, i);
        }
        result.setX(x);
        result.setY(res);
        return result;
    }

    @Override
    public CalcResultInterface<Double, Double> calc(Double x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
