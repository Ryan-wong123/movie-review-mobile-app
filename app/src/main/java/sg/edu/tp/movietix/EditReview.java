package sg.edu.tp.movietix;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class EditReview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_review);
    }

    public void moveToBlackPanthermovie(View view){
        Intent editReview1 = new Intent(this, AddReviewBlackPanther.class);
       startActivity(editReview1);
    }
}