package my.snacksquad.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class Mainmenu extends AppCompatActivity {

    Button signinemail, signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmenu);
        signinemail = findViewById(R.id.email);
        signup = findViewById(R.id.signup);

        signinemail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signemail = new Intent(Mainmenu.this, Login.class);
                startActivity(signemail);
                finish();
            }
        });


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signupIntent = new Intent(Mainmenu.this, signuppage.class);
                startActivity(signupIntent);
                finish();
            }
        });
    }
}
