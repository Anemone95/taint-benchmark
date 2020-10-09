package top.anemone.taintbenchmark.auxiliary;

public class BadContainer<T> extends Container<T> {

    public T getInfo() {
        return super.getClean();
    }
}
