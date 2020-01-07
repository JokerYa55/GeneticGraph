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

    @Override
    public PopulationInterface mutate(PopulationInterface population) {
        LOG.info("mutate");
        Random random = new Random();
        population.getPipulationItemList().forEach((t) -> {
            System.out.println(String.format("t = %s", t));
            GenInterface<Double> gen = (GenInterface<Double>) t.getGen();
            gen.getGenAsList().forEach((t1) -> {
                System.out.println(String.format("t1 = %s", t1));
                Double rand = 0d;
                if (random.nextBoolean()) {
                    rand = random.nextDouble();
                } else {
                    rand = -random.nextDouble();
                }
                System.out.println(String.format("rand = %s", rand));
                t1.setValue(t1.getValue() + rand);
                System.out.println(String.format("t1 = %s\n", t1));
            });
        });
        return population;
    }

}
