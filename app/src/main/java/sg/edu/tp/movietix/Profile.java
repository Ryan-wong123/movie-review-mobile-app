package sg.edu.tp.movietix;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Profile extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        TextView user = (TextView)findViewById(R.id.username);
        Intent getusername = getIntent();
        Bundle bduser = getusername.getExtras();
        if (bduser != null)
        {
            String getuser = (String) bduser.get("saveusername");
            user.setText(getuser);
        }

    }

    //intent to editreview page
    public void moveToMyReviews(View view){
        Intent myReviews = new Intent(this, EditReview.class);
        startActivity(myReviews);
    }

    //intent to editprofile page
    public  void moveToEditProfile(View view){
        Intent editProfile = new Intent(this, EditProfile.class);
        startActivity(editProfile);
    }

    //intent to login page to logout of account
    public void moveToLogin (View view){
        Intent login = new Intent(this, LoginScreen.class);
        startActivity(login);
    }

    //intent to home page
    public void movebacktohome(View view){
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }

    //intent to soundtrack page
    public void moveToSoundTrack(View view){
        Intent intent = new Intent(this, SoundTrackMenu.class);
        startActivity(intent);
    }
}
