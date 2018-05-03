package chen.junyu.mytest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import chen.junyu.mytest.bean.EventBusString;


public class TestEventBus extends Activity implements View.OnClickListener{

    private TextView tv;
    private boolean isFirst = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eventbus_layout);

        init();
    }

    private void init() {
        Button bt1 = (Button) findViewById(R.id.bt_bus_1);
        Button bt2 = (Button) findViewById(R.id.bt_bus_2);
        tv = (TextView) findViewById(R.id.tv_bus_1);

        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
           case R.id.bt_bus_1:
               EventBusString bus = new EventBusString(1, "test", "250平");
               EventBus.getDefault().post(bus);

                break;

            case R.id.bt_bus_2:
                if(isFirst) {
                    EventBus.getDefault().register(this);
                    isFirst = false;
                }
                Intent i = new Intent(this, TestEventBus1.class);
                startActivity(i);

                break;

           default:
                break;
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void getEventbusDelay(EventBusString bus) {
        Toast.makeText(this, bus.toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().removeAllStickyEvents();
        EventBus.getDefault().unregister(this);
    }
}
