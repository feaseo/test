package chen.junyu.mytest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import chen.junyu.mytest.adapter.Adapter2;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init1();//测试RecyclerView
    }

    private void init1() {
        //https://blog.csdn.net/htwhtw123/article/details/77917403
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(R.drawable.c,
                R.drawable.d, R.drawable.e, R.drawable.q));
        List<String> list2 = new ArrayList<String>(Arrays.asList("aa","vv","ww","rr","qq","dd"));

        RecyclerView recyclerView = (RecyclerView)this.findViewById(R.id.rc);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        //recyclerView.setAdapter(new Adapter1(this, list));
        recyclerView.setAdapter(new Adapter2(this, list2));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

    }

}
