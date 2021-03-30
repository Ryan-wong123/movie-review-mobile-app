package sg.edu.tp.movietix;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginScreen extends AppCompatActivity {

    EditText usernametxt,passwordtxt;
    Button loginbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        usernametxt=(EditText)findViewById(R.id.usernametxt);
        passwordtxt=(EditText)findViewById(R.id.passwordtxt);
        loginbtn=(Button)findViewById(R.id.loginbtn);

        //checking if user entered username and password correctly in order to intent to home page
        loginbtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                if(usernametxt.getText().toString().trim().length()==0){
                    usernametxt.setError("Username is not entered");
                    usernametxt.requestFocus();
                }
                if(passwordtxt.getText().toString().trim().length()==0){
                    passwordtxt.setError("Password is not entered");
                    passwordtxt.requestFocus();
                }

                if(usernametxt.getText().toString().equals("ryan") &&
                        passwordtxt.getText().toString().equals("wong")) {
                    Intent it=new Intent(getApplicationContext(), Home.class);
                    startActivity(it);
                }
                else{
                    Toast.makeText(getApplicationContext(),
                            "Invalid UserName or Password",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    //intent to home page
    public void moveToHome(View view){
        Intent home = new Intent(this, Home.class);
        startActivity(home);

    }

    //intent to forgot password page
    public void moveToForgotPassword(View view){
        Intent forgotpassword = new Intent(this, ForgotPassword.class);
        startActivity(forgotpassword);
    }

    //intent to signup page
    public void moveToSignUp(View view){
        Intent signUp = new Intent(this, signup.class);
        startActivity(signUp);
    }
}


