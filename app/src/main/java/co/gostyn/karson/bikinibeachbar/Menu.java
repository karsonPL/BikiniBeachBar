package co.gostyn.karson.bikinibeachbar;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

/**
 * Created by karol on 2017-04-19.
 */

public class Menu implements Serializable {
    private String nazwa;
    private String opis;
    private String cena;
    private String gfx;

    public Menu() {
    }

    public Menu(String nazwa, String opis, String cena, String gfx) {
        this.nazwa = nazwa;
        this.opis = opis;
        this.cena = cena;
        this.gfx = gfx;
    }

    public Menu(JSONObject jsonObject) throws JSONException {
        nazwa = jsonObject.getString("nazwa");
        opis = jsonObject.getString("opis");
        cena = jsonObject.getString("cena");
      //  gfx = String.format("images/%s.jpg", gfx.toLowerCase());

      //  video = jsonObject.optString("video");


    }

    //metoda ladujaca z JSONa tablice
    public static Menu[] loadArrayFromJson (Context context, String type) {
        try {
            String json = loadStringFromAssets(context, "menu.json");
            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonArray = jsonObject.getJSONArray(type);

            return getMenuFromJsonArray(jsonArray);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        //jak sie nie uda to zwraca pusta tablice
        return new Menu[0];
    }


    private static Menu[] getMenuFromJsonArray(JSONArray jsonArray) throws JSONException {
        Menu[] menuObjects = new Menu[jsonArray.length()];

        for (int i = 0; i <  jsonArray.length(); i++) {
            Menu menuObject = new Menu(jsonArray.getJSONObject(i));
            menuObjects[i] = menuObject;
        }
        return menuObjects;
      /*  Toast.makeText(, "", Toast.LENGTH_SHORT).show();
        Toast.makeText(, "", Toast.LENGTH_SHORT).show();
        Toast.makeText(, "", Toast.LENGTH_SHORT).show();
        Toast.makeText(, "", Toast.LENGTH_SHORT).show();*/
    }

    //metoda wczytujaca plik i zwracajaca go jako String
    public static String loadStringFromAssets(Context context, String fileName) throws IOException {
        InputStream inputStream = context.getAssets().open(fileName);

       //sprawdza wielkosc pliku i tworzy bufor o tym rozmiarze
        int size = inputStream.available();
        byte[] buffer = new byte[size];

        //wczytanie pliku do bufora
        inputStream.read(buffer);
        inputStream.close();

        return new String(buffer, "UTF-8");
    }


    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getCena() {
        return cena;
    }

    public void setCena(String cena) {
        this.cena = cena;
    }

    public String getGfx() {
        return gfx;
    }

    public void setGfx(String gfx) {
        this.gfx = gfx;
    }
}
