package com.example.elsemtim.andreyapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button mTrueButton;
    private Button mFalseButton;
    private Button mNextButton;
    private Button mBackButton;
    private Button mCheatButton;
    private static final String TAG = "QuizActivity";
    private  static final String KEY_INDEX ="index";
    private TextView mQuestionTextView;
    private Question[] mQuestionBank = new Question[]{
            new Question(R.string.question_1, true),
            new Question(R.string.question_2, false),
            new Question(R.string.question_3, true),
            new Question(R.string.question_4, false),
    };
    private int mCurrentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate(Bundle) called");
        setContentView(R.layout.activity_main);
        if (savedInstanceState !=null){
            mCurrentIndex= savedInstanceState.getInt(KEY_INDEX,0);
        }
        mQuestionTextView = (TextView) findViewById(R.id.question_view);
        mNextButton = (Button) findViewById(R.id.button_next);
        mCheatButton=(Button) findViewById(R.id.button_cheat);
        mCheatButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void  onClick(View v){
                //Intent intent = new Intent(MainActivity.this, CheatActivity.class);
                boolean answerIsTrue = mQuestionBank[mCurrentIndex].ismAnswerTrue();
                Intent intent =CheatActivity.newInent(MainActivity.this, answerIsTrue);
                startActivity(intent);
            }
            });
        mBackButton = (Button) findViewById(R.id.button_before);
        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((mCurrentIndex==-1)||(mCurrentIndex==0)){
                    mCurrentIndex= mQuestionBank.length -1;
                    updateQuestion();
                } else{
                    mCurrentIndex = (mCurrentIndex - 1) % mQuestionBank.length;
                    updateQuestion();
                }
            }
        });
        int question = mQuestionBank[mCurrentIndex].getmTextResId();
        mQuestionTextView.setText(question);
        mQuestionTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                updateQuestion();
            }
        });
        mTrueButton = (Button) findViewById(R.id.button_true);
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast toast = Toast.makeText(MainActivity.this,R.string.correct_toast,Toast.LENGTH_SHORT);
                //toast.setGravity(Gravity.TOP, 0, 0);
                //toast.show();
                checkAnswer(true);

            }
        });
        mFalseButton = (Button) findViewById(R.id.button_false);
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //  Toast toast= Toast.makeText(MainActivity.this,R.string.incorrect_toast,Toast.LENGTH_SHORT);
                // toast.setGravity(Gravity.TOP, 0, 0);
                //  toast.show();
                checkAnswer(false);

            }
        });

        mNextButton = (Button) findViewById(R.id.button_next);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;;

                // int question =mQuestionBank[mCurrentIndex].getmTextResId();
                // mQuestionTextView.setText(question);
                updateQuestion();
            }
        });
        updateQuestion();

    }
    @Override
    public void onStart(){
        super.onStart();
        Log.d(TAG, "omStart() called");
    }
    @Override
    public void onResume(){
        super.onResume();
        Log.d(TAG, "omResume() called");
    }
    @Override
    public void onPause(){
        super.onPause();
        Log.d(TAG, "omPause() called");
    }
    @Override
    public void onStop(){
        super.onStop();
        Log.d(TAG, "omStop() called");}
    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d(TAG, "omDestroy() called");}
        @Override
        public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG, "onSaveInstanceState");
        savedInstanceState.putInt(KEY_INDEX, mCurrentIndex);
        }



    private void updateQuestion() {
        int question = mQuestionBank[mCurrentIndex].getmTextResId();
        mQuestionTextView.setText(question);
    }

    private void checkAnswer(boolean userPresdTrue) {
        boolean answerIsTrue = mQuestionBank[mCurrentIndex].ismAnswerTrue();
        int messageResId = 0;
        if (userPresdTrue == answerIsTrue) {
            messageResId = R.string.correct_toast;
        } else {
            messageResId = R.string.incorrect_toast;
        }
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show();
    }
}
