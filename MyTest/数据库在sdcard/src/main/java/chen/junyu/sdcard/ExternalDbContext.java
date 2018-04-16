package chen.junyu.sdcard;

import android.content.Context;
import android.content.ContextWrapper;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;

import java.io.File;

/**
 * Created by Luori on 2018/4/4.
 */

class ExternalDbContext extends ContextWrapper {

    private String sqlite_db_dir = "Like3";
    private String package_name = getPackageName();

    public ExternalDbContext(Context context) {
        super(context);
    }

    @Override
    public File getDatabasePath(String name) {
        return getDbPath(name);
    }

    @Override
    public SQLiteDatabase openOrCreateDatabase(String name, int mode, SQLiteDatabase.CursorFactory factory, DatabaseErrorHandler errorHandler) {
        File f = getDatabasePath(name);
        int flags = SQLiteDatabase.CREATE_IF_NECESSARY;
        if((mode & MODE_ENABLE_WRITE_AHEAD_LOGGING) != 0) {
            flags |= SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING;
        }
        return SQLiteDatabase.openDatabase(f.getPath(), factory, flags, errorHandler);
    }

    private File getDbPath(String name) {
        File sdcard = Environment.getExternalStorageDirectory();
        File dbDir = new File(sdcard, sqlite_db_dir + File.separator + package_name);
        if(!dbDir.exists()) {
            dbDir.mkdirs();
        }
        String n = name;
        if(!n.endsWith(".db")) {
            n = n + ".db";
        }
        return new File(dbDir, n);
    }
}
