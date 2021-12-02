package com.example.ud839_miwok_lesson_one;

public class Colors {

    private String mDefaultTranslation;
    private String mMiwokTranslation;

    public Colors(String defaultTranslation,String miwokTranslation){
        this.mDefaultTranslation = defaultTranslation;
        this.mMiwokTranslation = miwokTranslation;
    }

    public String getDefaultTranslation(){
        return mDefaultTranslation;
    }

    public String getMiwokTranslation(){
        return mMiwokTranslation;
    }

}
