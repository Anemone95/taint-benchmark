package top.anemone.taintbenchmark.auxiliary;

public class GoodConstructor implements Transformer{
    private String s;
    public GoodConstructor(String s){
        this.s="good";
    }

    public String transform(String from) {
        return s;
    }
}
