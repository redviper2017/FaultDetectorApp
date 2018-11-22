package tpfd.techcom.com.faultdetectorapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText userNameEditText, userPasswordEditText;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userNameEditText = findViewById(R.id.editText_username);
        userPasswordEditText = findViewById(R.id.editText_password);
        loginButton = findViewById(R.id.button_login);

        loginButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        String userName = userNameEditText.getText().toString();
        String password = userPasswordEditText.getText().toString();

        if (TextUtils.isEmpty(userName)){
            Toast.makeText(getApplicationContext(),"username is required!",Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(password)){
            Toast.makeText(getApplicationContext(),"password is required!",Toast.LENGTH_SHORT).show();
        }
        else if (!userName.equals("admin")){
            Toast.makeText(getApplicationContext(),"username is incorrect, please check!",Toast.LENGTH_SHORT).show();
        }
        else if (!password.equals("admintpfd")){
            Toast.makeText(getApplicationContext(),"password is incorrect, please check!",Toast.LENGTH_SHORT).show();
        }
        else {
            getSharedPreferences("PREFERENCES",MODE_PRIVATE).edit().putBoolean("isFirstRun", false).apply();
            startActivity(new Intent(LoginActivity.this,HomeActivity.class));
            finish();
        }
    }
}
