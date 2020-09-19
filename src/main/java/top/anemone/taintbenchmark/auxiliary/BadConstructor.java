package top.anemone.taintbenchmark.auxiliary;

public class BadConstructor implements Transformer{
    private String s;
    public BadConstructor(String s){
        this.s=s;
    }

    public String transform(String from) {
        return s;
    }
}
