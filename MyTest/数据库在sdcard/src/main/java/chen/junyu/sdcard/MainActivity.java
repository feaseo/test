package chen.junyu.sdcard;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        init1();//测试exception的null
    }

    private void init1() {
        try {
            int i = 1 / 0;
        } catch (Exception e) {
            e = null;
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            PrintStream ps = new PrintStream(stream);
            e.printStackTrace(ps);
        }
    }

    private void init() {
        Button bt = (Button)findViewById(R.id.bt);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*MyDBHelper help = new MyDBHelper(MainActivity.this);
                SQLiteDatabase db = help.getWritableDatabase();
                db.close();*/
                new My().execute();
            }
        });
    }

    private class My extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            SQLiteDatabase db = SQLiteDatabase.openDatabase("/sdcard/queue.db", null,
                    SQLiteDatabase.OPEN_READWRITE | SQLiteDatabase.NO_LOCALIZED_COLLATORS);
            String sql = "select content from queue;";
            Cursor cursor = db.rawQuery(sql, null);
            int i = 1;
            while(cursor.moveToNext()) {
                byte[] blob = cursor.getBlob(0);
                String s = new String(blob);
                createFileWithByte(blob, i + "_sync.ul");
                Log.i("23", "s:" + s);
                i ++;
            }
            cursor.close();
            db.close();

            return null;
        }
    }

    private void createFileWithByte(byte[] bytes, String fileName) {
        // TODO Auto-generated method stub
        /**
         * 创建File对象，其中包含文件所在的目录以及文件的命名
         */
        File file = new File(Environment.getExternalStorageDirectory(),
                fileName);
        // 创建FileOutputStream对象
        FileOutputStream outputStream = null;
        // 创建BufferedOutputStream对象
        BufferedOutputStream bufferedOutputStream = null;
        try {
            // 如果文件存在则删除
            if (file.exists()) {
                file.delete();
            }
            // 在文件系统中根据路径创建一个新的空文件
            file.createNewFile();
            // 获取FileOutputStream对象
            outputStream = new FileOutputStream(file);
            // 获取BufferedOutputStream对象
            bufferedOutputStream = new BufferedOutputStream(outputStream);
            // 往文件所在的缓冲输出流中写byte数据
            bufferedOutputStream.write(bytes);
            // 刷出缓冲输出流，该步很关键，要是不执行flush()方法，那么文件的内容是空的。
            bufferedOutputStream.flush();
        } catch (Exception e) {
            // 打印异常信息
            e.printStackTrace();
        } finally {
            // 关闭创建的流对象
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedOutputStream != null) {
                try {
                    bufferedOutputStream.close();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

}
