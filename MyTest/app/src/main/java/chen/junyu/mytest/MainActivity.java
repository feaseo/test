package chen.junyu.mytest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import chen.junyu.mytest.adapter.Adapter1;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init1();//测试RecyclerView
    }

    private void init1() {
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(R.drawable.c,
                R.drawable.d, R.drawable.e, R.drawable.q));
        RecyclerView recyclerView = (RecyclerView)this.findViewById(R.id.rc);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new Adapter1(this, list));

        recyclerView.seto
    }

}
