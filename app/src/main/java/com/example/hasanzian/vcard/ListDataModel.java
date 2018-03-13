package com.example.hasanzian.vcard;

/**
 * Created by hasanZian on 09-03-2018.
 */

public class ListDataModel {
    private String mTitle;
    private String mSubTitle;
    private int mIcon;

    public ListDataModel(String mTitle, String mSubTitle, int mIcon) {
        this.mTitle = mTitle;
        this.mSubTitle = mSubTitle;
        this.mIcon = mIcon;
    }

    public String getmTitle() {
        return mTitle;
    }

    public String getmSubTitle() {
        return mSubTitle;
    }

    public int getmIcon() {
        return mIcon;
    }
}
