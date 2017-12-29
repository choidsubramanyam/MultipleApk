package com.example.subramanyam.multipleapk;

import android.graphics.drawable.Drawable;
import android.support.graphics.drawable.Animatable2Compat;
import android.support.graphics.drawable.AnimatedVectorDrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class PhoneActivity extends AppCompatActivity {

    ImageView imageView;
    private boolean done;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);
        imageView=findViewById(R.id.imageView);
        findViewById(R.id.textView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                done=!done;
                final AnimatedVectorDrawableCompat animatedVectorDrawableCompat= (AnimatedVectorDrawableCompat) imageView.getDrawable();
                animatedVectorDrawableCompat.registerAnimationCallback(new Animatable2Compat.AnimationCallback() {
                    @Override
                    public void onAnimationEnd(Drawable drawable) {
                        animatedVectorDrawableCompat.clearAnimationCallbacks();
                        imageView.setImageResource(done?R.drawable.cross :R.drawable.ctot);
                    }
                });
                animatedVectorDrawableCompat.start();

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
       // imageView.setImageResource(R.drawable.cross);
    }
}
