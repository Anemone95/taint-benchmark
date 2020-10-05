package top.anemone.taintbenchmark.auxiliary;

public class GoodContainer extends Container{

    public String getInfo() {
        return super.getClean();
    }
}
