package top.anemone.taintbenchmark.auxiliary;

public class GoodTransformer implements Transformer{
    public String transform(String from) {
        return "clean";
    }
}
