package chen.junyu.mytest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import chen.junyu.mytest.adapter.Adapter2;

import static chen.junyu.mytest.R.drawable.e;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init1();//测试RecyclerView
    }

    private void init1() {
        Button bt1 = (Button)findViewById(R.id.bt1);
        Button bt2 = (Button)findViewById(R.id.bt2);
        Button bt3 = (Button)findViewById(R.id.bt3);

        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);

        //https://blog.csdn.net/htwhtw123/article/details/77917403
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(R.drawable.c,
                R.drawable.d, e, R.drawable.q));
        List<String> list2 = new ArrayList<String>(Arrays.asList("aa","vv","ww","rr","qq","dd"));

        RecyclerView recyclerView = (RecyclerView)this.findViewById(R.id.rc);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        //recyclerView.setAdapter(new Adapter1(this, list));
        recyclerView.setAdapter(new Adapter2(this, list2));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

    }

    @Override
    public void onClick(View v) {

    }
}
