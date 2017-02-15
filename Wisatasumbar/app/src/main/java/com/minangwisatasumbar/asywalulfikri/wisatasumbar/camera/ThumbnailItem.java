package com.minangwisatasumbar.asywalulfikri.wisatasumbar.camera;

import android.graphics.Bitmap;

import com.zomato.photofilters.imageprocessors.Filter;

/**
 * Created by asywalulfikri on 9/26/16.
 */

public class ThumbnailItem {

    public Bitmap image;
    public Filter filter;

    public ThumbnailItem() {
        image = null;
        filter = new Filter();
    }
}
