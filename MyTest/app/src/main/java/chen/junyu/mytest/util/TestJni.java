package chen.junyu.mytest.util;

public class TestJni {

    static {
        System.loadLibrary("Test");
    }

    public native String getStr();

}
