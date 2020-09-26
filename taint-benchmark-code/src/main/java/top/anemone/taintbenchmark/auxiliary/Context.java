package top.anemone.taintbenchmark.auxiliary;

public class Context {
    Transformer t;

    public void setT(Transformer t) {
        this.t = t;
    }

    public Transformer getT(){
        return t;
    }

    public void setTT(Transformer t) {
        setT(t);
    }

    public void setTTT(Transformer t) {
        setTT(t);
    }

}
