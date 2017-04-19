package co.gostyn.karson.bikinibeachbar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.RelativeLayout;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = "log";
    @Bind(R.id.btnMenu)
    Button btnMenu;
    @Bind(R.id.btnWydarzenia)
    Button btnWydarzenia;
    @Bind(R.id.btnInformacje)
    Button btnInformacje;
    @Bind(R.id.btnZapraszamy)
    Button btnZapraszamy;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        /*Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
        finish();*/

        // pojawienie sie Buttonow - animacja
        movieViewFromLeft(btnMenu, 800);
        movieViewFromLeft(btnWydarzenia, 1000);
        movieViewFromLeft(btnInformacje, 1200);
        movieViewFromBottom(btnZapraszamy, 1200);


       /* btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                movieViewFromLeft(btnMenu, 800);
                movieViewFromLeft(btnWydarzenia, 1000);
                movieViewFromLeft(btnInformacje, 1200);
                movieViewFromBottom(btnZapraszamy, 1200);
            }
        });*/

    }

    @OnClick({R.id.btnMenu, R.id.btnWydarzenia, R.id.btnInformacje, R.id.btnZapraszamy})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnMenu:

                //movieViewFromLeftHide(btnMenu, 50);
                Intent intent = new Intent(this, MenuActivity.class);
                startActivity(intent);

                break;
            case R.id.btnWydarzenia:
                break;
            case R.id.btnInformacje:
                break;
            case R.id.btnZapraszamy:
                break;
        }
    }


    private void movieViewFromLeft(View view, int duration) {

        RelativeLayout root = (RelativeLayout) findViewById(R.id.rl);
        DisplayMetrics dm = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(dm);

    /*    int statusBarOffset = dm.heightPixels - root.getMeasuredHeight();
        int originalPos[] = new int[2];
        view.getLocationOnScreen( originalPos );
        int xDest = dm.widthPixels/2;
        xDest -= (view.getMeasuredWidth()/2);
        int yDest = dm.heightPixels/2 - (view.getMeasuredHeight()/2) - statusBarOffset;*/

        //TranslateAnimation anim = new TranslateAnimation( 0, xDest - originalPos[0] , 0, yDest - originalPos[1] );

        TranslateAnimation anim = new TranslateAnimation(-dm.widthPixels, 0, 0, 0);
        anim.setDuration(duration);
        anim.setFillAfter(true);
        view.startAnimation(anim);
    }

    private void movieViewFromLeftHide(View view, int duration) {


        DisplayMetrics dm = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(dm);

          TranslateAnimation anim = new TranslateAnimation(0, -50, 0, 0);
        anim.setDuration(duration);
        anim.setFillAfter(true);
        view.startAnimation(anim);
    }

    private void movieViewFromBottom(View view, int duration) {

        DisplayMetrics dm = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(dm);
        TranslateAnimation anim = new TranslateAnimation(0, 0, dm.heightPixels, 0);
        anim.setDuration(duration);
        anim.setFillAfter(true);
        view.startAnimation(anim);
    }



}
