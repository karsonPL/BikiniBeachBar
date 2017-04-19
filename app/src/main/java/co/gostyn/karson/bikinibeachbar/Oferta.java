package co.gostyn.karson.bikinibeachbar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class Oferta extends AppCompatActivity {

    @Bind(R.id.napoje_goraceRV)
    RecyclerView napojeGorace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oferta);
        ButterKnife.bind(this);

        //ladowanie tablicy pjedynczej i wyswietlanie w RecycleView
        Menu[] napoje_gorace = Menu.loadArrayFromJson(this, "napoje_gorace");
        napojeGorace.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        napojeGorace.setAdapter(new MenuAdapter(napoje_gorace));


    }
}
