package com.ckt.cyl.imageloader;

import android.graphics.Bitmap;

/**
 * Created by D22434 on 2017/9/27.
 */

public class DoubleCache implements ImageCache {

    ImageCache mMemoryCache = new MemoryCache();
    ImageCache mDiskCache = new DiskCache();

    //从缓存中获取图片
    public Bitmap get(String url) {
        Bitmap bmp = mMemoryCache.get(url);
        if (bmp == null) {
            bmp = mDiskCache.get(url);
        }
        return bmp;
    }

    //将图片缓存到内存中
    public void put(String url, Bitmap bmp) {
        mDiskCache.put(url, bmp);
        mMemoryCache.put(url, bmp);
    }
}
