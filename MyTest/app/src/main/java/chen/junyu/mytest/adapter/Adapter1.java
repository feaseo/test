package chen.junyu.mytest.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import chen.junyu.mytest.R;


public class Adapter1 extends RecyclerView.Adapter<Adapter1.MyHolder> {

    private Context context;
    private List<Integer> list;

    public Adapter1(Context context, List<Integer> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, null);
        MyHolder holder = new MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        holder.imageView.setImageResource(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{

        private ImageView imageView;

        public MyHolder(View itemView) {
            super(itemView);
            imageView = (ImageView)itemView.findViewById(R.id.iv_item);
        }
    }
}
