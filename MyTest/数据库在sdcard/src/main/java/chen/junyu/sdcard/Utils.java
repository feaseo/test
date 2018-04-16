package chen.junyu.sdcard;

import android.os.Environment;

import java.io.File;

/**
 * Created by Luori on 2018/4/2.
 */

public class Utils {

    public static String getPath() {
        File f = new File(Environment.getExternalStorageDirectory() + File.separator + "ab");
        if(!f.exists()) {
            f.mkdirs();
        }
        return f.getPath();
    }

}
