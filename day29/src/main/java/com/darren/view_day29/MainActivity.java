package com.darren.view_day29;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // 两次打印地址会不会相等？ 1 不会2  WindowManager 不是同一个，因为会去重新创建对象  Activity -> PhoneWindow  -> WindowManager
       WindowManager wm = getWindowManager();
//       wm.addView(V);
       Log.e("TAG",wm+" ");
    }

    public void click(View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
