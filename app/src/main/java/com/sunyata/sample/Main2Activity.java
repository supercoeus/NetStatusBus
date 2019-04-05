package com.sunyata.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.sunyata.netbus.NetStateBus;
import com.sunyata.netbus.annotation.Network;
import com.sunyata.netbus.type.NetType;
import com.sunyata.netbus.utils.Constrants;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        NetStateBus.getDefault().register(this);

    }

    @Network(netType = NetType.WIFI)
    public void doNet(NetType netType) {
        Log.e(Constrants.LOG_TAG, netType.name() + "<<<<<<<<<<activity2");
    }

    @Network(netType = NetType.AUTO)
    public void doNet2(NetType netType) {
        Log.e(Constrants.LOG_TAG, netType.name() + "<<<<<<<<<<activity2");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        NetStateBus.getDefault().unregister(this);
    }
}