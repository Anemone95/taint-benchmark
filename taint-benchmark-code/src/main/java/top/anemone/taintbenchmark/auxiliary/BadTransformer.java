package top.anemone.taintbenchmark.auxiliary;

public class BadTransformer implements Transformer {
    public String transform(String from) {
        return from;
    }
}
