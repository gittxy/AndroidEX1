package com.example.e_learning_1;


import android.app.Activity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MoveList extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.model);

        Bundle bundle=getIntent().getExtras();
        int id=bundle.getInt("photo");
        String message=bundle.getString("message");
        ImageView Iv=(ImageView) findViewById(R.id.Iv);
        Iv.setImageResource(id);

        try {
            InputStream is = getAssets().open(message);
            String text = readTextFromSDcard(is);
            TextView tv=(TextView) findViewById(R.id.tv_message);
            tv.setMovementMethod(ScrollingMovementMethod.getInstance());
            tv.setText(text);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    private String readTextFromSDcard(InputStream is) throws Exception {
        InputStreamReader reader = new InputStreamReader(is,"GB2312");
        BufferedReader bufferedReader = new BufferedReader(reader);
        StringBuffer buffer = new StringBuffer("");
        String str;
        while ((str = bufferedReader.readLine()) != null) {
            String temp = new String(str.getBytes(),"utf-8");
            buffer.append(temp);
            buffer.append("\n");
        }
        return buffer.toString();
    }

}
