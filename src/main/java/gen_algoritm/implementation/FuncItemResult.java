package gen_algoritm.implementation;

import gen_algoritm.CalcResultInterface;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FuncItemResult implements CalcResultInterface<Double, Double> {

    private Double x;
    private Double y;

}
