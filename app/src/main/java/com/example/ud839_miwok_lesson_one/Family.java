package com.example.ud839_miwok_lesson_one;

public class Family {

//    设置两个成员变量(state) 用于存储 默认翻译(mDefaultTranslation)和 miwok(mMiwokTranslation)翻译

    private String mDefaultTranslation;
    private String mMiwokTranslation;

//    构造函数 初始化成员变量mDefaultTranslation和mMiwokTranslation
    public Family(String defaultTranslation,String miwokTranslation){
        this.mDefaultTranslation = defaultTranslation;
        this.mMiwokTranslation = miwokTranslation;
    }


//    用于获取默认翻译字段值
    public String getDefaultTranslation(){
        return mDefaultTranslation;
    }

//    用于获取Miwok值
    public String getMiwokTranslation(){
        return mMiwokTranslation;
    }

}
