package com.example.elsemtim.andreyapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static android.content.Intent.EXTRA_COMPONENT_NAME;

public class CheatActivity extends AppCompatActivity {
    private static final String EXTRA_ANSWER_IS_TRUE= "com.bignerdranch.android.geoquiz.answer_is_true";
    private boolean mAnswerIsTrue;
    private TextView mAnwerTextView;
    private Button mShowButton;

    public static Intent newInent(Context packageContext,boolean answerIsTrue){
        Intent intent= new Intent(packageContext,CheatActivity.class);
        intent.putExtra(EXTRA_COMPONENT_NAME,answerIsTrue);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);
        mAnswerIsTrue = getIntent().getBooleanExtra(EXTRA_COMPONENT_NAME, false);
        mShowButton = (Button) findViewById(R.id.show_answer_button);
        mAnwerTextView = (TextView) findViewById(R.id.answer_text_view);
        mShowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mAnswerIsTrue){
                    mAnwerTextView.setText(R.string.true_button);
                }else{
                    mAnwerTextView.setText(R.string.false_button);
                }
            }
        });

    }
}
