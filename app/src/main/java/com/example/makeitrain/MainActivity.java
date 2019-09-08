package com.example.makeitrain;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private Button showMoney;
    private Button showTag;
    private Button newButton;
    private TextView moneyText;
    private TextView winningText;
    private int moneyCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);
        newButton = findViewById(R.id.new_button);


        newButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.activity_main);
                showMoney = findViewById(R.id.button_make_rain);
                showTag = findViewById(R.id.button_show_tag);
                moneyText = findViewById(R.id.money_text);
                winningText = findViewById(R.id.winning_text);
            }


        });

    }

    public void showTag(View v){
        Toast.makeText(getApplicationContext(), R.string.app_name , Toast.LENGTH_SHORT)
                .show();
    }

    public void makeItRain(View v){
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance();

        moneyCounter += 1000;
        moneyText.setText(numberFormat.format(moneyCounter));
        /*
          Example of getting color using getResources()
          moneyText.setTextColor(getResources().getColor(R.color.myColor));
         */

        switch (moneyCounter){
            case 20000:
                moneyText.setTextColor(Color.BLACK);
                break;
            case 40000:
                moneyText.setTextColor(Color.YELLOW);
                break;
            case 60000:
                moneyText.setTextColor(Color.GREEN);
                winningText.setText(R.string.winner);
                break;
            default:
                break;
        }
        Log.d("MYTAG", "onClick: Show Money" + moneyCounter);
    }
}
