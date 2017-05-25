package com.yalin.style.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author jinyalin
 * @since 2017/5/25.
 */

public class GalleryWallpaperItem implements Parcelable {
    public long id;
    public String uri;
    public boolean isTreeUri;

    public GalleryWallpaperItem() {

    }

    protected GalleryWallpaperItem(Parcel in) {
        id = in.readLong();
        uri = in.readString();
        isTreeUri = in.readByte() != 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof GalleryWallpaperItem) {
            GalleryWallpaperItem objItem = (GalleryWallpaperItem) obj;
            return objItem.id == id;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = (int) id;
        result = 31 * result + uri.hashCode();
        return result;
    }

    public static final Creator<GalleryWallpaperItem> CREATOR = new Creator<GalleryWallpaperItem>() {
        @Override
        public GalleryWallpaperItem createFromParcel(Parcel in) {
            return new GalleryWallpaperItem(in);
        }

        @Override
        public GalleryWallpaperItem[] newArray(int size) {
            return new GalleryWallpaperItem[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(uri);
        dest.writeByte((byte) (isTreeUri ? 1 : 0));
    }
}
