package top.anemone.taintbenchmark.auxiliary;

public class Clazz1 {
    private String xss;
    private String clean;

    public Clazz1(String xss, String clean) {
        this.xss = xss;
        this.clean = clean;
    }
    public Clazz1() {
        this.xss = xss;
        this.clean = clean;
    }

    public String getXss() {
        return xss;
    }

    public void setXss(String xss) {
        this.xss = xss;
    }

    public String getClean() {
        return clean;
    }

    public void setClean(String clean) {
        this.clean = clean;
    }
}
