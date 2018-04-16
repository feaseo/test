package chen.junyu.sdcard;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;

import java.io.File;

/**
 * Created by Luori on 2018/4/2.
 */

public class MyDBHelper extends SQLiteOpenHelper {

    //private static String dbName = Utils.getPath() + File.separator + "a.db";
    private static String dbName = "b.db";
    private static final int VERSION = 1;

    public MyDBHelper(Context context) {
        //super(context, dbName, null, VERSION);
        super(new ExternalDbContext(context), dbName, null, VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
