package com.example.mike.a12345;

/**
 * Created by Mike on 10/3/2016.
 */
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.NinePatchDrawable;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

import java.util.List;

public class CustomKeyboardView extends KeyboardView {



    public CustomKeyboardView(Context context, AttributeSet attrs) {

        super(context, attrs);

    }

    public void showWithAnimation(Animation animation) {
        animation.setAnimationListener(new AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onAnimationEnd(Animation animation) {

                setVisibility(View.VISIBLE);
            }
        });

        startAnimation(animation);
    }

   /* @Override
    public void onDraw(Canvas canvas) {


        super.onDraw(canvas);

        Paint paint = new Paint();
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setTextSize(25);
        paint.setColor(Color.RED);}


       List<Keyboard.Key> keys = getKeyboard().getKeys();
        for (Keyboard.Key key : keys) {

            if (key.pressed) {
                NinePatchDrawable npd = (NinePatchDrawable) context.getResources().getDrawable(R.drawable.red);
                npd.setBounds(key.x, key.y, key.x + key.width, key.y + key.height);
                npd.draw(canvas);
                if (key.label != null)
                    canvas.drawText(key.label.toString(), key.x + (key.width / 2), key.y + 25, paint);
            } else if (key.modifier) {  // boolean that defines key is function key

                NinePatchDrawable npd = (NinePatchDrawable) context.getResources().getDrawable(R.drawable.download);
                npd.setBounds(key.x, key.y, key.x + key.width, key.y + key.height);
                npd.draw(canvas);
                if (key.label != null)
                    canvas.drawText(key.label.toString(), key.x + (key.width / 2), key.y + 25, paint);
            }


            break;
        }*/
    }





