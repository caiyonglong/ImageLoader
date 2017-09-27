package com.ckt.cyl.imageloader;

import android.graphics.Bitmap;

/**
 * Created by D22434 on 2017/9/27.
 */

public interface ImageCache {
    public void put(String url, Bitmap bitmap);

    public Bitmap get(String url);
}
