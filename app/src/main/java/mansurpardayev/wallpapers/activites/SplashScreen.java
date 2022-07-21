package mansurpardayev.wallpapers.activites;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.google.android.material.imageview.ShapeableImageView;

import mansurpardayev.wallpapers.R;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.logo_anim);
        ShapeableImageView logo = findViewById(R.id.logoInSplash);
        logo.setAnimation(animation);

        int duration = 3000;
        int sdkVersion = android.os.Build.VERSION.SDK_INT;
        if (sdkVersion == 13) duration = 0;

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashScreen.this, MainActivity.class));
            }
        }, duration);

    }
}