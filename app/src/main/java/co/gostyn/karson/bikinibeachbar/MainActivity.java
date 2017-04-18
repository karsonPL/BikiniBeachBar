package co.gostyn.karson.bikinibeachbar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.RelativeLayout;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    @Bind(R.id.btnMenu)
    Button btnMenu;
    @Bind(R.id.btnWydarzenia)
    Button btnWydarzenia;
    @Bind(R.id.btnInformacje)
    Button btnInformacje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        /*Intent intent = new Intent(this, Oferta.class);
        startActivity(intent);
        finish();*/


        moveViewToScreenCenter(btnMenu,800);
        moveViewToScreenCenter(btnWydarzenia,1000);
        moveViewToScreenCenter(btnInformacje,1200);


        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                moveViewToScreenCenter(btnMenu,800);
                moveViewToScreenCenter(btnWydarzenia,1000);
                moveViewToScreenCenter(btnInformacje,1200);
            }
        });

    }

    private void moveViewToScreenCenter(View view, int duration) {

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
        TranslateAnimation anim = new TranslateAnimation(-1000, 0, 0, 0);
        anim.setDuration(duration);
        anim.setFillAfter(true);
        view.startAnimation(anim);
    }




}
