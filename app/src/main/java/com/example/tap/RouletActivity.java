package com.example.tap;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class RouletActivity extends AppCompatActivity {
    private CircleManager circleManager;
    private RelativeLayout layoutRoulette;
    private int num_roulette;
    private ArrayList<String> MENU;

    private Button btnRotate;
 //   private TextView tvResult;

    private float initAngle = 0.0f;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.roulettet_layout);
   //     tvResult = findViewById(R.id.tvResult);
        btnRotate = findViewById(R.id.btnRotate);
        layoutRoulette = findViewById(R.id.layoutRoulette);

        Intent intent = getIntent();
        MENU = (ArrayList<String>) intent.getStringArrayListExtra("menu_items");
        num_roulette=MENU.size();
        circleManager=new CircleManager(RouletActivity.this,num_roulette);
        layoutRoulette.addView(circleManager);

        btnRotate.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {


                rotateLayout(layoutRoulette,num_roulette);
            }
        });


    }
    public void rotateLayout(final RelativeLayout layout, final int num) {
        initAngle=0.0f;
        final float fromAngle = getRandom(360) + 3600 + initAngle;

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                getResult(fromAngle, num); // start when animation complete
            }
        }, 3000);

        RotateAnimation rotateAnimation = new RotateAnimation(initAngle, fromAngle,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);

        rotateAnimation.setInterpolator(AnimationUtils.loadInterpolator(this, android.R.anim.accelerate_decelerate_interpolator));
        rotateAnimation.setDuration(3000);
        rotateAnimation.setFillEnabled(true);
        rotateAnimation.setFillAfter(true);
        layout.startAnimation(rotateAnimation);
    }

    private void getResult(float angle, int num_roulette) {
        String text = "";
        angle = angle % 360;

        Log.d("roulette", "getResult : " + angle);

        //num_roulette. 랜덤으로 주어지는 angle에 따른 결과 text.

    if (num_roulette==2){
        if (angle>90 && angle<270) text=MENU.get(0);
        else text=MENU.get(1);
    }
    else if (num_roulette==3){
        if (angle>=30 && angle<150) text=MENU.get(1);
        else if (angle>=150 && angle<270) text=MENU.get(0);
        else text=MENU.get(2);
    }
        else if (num_roulette==4){
            if (angle>90 && angle<=180){
                text=MENU.get(1);
            } else if (angle>180 && angle<=270){
                text=MENU.get(0);
            } else if (angle>270 && angle<=360){
                text=MENU.get(3);
            } else if (angle>0 && angle<=90){
                text=MENU.get(2);
            }
        }
        else if (num_roulette == 5) {
            if (angle > 342 || angle <= 54) { // 11   2
                text =MENU.get(3);
            } else if (angle > 54 && angle <= 126) { // 333   3
                text = MENU.get(2);
            } else if (angle > 126 && angle <= 198) { // 222   4
                text = MENU.get(1);
            } else if (angle > 198 && angle <= 270) { // 111    0
                text = MENU.get(0);
            } else if (angle > 270 && angle <= 342) { // 22     1
                text = MENU.get(4);
            }
        }
        else if (num_roulette == 6) {
            if (angle > 330 || angle <= 30) { // 22
                text =MENU.get(4);
            } else if (angle > 30 && angle <= 90) { // 11
                text = MENU.get(3);
            } else if (angle > 90 && angle <= 150) { // 333
                text = MENU.get(2);
            } else if (angle > 150 && angle <= 210) { // 222
                text = MENU.get(1);
            } else if (angle > 210 && angle <= 270) { // 111
                text = MENU.get(0);
            } else if (angle > 270 && angle <= 330) { // 3
                text = MENU.get(5);
            }
        }
    else if (num_roulette == 7) {
        if (angle<=270 && angle>219) text=MENU.get(0);
        else if (angle<=219 && angle>168) text=MENU.get(1);
        else if (angle<=168 && angle>117) text=MENU.get(2);
        else if (angle<=117 && angle>66) text=MENU.get(3);
        else if (angle<=66 && angle>15) text=MENU.get(4);
        else if (angle<=15 || angle>324) text=MENU.get(5);
        else if (angle>273 && angle<=324) text=MENU.get(6);
        else text=MENU.get(6);
    }
    else if (num_roulette == 8) {
        if (angle>=0 && angle<45) text=MENU.get(5);
        else if (angle>=45 && angle<90) text=MENU.get(4);
        else if (angle>=90 && angle<135) text=MENU.get(3);
        else if (angle>=135 && angle<180) text=MENU.get(2);
        else if (angle>=180 && angle<225) text=MENU.get(1);
        else if (angle>=225 && angle<270) text=MENU.get(0);
        else if (angle>=270 && angle<315) text=MENU.get(7);
        else if (angle>=315 && angle<360) text=MENU.get(6);
    }
    else if (num_roulette == 9) {
        if (angle>=30 && angle<70) text=MENU.get(5);
        else if (angle>=70 && angle<110) text=MENU.get(4);
        else if (angle>=110 && angle<150) text=MENU.get(3);
        else if (angle>=150 && angle<190) text=MENU.get(2);
        else if (angle>=190 && angle<230) text=MENU.get(1);
        else if (angle>=230 && angle<270) text=MENU.get(0);
        else if (angle>=270 && angle<310) text=MENU.get(8);
        else if (angle>=310 && angle<350) text=MENU.get(7);
        else if (angle>=350 || angle<30) text=MENU.get(6);
    }
    else if (num_roulette == 10) {
        if (angle>=54 && angle<90) text=MENU.get(5);
        else if (angle>=90 && angle<126) text=MENU.get(4);
        else if (angle>=126 && angle<162) text=MENU.get(3);
        else if (angle>=162 && angle<198) text=MENU.get(2);
        else if (angle>=198 && angle<234) text=MENU.get(1);
        else if (angle>=234 && angle<270) text=MENU.get(0);
        else if (angle>=270 && angle<306) text=MENU.get(9);
        else if (angle>=306 && angle<342) text=MENU.get(8);
        else if (angle>=342 || angle<18) text=MENU.get(7);
        else if (angle>=18 && angle<54) text=MENU.get(6);
    }
        buildAlert(text);
  //      tvResult.setText("Result : " + text);
    }

    // get Angle to random
    private int getRandom(int maxNumber) {
        double r = Math.random();
        return (int)(r * maxNumber);
    }
    // if you want use AlertDialog then use this
    private void buildAlert(final String text) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("반박시 딱밤")
                .setMessage( text + " (으)로 주변 검색")
                .setPositiveButton("OK", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //layoutRoulette.setRotation(360 - initAngle);
                        Intent intent = new Intent(getApplicationContext(), KakaoMapActivity.class);
                        intent.putExtra("menu",text);
                        startActivity(intent);
                    }
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
    public class CircleManager extends View {
        private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        private Typeface tf;


        private int[] COLORS = {Color.rgb(255, 135, 135),
                Color.rgb(255,255,102),
              Color.rgb(255,204,204),
              Color.rgb(204,255,051),
              Color.rgb(255,99,071),
              Color.rgb(153,153,255),
              Color.rgb(255,105,180),
              Color.rgb(255,204,000),
              Color.rgb(153,255,255),
              Color.rgb(255,153,051),
              Color.rgb(000,102,255)
      };
        private int num;

        public CircleManager(Context context, int num) {
            super(context);
            this.num = num;
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);


            int width = layoutRoulette.getWidth();
            int height = layoutRoulette.getHeight();
            int sweepAngle = 360 / num;

            RectF rectF = new RectF(0, 0, width, height);
            Rect rect = new Rect(0, 0, width, height);

            int centerX = (rect.left + rect.right) / 2;
            int centerY = (rect.top + rect.bottom) / 2;
            int radius = (rect.right - rect.left) / 2;

            int temp = 0;

            for (int i = 0; i < num; i++) {
                paint.setColor(COLORS[i]);
                paint.setStyle(Paint.Style.FILL_AND_STROKE);
                paint.setAntiAlias(true);
                paint.setTextAlign(Paint.Align.CENTER);
          //      tf=Typeface.createFromAsset(getAssets(),"hanna.ttf");
                canvas.drawArc(rectF, temp, sweepAngle, true, paint);

                float medianAngle = (temp + (sweepAngle / 2f)) * (float) Math.PI / 180f;

                paint.setColor(Color.BLACK);
                paint.setTextSize(50);
                paint.setStyle(Paint.Style.FILL_AND_STROKE);

                float arcCenterX = (float) (centerX + (radius * Math.cos(medianAngle))); // Arc's center X
                float arcCenterY = (float) (centerY + (radius * Math.sin(medianAngle))); // Arc's center Y

                // put text at middle of Arc's center point and Circle's center point
                float textX = (centerX + arcCenterX) / 2;
                float textY = (centerY + arcCenterY) / 2;

         //       paint.setTypeface(tf);
                canvas.drawText(MENU.get(i), textX, textY, paint);
                temp += sweepAngle;
            }
            if (num==7){
                paint.setColor(COLORS[6]);
                canvas.drawArc(rectF, temp, 3, true, paint);
            }
        }
    }
}
