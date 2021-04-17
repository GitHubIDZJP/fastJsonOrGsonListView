package com.android.thirdlibparsinglistview.PicassoFile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.android.thirdlibparsinglistview.MainActivity;
import com.android.thirdlibparsinglistview.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class PicassoActivity extends AppCompatActivity {



    String urlPicasso = "http://img1.imgtn.bdimg.com/it/u=998216620,3976144567&fm=21&gp=0.jpg";
    String urlGlide = "http://h.hiphotos.baidu.com/image/h%3D200/sign=cd65e7fa13d5ad6eb5f963eab1cb39a3/377adab44aed2e7394aa5a128f01a18b87d6fa49.jpg";
    String urlVideo = "http://www.iqiyi.com/v_19rrm83ayw.html";

    ListView mListView;
    MyAdapter mAdpater;
    List<String> mData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picasso);




        mListView = (ListView) findViewById(R.id.lv);
        for (int i = 0; i < 20; i++) {
            mData.add(urlGlide);
        }
        mAdpater = new MyAdapter();
        mListView.setAdapter(mAdpater);



    }

     class MyAdapter  extends BaseAdapter {
         @Override
         public int getCount() {
             return mData.size();
         }

         @Override
         public Object getItem(int position) {
             return mData.get(position);
         }

         @Override
         public long getItemId(int position) {
             return position;
         }

         @Override
         public View getView(int position, View convertView, ViewGroup parent) {
             ViewHolder holder = null;
             if (convertView == null) {
                 holder = new ViewHolder();
                 convertView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.activity_picasso_item, null);
                 holder.mImageView = (ImageView) convertView.findViewById(R.id.id_image);
                 convertView.setTag(holder);
             } else {
                 holder = (ViewHolder) convertView.getTag();
             }
             Picasso.with(PicassoActivity.this).load(mData.get(position)).into(holder.mImageView);
             return convertView;
         }

         class ViewHolder {
             ImageView mImageView;
         }




    }
}