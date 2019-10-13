package com.example.galgelej;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity implements OnClickListener {

    Button newGame, highscore, hjælp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Find View By Id
        newGame = findViewById(R.id.newGame);
        highscore = findViewById(R.id.highscore);
        hjælp = findViewById(R.id.hjælp);

        // On Click Listener
        newGame.setOnClickListener(this);
        highscore.setOnClickListener(this);
        hjælp.setOnClickListener(this);
    }

    public void onClick(View v){
        if (v == newGame){
            Intent i = new Intent(this, GameActivity.class);
            startActivity(i);
        }
        else if (v == highscore){
            Intent i = new Intent(this, HighscoreActivity.class);
            startActivity(i);
        }
        else if (v == hjælp){
            Intent i = new Intent(this, HjaelpActivity.class);
            startActivity(i);
        }
    }
}
