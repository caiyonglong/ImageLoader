package com.ckt.cyl.imageloader;

import android.graphics.Bitmap;
import android.util.LruCache;

/**
 * Created by D22434 on 2017/9/27.
 */

public class MemoryCache implements ImageCache {

    //图片缓存
    LruCache<String, Bitmap> mImageLruCache;

    public MemoryCache() {
        initImageCache();
    }

    public void initImageCache() {
        int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
        int cacheSize = maxMemory / 4;
        mImageLruCache = new LruCache<String, Bitmap>(cacheSize) {
            @Override
            protected int sizeOf(String key, Bitmap bitmap) {
                return bitmap.getRowBytes() * bitmap.getHeight() / 1024;
            }
        };
    }


    @Override
    public void put(String url, Bitmap bitmap) {
        mImageLruCache.put(url, bitmap);
    }

    @Override
    public Bitmap get(String url) {
        return mImageLruCache.get(url);
    }
}
