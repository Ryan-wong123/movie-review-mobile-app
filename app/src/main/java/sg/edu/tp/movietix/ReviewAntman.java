package sg.edu.tp.movietix;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.util.Calendar;

public class ReviewAntman extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_antman);

        //getting review from add review page
        TextView collectantmanreview1 = (TextView) findViewById(R.id.antmancomment3);
        TextView collectrating2 = (TextView) findViewById(R.id.userratingantman2);
        TextView collectusername2 = (TextView) findViewById(R.id.addreview2);
        Intent getreview2 = getIntent();
        Bundle bd2 = getreview2.getExtras();
        if (bd2 != null)
        {
            String getnameantman1 = (String) bd2.get("nameantman1");
            String getnameantman2 = (String) bd2.get("nameantman2");
            String getnameantman3 = (String) bd2.get("nameantman3");
            collectantmanreview1.setText(getnameantman1);
            collectrating2.setText(getnameantman2);
            collectusername2.setText(getnameantman3);
        }
    }

    //intent to add review page
    public void moveToAddReviewAntman(View view){
        Intent intent = new Intent(this, AddReviewAntman.class);
        startActivity(intent);
    }

    //add calendar event
    public void calenderEvent3(View view) {
        Calendar calendarEvent = Calendar.getInstance();
        Intent i = new Intent(Intent.ACTION_EDIT);
        i.setType("vnd.android.cursor.item/event");
        i.putExtra("beginTime", calendarEvent.getTimeInMillis());
        i.putExtra("allDay", true);
        i.putExtra("rule", "FREQ=YEARLY");
        i.putExtra("endTime", calendarEvent.getTimeInMillis() + 60 * 60 * 1000);
        i.putExtra("title", "Ant man 2");
        startActivity(i);
    }

    //watch trailer
    public void watchtrailerantman(View view){
        Intent myintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/8_rTIAOohas"));
        myintent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        myintent.setPackage("com.google.android.youtube");
        startActivity(myintent);
    }
}
