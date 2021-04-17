package com.android.thirdlibparsinglistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.ListView;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private JsonBaseAdapter jsonBaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE); //设置win没有标题
        setContentView(R.layout.activity_main);


        //


        listView=(ListView)findViewById(R.id.onelist);
        jsonBaseAdapter=new JsonBaseAdapter(MainActivity.this);
        listView.setAdapter(jsonBaseAdapter);

        new AsyncTask<String,Void,ArrayList<UserBean>>() {
            private String url = "http://10.0.2.2/listViewJsonApi.json";
            URL url1 = null;
            InputStream is = null;
            StringBuffer sb = new StringBuffer();
            BufferedReader br = null;

            @Override
            protected ArrayList<UserBean> doInBackground(String... strings) {
                try {
                    url1 = new URL(url);
                    is = url1.openStream();
                    br = new BufferedReader(new InputStreamReader(is));

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                String line = null;
                try {
                    while ((line = br.readLine()) != null) {
                        sb.append(line);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Gson gson = new Gson();
                Log.e("sb", sb.toString());
                JsonInfo jsonInfo = gson.fromJson(sb.toString(), JsonInfo.class);
                PageinfoMer pageinfoMer = jsonInfo.getInfo();
                ArrayList<UserBean> list = new ArrayList<UserBean>();

                for (Contents c : pageinfoMer.getMerchantKey()) {
                    UserBean u = new UserBean();
                    u.setName(c.getName());
                    u.setCoupon(c.getCoupon());
                    u.setDistance(c.getDistance());
                    u.setLocation(c.getLocation());
                    u.setPicUrl(c.getPicUrl());
                    if (c.getCardType().equals("YES")) {
                        u.setCardType(R.drawable.near_card);
                    }
                    if (c.getCouponType().equals("YES")) {
                        u.setCouponType(R.drawable.near_ticket);
                    }
                    if (c.getGroupType().equals("YES")) {
                        u.setGroupType(R.drawable.near_group);
                    }

                    list.add(u);

                }

                return list;
            }

            @Override
            protected void onPostExecute(ArrayList<UserBean> list) {
                jsonBaseAdapter.setdata(list);
            }
                }.execute();

    }
}