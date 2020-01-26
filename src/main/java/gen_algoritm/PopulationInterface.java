package gen_algoritm;

import java.util.List;

/**
 *
 */
public interface PopulationInterface {

    List<PopulationItemInterface> getPipulationItemList();

    int nextStep();

    int getPopulationItemCount();
    
    PopulationItemInterface addPopulationItem(PopulationItemInterface item);
    
    int getStepNum();
}
