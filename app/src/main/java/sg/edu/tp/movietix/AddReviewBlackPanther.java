package sg.edu.tp.movietix;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class AddReviewBlackPanther extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_review_black_panther);
    }
    //intent and sending of review to blackpanther movie page
    public void moveToBlackPanthermovie(View view){

        EditText ratingnumber1 = (EditText) findViewById(R.id.ratingnum1);
        TextView ratingnumend1 = (TextView) findViewById(R.id.ratingnumend);
        EditText blackpanthercomment1 = (EditText) findViewById(R.id.comment1);
        TextView username1 = (TextView) findViewById(R.id.usernameid);

        Intent backReview = new Intent(this, ReviewBlackPanther.class);

        backReview.putExtra("name1", blackpanthercomment1.getText()+"");
        backReview.putExtra("name2", ratingnumber1.getText()+" "+ ratingnumend1.getText());
        backReview.putExtra("name3", username1.getText()+"");

        startActivity(backReview);
    }
}
