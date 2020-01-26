package gen_algoritm.implementation;

import gen_algoritm.CalcInterface;
import gen_algoritm.CalcResultInterface;
import lombok.extern.java.Log;

@Log
public class BaseFuncItem implements CalcInterface<Double, Double, Double> {

    @Override
    public CalcResultInterface<Double, Double> calc(Double x) {
        CalcResultInterface<Double, Double> result = new FuncItemResult();
        result.setX(x);
        //result.setY(2 + 3 * x /*- 6 * Math.pow(x, 2)*/ - 4 * Math.sin(x) * x);
        result.setY(5 * x + 4 * Math.sin(x) - 7 * Math.cos(x) + (3) / (11-x)+ 10);
        return result;
    }

    @Override
    public CalcResultInterface<Double, Double> calc(Double x, Double... param) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
