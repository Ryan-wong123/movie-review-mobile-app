package sg.edu.tp.movietix;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class AddReviewAntman extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_review_antman);
    }

    //intent and sending of review to antman movie page
    public void moveToantmanmovie(View view){

        EditText ratingnumber2 = (EditText) findViewById(R.id.ratingnum2);
        TextView ratingnumend2 = (TextView) findViewById(R.id.ratingnumend2);
        EditText antmancomment2 = (EditText) findViewById(R.id.comment3);
        TextView username2 = (TextView) findViewById(R.id.usernameid2);

        Intent intent = new Intent(this, ReviewAntman.class);

        intent.putExtra("nameantman1", antmancomment2.getText()+"");
        intent.putExtra("nameantman2", ratingnumber2.getText()+" "+ ratingnumend2.getText());
        intent.putExtra("nameantman3", username2.getText()+"");

        startActivity(intent);
    }
}
