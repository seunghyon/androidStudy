package com.example.sh.mytab;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by sh on 2019-02-11.
 */

public class Fragment3 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment3,container,false);

       return rootView;
    }
}
