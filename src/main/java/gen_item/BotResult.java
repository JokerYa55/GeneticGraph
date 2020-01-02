package gen_item;

import java.util.List;

public class BotResult {

    private String name;
    private List<ResultItem> resltCalc;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ResultItem> getResltCalc() {
        return resltCalc;
    }

    public void setResltCalc(List<ResultItem> resltCalc) {
        this.resltCalc = resltCalc;
    }

}
