package com.example.kotchaphan.retrofit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by Kotchaphan on 4/9/2558.
 */
public class GridAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mInflater;
    private ShotList mShots;

    public GridAdapter(Context mContext, ShotList mShots) {
        this.mContext = mContext;
        this.mShots = mShots;
        this.mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;

        if (convertView == null) {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, 200));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setPadding(4, 4, 4, 4);
        } else {
            imageView = (ImageView) convertView;
        }

        Picasso.with(mContext)
                .load(mShots.getShots().get(position).getImageUrl())
                .into(imageView);

        return imageView;
    }

    @Override
    public int getCount() {
        return mShots.getShots().size();
    }
}
