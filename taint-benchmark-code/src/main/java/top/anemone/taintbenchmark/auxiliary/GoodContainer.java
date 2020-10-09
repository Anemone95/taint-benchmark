package top.anemone.taintbenchmark.auxiliary;

public class GoodContainer<T> extends Container<T> {

    public T getInfo() {
        return super.getClean();
    }
}
