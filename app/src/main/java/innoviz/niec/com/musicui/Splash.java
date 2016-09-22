package innoviz.niec.com.musicui;

import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.Toast;

import innoviz.niec.com.musicui.graphics.Anim;

public class Splash extends AppCompatActivity {


    private LinearLayout mLinearLayout;
    private Animation anim;

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        super.onTouchEvent(event);
        mLinearLayout.startAnimation(anim);
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        mLinearLayout = new LinearLayout(this);
        Anim mSplash = new Anim(this);
        mLinearLayout.setBackgroundColor(Color.DKGRAY);


       // LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        setContentView(mLinearLayout);

        mLinearLayout.addView(mSplash);
        final int a=  mSplash.getHeight();
        anim = AnimationUtils.loadAnimation(this, R.anim.fade_in);

        anim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    mLinearLayout.setElevation(5);
                }
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    mLinearLayout.setElevation(0);
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mLinearLayout.setElevation(50);
            mLinearLayout.setAlpha(1);

        }
        mSplash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Splash.this,""+a,Toast.LENGTH_SHORT).show();
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Intent i = new Intent(Splash.this, MainActivity.class);


                    String tranName = getString(R.string.activity_transition);
                    v.setTransitionName(tranName);
                    ActivityOptions ac = null;
                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                        ac = ActivityOptions.makeClipRevealAnimation(v, 0, 0, 100, 200);
                    }
                    startActivity(i, ac.toBundle());
                }

            }
        });
    }
}
