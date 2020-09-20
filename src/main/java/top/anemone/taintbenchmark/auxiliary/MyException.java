package top.anemone.taintbenchmark.auxiliary;

public class MyException extends Exception {
    private String s;
    public MyException(String s){
        this.s=s;
    }

    @Override
    public String toString() {
        return s;
    }
}
