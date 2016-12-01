package com.example.mike.a12345;


import android.inputmethodservice.Keyboard;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import android.widget.EditText;

import java.util.List;


public class KeyboardWidgetActivity extends AppCompatActivity {
    private CustomKeyboardView mKeyboardView;
    private EditText mTargetView;
    private Keyboard mKeyboard;
    String textContainer = "";
    int length = 0;
    int prevLength = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main);


        mKeyboard = new Keyboard(this, R.xml.keyboard);

        mTargetView = (EditText) findViewById(R.id.target);
        mTargetView.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                showKeyboardWithAnimation();
                return true;
            }
        });
    // List<Keyboard.Key> aaaa=   mKeyboard.getKeys();
      //  int a= Integer.parseInt(aaaa.get(0).toString());
        mKeyboardView = (CustomKeyboardView) findViewById(R.id.keyboard_view);
        mKeyboardView.setKeyboard(mKeyboard);
        mKeyboardView.setPreviewEnabled(false);

        mKeyboardView.setOnKeyboardActionListener(new BasicOnKeyboardActionListener(
                        this));

         //   mKeyboardView.getKeyboard();

        mTargetView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                textContainer = s.toString();
                prevLength = s.length();
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                length = s.length();
                                if(!textContainer.isEmpty()){
                                    if(s.length() > 1) {
                                        if(prevLength < length) {
                                            if (!textContainer.contains(s.toString().subSequence(length - 1, length))) {
                                                length = s.length();
                                            } else {
                                mTargetView.getText().delete(length - 1, length);
                            }
                        }
                    }
                }else{
                    textContainer = s.toString();
                }


            }
        });

    }


    private void showKeyboardWithAnimation() {
        if (mKeyboardView.getVisibility() == View.GONE) {
            Animation animation = AnimationUtils
                    .loadAnimation(KeyboardWidgetActivity.this,
                            R.anim.slide_in_bottom);
            mKeyboardView.showWithAnimation(animation);
        }
    }



    @Override
    public void onBackPressed() {
        if (mKeyboardView.isShown()) {
            mKeyboardView.setVisibility(View.GONE);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mKeyboardView.setVisibility(View.GONE);
        return    super.onTouchEvent(event);
    }
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        Log.i("key pressed", String.valueOf(event.getKeyCode()));
        return super.dispatchKeyEvent(event);
    }


}


