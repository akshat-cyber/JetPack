package com.example.jetpack;

import android.content.Context;

public class setDt {
    private int[] imageViews;
    private String[] imageNames;
    public setDt(Context context) {
        imageViews = new int[]{
                R.drawable.index, R.drawable.thumb, R.drawable.min,
           /*     R.drawable.fre, R.drawable.kati, R.drawable.pexels1,
                R.drawable.jnk */
        };
        imageNames = context.getResources().getStringArray(R.array.imageNames);
    }
    public int[] getImageViews() {
        return imageViews;
    }
    public int getImageAtPosition(int position) {
        return imageViews[position];
    }
    public String getImageNameAtPosition(int position) {
        return imageNames[position];
    }
    public String[] getImageNames() {
        return imageNames;
    }
}
