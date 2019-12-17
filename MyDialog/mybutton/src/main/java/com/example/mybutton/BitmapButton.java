package com.example.mybutton;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by sh on 2019-01-29.
 */

public class BitmapButton extends AppCompatButton {
    public BitmapButton(Context context) {
        super(context);

        init(context);

    }

    public BitmapButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context conText)
    {
        setBackgroundResource(R.drawable.title_bitmap_button_normal);

        setTextSize(getResources().getDimension(R.dimen.text_size));

        setTextColor(Color.WHITE);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();

        switch (action)
        {
            case MotionEvent.ACTION_DOWN:
                setBackgroundResource(R.drawable.title_bitmap_button_clicked);
                break;
            case MotionEvent.ACTION_UP:
                setBackgroundResource(R.drawable.title_bitmap_button_normal);
                break;
        }

        invalidate();

        return true;
    }
}
