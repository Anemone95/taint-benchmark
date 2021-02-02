package top.anemone.taintbenchmark.auxiliary;

public class TransformerFactory {
    public static Transformer getTransformer(String type){
        if (type.equals("bad")){
            return new BadTransformer();
        } else {
            return new GoodTransformer();
        }
    }
}
