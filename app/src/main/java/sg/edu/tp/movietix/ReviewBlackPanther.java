package sg.edu.tp.movietix;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Calendar;

public class ReviewBlackPanther extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_black_panther);

        //getting review from add review page
        TextView collectblackpantherreview1 = (TextView) findViewById(R.id.blackpanthercomment3);
        TextView collectrating = (TextView) findViewById(R.id.userrating2);
        TextView collectusername = (TextView) findViewById(R.id.reviewer2);
        Intent getreview1 = getIntent();
        Bundle bd1 = getreview1.getExtras();
        if (bd1 != null)
        {
            String getname1 = (String) bd1.get("name1");
            String getname2 = (String) bd1.get("name2");
            String getname3 = (String) bd1.get("name3");
            collectblackpantherreview1.setText(getname1);
            collectrating.setText(getname2);
            collectusername.setText(getname3);
        }
    }

    //intent to add review page
    public void moveToAddReview(View view){
        Intent addReview1 = new Intent(this, AddReviewBlackPanther.class);
        startActivity(addReview1);
    }
     //add calendar event
    public void calenderEvent1(View view) {
        Calendar calendarEvent = Calendar.getInstance();
        Intent i = new Intent(Intent.ACTION_EDIT);
        i.setType("vnd.android.cursor.item/event");
        i.putExtra("beginTime", calendarEvent.getTimeInMillis());
        i.putExtra("allDay", true);
        i.putExtra("rule", "FREQ=YEARLY");
        i.putExtra("endTime", calendarEvent.getTimeInMillis() + 60 * 60 * 1000);
        i.putExtra("title", "Black Panther");
        startActivity(i);
    }

    //watch trailer
    public void watchtrailerblackpanther(View view){
        Intent myintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/xjDjIWPwcPU"));
        myintent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        myintent.setPackage("com.google.android.youtube");
        startActivity(myintent);
    }

}
