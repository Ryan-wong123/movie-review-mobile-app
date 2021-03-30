package sg.edu.tp.movietix;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class signup extends AppCompatActivity {
    ImageButton ssignupbtn;
    EditText signnameTxt,signPasstxt,signRePassTxt,signEmailTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        //initializzation of signup text and button
        signnameTxt=(EditText)findViewById(R.id.signnameTxt);
        signPasstxt=(EditText)findViewById(R.id.signPasstxt);
        signRePassTxt=(EditText)findViewById(R.id.signRePassTxt);
        signEmailTxt=(EditText)findViewById(R.id.signEmailTxt);
        ssignupbtn=(ImageButton)findViewById(R.id.ssignupbtn);

        //checking if all the fields contains letter so that user can signup
        ssignupbtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {


                if(signnameTxt.getText().toString().length()==0){
                    signnameTxt.setError("Username is Required");
                    signnameTxt.requestFocus();
                }
                if(signEmailTxt.getText().toString().length()==0){
                    signEmailTxt.setError("Email is Required");
                    signEmailTxt.requestFocus();
                }
                if(signPasstxt.getText().toString().length()==0){
                    signPasstxt.setError("Password not entered");
                    signPasstxt.requestFocus();
                }
                if(signRePassTxt.getText().toString().length()==0){
                    signRePassTxt.setError("Please confirm password");
                    signRePassTxt.requestFocus();
                }
                if(!signPasstxt.getText().toString().equals( signRePassTxt.getText().toString())){
                    signRePassTxt.setError("Password Not matched");
                    signRePassTxt.requestFocus();
                }
                if(signPasstxt.getText().toString().length()<8){
                        signPasstxt.setError("Password should be atleast of 8 charactors");
                        signPasstxt.requestFocus();
                }
                else {
                    Intent it=new Intent(getApplicationContext(), Home.class);
                    startActivity(it);
                }
            }
        });
    }

    //intent to login page
    public void moveToLogin (View view){
        Intent LoginScreen = new Intent(this, LoginScreen.class);
        startActivity(LoginScreen);
    }
}
