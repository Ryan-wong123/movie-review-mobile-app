package sg.edu.tp.movietix;

        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.widget.ImageView;
        import android.widget.ViewFlipper;

public class Home extends AppCompatActivity {
    ViewFlipper simpleViewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        int images[] = {R.drawable.slide1,R.drawable.slide2, R.drawable.slide3};

        simpleViewFlipper = findViewById(R.id.simpleViewFlipper);

        for (int image: images){
            flipperImages(image);
        }
    }
    public void flipperImages(int image){
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        simpleViewFlipper.addView(imageView);
        simpleViewFlipper.setFlipInterval(4000);
        simpleViewFlipper.setAutoStart(true);

        simpleViewFlipper.setInAnimation( this , android.R.anim.slide_in_left);
        simpleViewFlipper.setOutAnimation( this, android.R.anim.slide_out_right);
    }
}
