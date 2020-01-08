package gen_algoritm.implementation;

import gen_algoritm.AlelInterface;
import gen_algoritm.GenInterface;
import gen_algoritm.MutationInterface;
import gen_algoritm.PopulationInterface;
import gen_algoritm.PopulationItemInterface;
import java.util.Random;
import java.util.logging.Logger;

/**
 *
 * @author vasil
 */
public class GraphMutation implements MutationInterface {

    private static final Logger LOG = Logger.getLogger(GraphMutation.class.getName());
    private final Double[] x;

    public GraphMutation(Double... x) {
        this.x = x;
    }

    @Override
    public PopulationInterface mutate(PopulationInterface population) {
        LOG.info("--------------- mutate ---------------");
        Random random = new Random();
        population.getPipulationItemList().stream().skip(2).forEach((t) -> {
            GenInterface<Double> gen = (GenInterface<Double>) t.getGen();
            //System.out.println(String.format("gen = %s", gen));
            for (int i = 0; i < gen.getGenAsList().size(); i++) {
                Double rand = 0d;
                if (random.nextBoolean()) {
                    rand = random.nextDouble();
                } else {
                    rand = -random.nextDouble();
                }
                //System.out.println("rand = " + rand / 100);
                AlelInterface<Double> alelNew = new GraphicAlel(i + "", gen.getGenAlel(i).getValue() + rand );
                gen.setGenAlel(i, alelNew);
            }
            t.setGen(gen);
            //System.out.println(String.format("gen = %s", t.getGen()));
        });

        population.getPipulationItemList().forEach((PopulationItemInterface t) -> {
            //System.out.println(String.format("t = %s", t.getGen()));
            t.calc(x);
        });

//        population.getPipulationItemList().forEach((t) -> {
//            System.out.println(String.format("criteria 6 = %s name = %s", t.getCriteriaResult(), t.getName()));
//        });

        LOG.info("--------------- mutate end ------------");
        return population;
    }

}
