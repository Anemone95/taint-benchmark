package top.anemone.taintbenchmark.auxiliary;

public class Container<T> {
    public T clean;
    public T obj;


    public Container(T obj, T clean) {
        this.obj = obj;
        this.clean = clean;
    }

    public Container() {
    }

    public T getObj() {
        return obj;
    }

    public void setSetSetObj(T obj) {
        setSetObj(obj);
    }

    public void setSetObj(T obj) {
        setObj(obj);
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public T getClean() {
        return clean;
    }

    public void setClean(T clean) {
        this.clean = clean;
    }

    public T getInfo() {
        return this.obj;
    }


    public T getObjObj(T t) {
        Container<T> c1 = new Container<>();
        c1.setObj(t);
        return c1.getObj();
    }

    public T getObjObjObj(T t) {
        Container<T> c1 = new Container<>();
        Container<Container<T>> c2 = new Container<>();
        c1.setObj(t);
        c2.setObj(c1);
        return c2.getObj().getObj();
    }

}
