package com.example.ud839_miwok_lesson_one;

import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.view.View;

/**
 * {@link Word} represents a vocabulary word that the user want to learn.
 * It contains default translation and miwok translation for that word.
 */

public class Word {

    /**
     * store the word miwok voice
     */

    private int mMiwokVoice;

    /**
     * To store the resouce id
     */
    private int NO_IMAGE = -1;
    private int mImageResourceId = NO_IMAGE;



    /**
     * Miwok translation for that word
     */
    private String mMiwokTranslation;

    /**
     * Default translation for that word
     */
    private String mDefaultTranslation;

    /**
     * Word 构造函数
     *
     * @param miwokTranslation is the word in the Miwok language.
     * @param defaultTranslation is the word in the local area language.
     * @param imageResourceId is the drawable resource id for the image associated the word
     */
    public Word(int imageResourceId,String defaultTranslation,String miwokTranslation, int miwokVoice) {
        mImageResourceId = imageResourceId;
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mMiwokVoice = miwokVoice;

    }

    /**
     * Word 构造函数，没有图片
     *
     * @param miwokTranslation
     * @param defaultTranslation
     */
    public Word(String defaultTranslation,String miwokTranslation,int miwokVoice) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mMiwokVoice = miwokVoice;
    }


    /**
     * Return  the image resource ID of the word
     */
    public int getImageResourceId() {
        if(mImageResourceId != 0){
            return mImageResourceId;
        }else {
            return View.GONE;
        }

    }

    /**
     * Get the default translation of the word
     */
    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    /**
     * Get the miwok translation of the word
     */
    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    /**
     * 判断是否有图片
     */
    public boolean hasImage(){
        return mImageResourceId != NO_IMAGE;
    }

    /**
     * Get the miwok translation of the word
     */
    public int getMiwokVoice() {
        return mMiwokVoice;
    }
}
