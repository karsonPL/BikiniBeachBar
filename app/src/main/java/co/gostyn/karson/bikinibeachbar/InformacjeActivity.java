package co.gostyn.karson.bikinibeachbar;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;

import butterknife.Bind;
import butterknife.ButterKnife;

public class InformacjeActivity extends AppCompatActivity {

    @Bind(R.id.informacje_obrazek)
    ImageView informacjeObrazek;
    @Bind(R.id.informacje_tekst)
    TextView informacjeTekst;
    @Bind(R.id.fab)
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacje);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //ladowanie tesktu z assetow to TextView
        try {
            String text = MenuObject.loadStringFromAssets(this, "texts/informacje.txt");
            informacjeTekst.setText(Html.fromHtml(text));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
