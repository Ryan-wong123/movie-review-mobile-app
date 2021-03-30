package sg.edu.tp.movietix;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import java.io.IOException;

public class EditProfile extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
    }

    //intent to profile page and changes the username
    public void moveToProfile(View view){
        EditText username = (EditText)findViewById(R.id.changeUsername);
        Intent profile = new Intent(this, Profile.class);
        profile.putExtra("saveusername",username.getText()+"");
        startActivity(profile);
    }


}
