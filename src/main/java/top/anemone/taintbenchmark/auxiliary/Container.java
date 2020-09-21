package top.anemone.taintbenchmark.auxiliary;

public class Container {
    private String xss;
    private String clean;
    public Container next;


    public Container(String xss, String clean) {
        this.xss = xss;
        this.clean = clean;
    }
    public Container() {
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
