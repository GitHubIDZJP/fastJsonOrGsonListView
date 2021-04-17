package com.android.thirdlibparsinglistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.thirdlibparsinglistview.PicassoFile.PicassoActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

      //baseadapter适配器
public class JsonBaseAdapter extends BaseAdapter {
        private LayoutInflater mLayoutInflater;
        private Context mContext;
        private ArrayList<UserBean> arrayList=new ArrayList<UserBean>();
        public JsonBaseAdapter(Context context) {
            mContext=context;
            mLayoutInflater=LayoutInflater.from(context);
        }
        public void setdata(ArrayList<UserBean> list){
            arrayList=list;
            notifyDataSetChanged();
        }
        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public Object getItem(int i) {
            return i;
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            Viewhode viewhode=null;
            if (view==null){
                viewhode=new Viewhode();
                view=mLayoutInflater.inflate(R.layout.item,null);
                viewhode.picUrl=(ImageView)view.findViewById(R.id.picUrlimg);
                viewhode.name=(TextView)view.findViewById(R.id.nametext);
                viewhode.couponType=(ImageView)view.findViewById(R.id.juanimg);
                viewhode.cardType=(ImageView)view.findViewById(R.id.kaimg);
                viewhode.groupType=(ImageView)view.findViewById(R.id.tuanimg);
                viewhode.coupon=(TextView)view.findViewById(R.id.coupontext);
                viewhode.location=(TextView)view.findViewById(R.id.locationtext);
                viewhode.distance=(TextView)view.findViewById(R.id.distancetext);
                view.setTag(viewhode);
            }else {
                viewhode=(Viewhode)view.getTag();
            }

            viewhode.name.setText(arrayList.get(i).getName());
            viewhode.coupon.setText(arrayList.get(i).getCoupon());
            viewhode.location.setText(arrayList.get(i).getLocation());
            viewhode.distance.setText(arrayList.get(i).getDistance());

            viewhode.cardType.setImageResource(arrayList.get(i).getCardType());
            viewhode.groupType.setImageResource(arrayList.get(i).getGroupType());
            viewhode.couponType.setImageResource(arrayList.get(i).getCouponType());

           // Picasso.with(Context).load(mData.get(position)).into(holder.mImageView);

            return view;
        }
        public class Viewhode{
            ImageView picUrl=null;
            TextView name=null;
            ImageView couponType=null;
            ImageView cardType=null;
            ImageView groupType=null;
            TextView coupon=null;
            TextView location=null;
            TextView distance=null;
        }

    }


