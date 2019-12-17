package com.example.mylist;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by sh on 2019-01-30.
 */

public class SingerItemView extends LinearLayout {

    TextView textView;
    TextView textView2;
    ImageView imageView;

    public SingerItemView(Context context) {
        super(context);
        init(context);
    }

    public SingerItemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private  void init(Context context)
    {
       LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
       inflater.inflate(R.layout.singer_item,this,true);

       textView = (TextView)findViewById(R.id.textView);
       textView2 = (TextView)findViewById(R.id.textView2);
       imageView = (ImageView)findViewById(R.id.imageView);

    }

    public void setName(String name )
    {
        textView.setText(name);
    }

    public void setMobile(String mobile)
    {
        textView2.setText(mobile);
    }

    public void setImage(int resID)
    {
        imageView.setImageResource(resID);
    }
}
