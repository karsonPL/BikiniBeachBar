package co.gostyn.karson.bikinibeachbar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MenuActivity extends AppCompatActivity {

    @Bind(R.id.napojeGoraceRV)
    RecyclerView napojeGorace;
    @Bind(R.id.napojeZimneRV)
    RecyclerView napojeZimneRV;
    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        ButterKnife.bind(this);

        //ustawienie Toolbara lub w layout app:navigationIcon="?attr/homeAsUpIndicator"
        setSupportActionBar(mToolbar);
      /*  mToolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }

        });*/


        //ladowanie tablicy pjedynczej i wyswietlanie w RecycleView
        MenuObject[] napoje_gorace = MenuObject.loadArrayFromJson(this, "napoje_gorace");
        napojeGorace.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        napojeGorace.setAdapter(new MenuObjectsAdapter(napoje_gorace));

        MenuObject[] napoje_zimne = MenuObject.loadArrayFromJson(this, "napoje_zimne");
        napojeZimneRV.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        napojeZimneRV.setAdapter(new MenuObjectsAdapter(napoje_zimne));


    }
}
