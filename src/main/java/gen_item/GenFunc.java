package gen_item;

import static java.lang.Math.sin;


public class GenFunc implements CalcInterface{

    @Override
    public double calc(double x) {
        return 700*sin(x);
    }
    
}
