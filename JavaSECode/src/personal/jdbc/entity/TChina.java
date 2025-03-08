package personal.jdbc.entity;

import java.io.Serializable;

/*
模型类的几个必须要素
 - 私有的属性
 - 对应的get、set方法
 - 空参、有参构造方法
 - toString方法
 - 序列化
 */

public class TChina implements Serializable {

    private final long serialVersionUID = 4124564512L;

    private String name;
    private String value;
    private String parent;


    @Override
    public String toString() {
        return "TChina{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                ", parent='" + parent + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public TChina() {}
    public TChina(String name, String value, String parent) {
        this.name = name;
        this.value = value;
        this.parent = parent;
    }
}
