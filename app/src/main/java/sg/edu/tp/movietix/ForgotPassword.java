package sg.edu.tp.movietix;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class ForgotPassword extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

    }

    //check if user types in anything before intent back to login page
    public void moveToLogin(View view){

        EditText forgotpasswordtext = (EditText)findViewById(R.id.forgotEmailTxt);

        if(forgotpasswordtext.getText().toString().trim().length()==0){
            forgotpasswordtext.setError("Email invalid!");
            forgotpasswordtext.requestFocus();
        }
        else {
            Intent loginScreen = new Intent(this, LoginScreen.class);
            startActivity(loginScreen);
            Toast.makeText(getApplicationContext(),
                    "Email sent",Toast.LENGTH_SHORT).show();
        }

    }

}
