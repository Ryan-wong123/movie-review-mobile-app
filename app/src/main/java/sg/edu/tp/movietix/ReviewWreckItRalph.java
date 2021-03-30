package sg.edu.tp.movietix;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Calendar;

public class ReviewWreckItRalph extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_wreck_it_ralph);

        //getting review from add review page
        TextView collectwreckreview1 = (TextView) findViewById(R.id.wreckcomment3);
        TextView collectrating3 = (TextView) findViewById(R.id.userratingwreckit2);
        TextView collectusername3 = (TextView) findViewById(R.id.addreview3);

        Intent getreview3 = getIntent();
        Bundle bd3 = getreview3.getExtras();
        if (bd3 != null)
        {
            String getnamewreck1 = (String) bd3.get("namewreck1");
            String getnamewreck2 = (String) bd3.get("namewreck2");
            String getnamewreck3 = (String) bd3.get("namewreck3");
            collectwreckreview1.setText(getnamewreck1);
            collectrating3.setText(getnamewreck2);
            collectusername3.setText(getnamewreck3);
        }

    }

    //intent to add review page
    public void moveToAddReviewWreck(View view){
        Intent intent = new Intent(this, AddReviewWreckItRalph.class);
        startActivity(intent);
    }

    //add calendar event
    public void calenderEvent2(View view) {
        Calendar calendarEvent = Calendar.getInstance();
        Intent i = new Intent(Intent.ACTION_EDIT);
        i.setType("vnd.android.cursor.item/event");
        i.putExtra("beginTime", calendarEvent.getTimeInMillis());
        i.putExtra("allDay", true);
        i.putExtra("rule", "FREQ=YEARLY");
        i.putExtra("endTime", calendarEvent.getTimeInMillis() + 60 * 60 * 1000);
        i.putExtra("title", "Wreck-It Ralph 2");
        startActivity(i);
    }

    //watch trailer
    public void watchtrailerwreck(View view){
        Intent myintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/_BcYBFC6zfY"));
        myintent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        myintent.setPackage("com.google.android.youtube");
        startActivity(myintent);
    }
}
