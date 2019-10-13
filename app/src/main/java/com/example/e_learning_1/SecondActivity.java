package com.example.e_learning_1;

import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;


public class SecondActivity extends AppCompatActivity {
    private ListView Lv = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Lv = (ListView) findViewById(R.id.Lv);

        final String[] name = new String[] { "中国经典经济学", "计算机操作系统", "外国文学欣赏" ,"多元统计分析","宇宙简史","化妆品鉴赏与应用","神话与神话研究","生理心理学"};
        final String[] message = new String[] {
                "EconomyDvp.txt",
                "ComputeOS.txt",
                "ApreOfFL.txt",
                "MulStaAnasis.txt",
                "BriefHOfUniverse.txt",
                "AppreciaAndAPPIOfCos.txt",
                 "MythAndMyRe.txt",
                 "PhyAndPsy.txt"};
        final int[] photo = new int[] { R.drawable.p1, R.drawable.p2, R.drawable.p3 ,R.drawable.p4,R.drawable.p5,R.drawable.p6,R.drawable.p7,R.drawable.p8};
        List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();

        Map<String, Object> map1 = new HashMap<String, Object>();
        map1.put("photo", R.drawable.p1);
        map1.put("name", name[0]);
        data.add(map1);

        Map<String, Object> map2 = new HashMap<String, Object>();
        map2.put("photo", R.drawable.p2);
        map2.put("name", name[1]);
        data.add(map2);

        Map<String, Object> map3 = new HashMap<String, Object>();
        map3.put("photo", R.drawable.p3);
        map3.put("name", name[2]);
        data.add(map3);

        Map<String, Object> map4 = new HashMap<String, Object>();
        map4.put("photo", R.drawable.p4);
        map4.put("name", name[3]);
        data.add(map4);

        Map<String, Object> map5 = new HashMap<String, Object>();
        map5.put("photo", R.drawable.p5);
        map5.put("name", name[4]);
        data.add(map5);

        Map<String, Object> map6 = new HashMap<String, Object>();
        map6.put("photo", R.drawable.p6);
        map6.put("name", name[5]);
        data.add(map6);

        Map<String, Object> map7 = new HashMap<String, Object>();
        map7.put("photo", R.drawable.p7);
        map7.put("name", name[6]);
        data.add(map7);

        Map<String, Object> map8 = new HashMap<String, Object>();
        map8.put("photo", R.drawable.p8);
        map8.put("name", name[7]);
        data.add(map8);

        Lv.setAdapter(new SimpleAdapter(this, data, R.layout.item,new String[] { "photo", "name" }, new int[] { R.id.iv,R.id.tv_name }));
        Lv.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,long arg3) {

                Bundle bundle = new Bundle();
                bundle.putInt("photo", photo[arg2]);
                bundle.putString("message", message[arg2]);
                Intent intent = new Intent();
                intent.putExtras(bundle);
                intent.setClass(SecondActivity.this, MoveList.class);
                Log.i("message", message[arg2]);
                startActivity(intent);
            }
        });

    }
}
