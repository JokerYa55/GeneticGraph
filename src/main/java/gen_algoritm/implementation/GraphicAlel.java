package gen_algoritm.implementation;

import gen_algoritm.AlelInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class GraphicAlel implements AlelInterface<Double> {

    private String name;
    private Double value;

    public GraphicAlel(String name) {
        this.name = name;
    }

}
