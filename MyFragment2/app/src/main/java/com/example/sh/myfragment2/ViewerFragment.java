package com.example.sh.myfragment2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by sh on 2019-02-11.
 */

public class ViewerFragment extends Fragment {

    ImageView imageView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_viewer,container,false);

         imageView = (ImageView) rootView.findViewById(R.id.imageView);
        

        return rootView;
    }

    public void setImage(int index)
    {
        if(index == 0)
        {
            imageView.setImageResource(R.drawable.sky1);
        }
        else if(index == 1)
        {
            imageView.setImageResource(R.drawable.sky3);
        }
        else if(index == 2)
        {
            imageView.setImageResource(R.drawable.sky4);
        }
    }
}
