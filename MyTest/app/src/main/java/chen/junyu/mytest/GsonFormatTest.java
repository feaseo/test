package chen.junyu.mytest;



public class GsonFormatTest {

    //根据json，快速生成对应bean参数，mac的快捷键 option(alt) + s
    //{"id":"2","name":"ab"}
    /**
     * id : 2
     * name : ab
     */

    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
