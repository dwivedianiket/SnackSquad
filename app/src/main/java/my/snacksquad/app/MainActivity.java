package my.snacksquad.app;


import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.firebase.auth.FirebaseAuth;
public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    TextView textView;
    TextView textView2;
    TextView textView4;
    FirebaseAuth Fauth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.image_view);
        textView = findViewById(R.id.text_view);
        textView4 = findViewById(R.id.textView4);
        textView2 = findViewById(R.id.textView2);
        imageView.animate().alpha(0f).setDuration(0);
        textView.animate().alpha(0f).setDuration(0);
        textView2.animate().alpha(0f).setDuration(0);
        textView4.animate().alpha(0f).setDuration(0);
        imageView.animate().alpha(1f).setDuration(1000).setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                textView.animate().alpha(1f).setDuration(800);
                textView2.animate().alpha(1f).setDuration(800);
                textView4.animate().alpha(1f).setDuration(800);
            }
        });

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Fauth = FirebaseAuth.getInstance();
                if (Fauth.getCurrentUser() != null) {
                    if (Fauth.getCurrentUser().isEmailVerified()) {
                        startActivity(new Intent(MainActivity.this, FoodPanel.class));
                        finish();
                    } else {
                        Intent intent = new Intent(MainActivity.this, Mainmenu.class);
                        startActivity(intent);
                        finish();
                    }
                } else {
                    Intent intent = new Intent(MainActivity.this, Mainmenu.class);
                    startActivity(intent);
                    finish();
                }
            }
        }, 3000);
    }
}
