package com.darren.retrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.darren.view_day01.R;


public class RetrofitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);

    }

    public void getData(View view) {
        RetrofitClient.getServiceApi().userLogin("Darren", "940223")
                .enqueue(new HttpCallback<UserInfo>() {
                    @Override
                    public void onSucceed(UserInfo result) {
                        Log.e("TAG","onSucceed Thread.currentThread()=="+ Thread.currentThread());

                    }

                    @Override
                    public void onError(String code, String msg) {
                        Log.e("TAG"," onError ");

                    }
                });
    }
}
