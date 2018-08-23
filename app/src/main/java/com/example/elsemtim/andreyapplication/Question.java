package com.example.elsemtim.andreyapplication;

public class Question {
    private int mTextResId;
    private boolean mAnswerTrue;

    public Question(int mTextResId, boolean mAnswerTrue){
        this.mTextResId = mTextResId;
        this.mAnswerTrue = mAnswerTrue;
        //mTextResId= textResId;
        //mAnswerTrue= answerTrue;
    }
    public int getmTextResId(){
        return mTextResId;
    }
    public void setmTextResId(int textResId){
        mTextResId=textResId;
    }
    public boolean ismAnswerTrue(){
        return mAnswerTrue;
    }
    public void setmAnswerTrue(boolean answerTrue){
        mAnswerTrue = answerTrue;
    }
}
