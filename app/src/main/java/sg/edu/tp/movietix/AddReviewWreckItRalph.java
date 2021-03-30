package sg.edu.tp.movietix;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class AddReviewWreckItRalph extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_review_wreck_it_ralph);
    }

    //intent and sending of review to wreckitralph movie page
    public void moveToWreckIt(View view){

        EditText ratingnumber3 = (EditText) findViewById(R.id.ratingnum3);
        TextView ratingnumend3 = (TextView) findViewById(R.id.ratingnumend3);
        EditText wreckcomment3 = (EditText) findViewById(R.id.addreviewedit2);
        TextView username3 = (TextView) findViewById(R.id.usernameid3);

        Intent intent = new Intent(this, ReviewWreckItRalph.class);

        intent.putExtra("namewreck1", wreckcomment3.getText()+"");
        intent.putExtra("namewreck2", ratingnumber3.getText()+" "+ ratingnumend3.getText());
        intent.putExtra("namewreck3", username3.getText()+"");

        startActivity(intent);
    }
}
