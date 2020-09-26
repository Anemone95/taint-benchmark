package top.anemone.taintbenchmark.auxiliary;

public class GoodPasser extends BadPasser {
    public String transform(String from){
        return "good";
    }
}
