package top.anemone.taintbenchmark.auxiliary;

public class BadContainer extends Container{

    public String getInfo() {
        return super.getClean();
    }
}
