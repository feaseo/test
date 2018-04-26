package chen.junyu.mytest.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import chen.junyu.mytest.R;


public class Adapter2 extends RecyclerView.Adapter<Adapter2.MyHolder> {

    private Context context;
    private List<String> list;

    public Adapter2(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item2, null);
        MyHolder holder = new MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, final int position) {
        holder.tv.setText(list.get(position));
        holder.tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "点击了:" + list.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{

        private TextView tv;

        public MyHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.tv_item2);
        }
    }
}
