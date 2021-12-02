package com.example.ud839_miwok_lesson_one;

public class Phrases {

    private String mDefaultTranslation;
    private String mMiwokTranslation;

//    构造函数
    public Phrases(String defaultTranslation, String miwokTranslation) {
        this.mDefaultTranslation = defaultTranslation;
        this.mMiwokTranslation = miwokTranslation;
    }

    //    获取mDefaultTranslation 当前状态
    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    //    获取mMiwoktTranslation 当前状态
    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }
}
