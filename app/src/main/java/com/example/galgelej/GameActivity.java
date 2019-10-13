package com.example.galgelej;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class GameActivity extends AppCompatActivity implements OnClickListener {

    Galgelogik logik = new Galgelogik();
    private ImageView iv;
    private TextView info;
    private TextView gættet;
    private Button guess;
    private EditText et;

    List<Integer> image = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        logik.nulstil();
        try {
            logik.hentOrdFraRegneark("12");
        } catch (Exception e) {
            e.printStackTrace();
        }

        iv = findViewById(R.id.galge);
        info = findViewById(R.id.ord);
        gættet = findViewById(R.id.ordGættet);
        guess = findViewById(R.id.GuessButton);
        et = findViewById(R.id.editText);

        guess.setOnClickListener(this);
        logik.logStatus();

        image.add(R.drawable.galge);
        image.add(R.drawable.forkert1);
        image.add(R.drawable.forkert2);
        image.add(R.drawable.forkert3);
        image.add(R.drawable.forkert4);
        image.add(R.drawable.forkert5);
        image.add(R.drawable.forkert6);

        opdaterSkærm();
    }

    public void onClick(View v){
        String bogstav = et.getText().toString();
        if (bogstav.length() != 1){
            et.setError("Skriv et bogstav");
            et.setText(null);
            return;
        }
        logik.gætBogstav(bogstav);
        et.setText(null);
        et.setError(null);

        opdaterSkærm();
    }

    private void opdaterSkærm(){
        info.setText("Gæt ordet: " + logik.getSynligtOrd());
        gættet.setText(logik.getAntalForkerteBogstaver() + ": " + logik.getBrugteBogstaver());
        updatePicture();

        if (logik.erSpilletVundet()){
            info.setText("Du har vundet");
        }
        if (logik.erSpilletTabt()){
            info.setText("Du har tabt, ordet var: " + logik.getOrdet());
        }
    }

    private void updatePicture(){
        if (logik.getAntalForkerteBogstaver() < 7) {
            iv.setImageResource(image.get(logik.getAntalForkerteBogstaver()));
        }
    }
}
