package com.example.ud839_miwok_lesson_one;

/**
 * {@link Word} represents a vocabulary word that the user want to learn.
 * It contains default translation and miwok translation for that word.
 */

public class Word {
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
     * @param miwokTranslation
     * @param defaultTranslation
     */
    public Word(String defaultTranslation,String miwokTranslation) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
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


}
