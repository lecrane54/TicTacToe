package com.example.kylefebv.tictactoe;

import android.graphics.Color;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int activePlayer = 1;
    private ArrayList<Integer> player1 = new ArrayList<>();
    private ArrayList<Integer> player2 = new ArrayList<>();
    int winner = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Clickd(View view) {
        Button btn = (Button)view;
        int cellID = 0;
        switch(btn.getId()){
            case R.id.button1:
                cellID = 1;
                break;
            case R.id.button2:
                cellID = 2;
                break;
            case R.id.button3:
                cellID = 3;
                break;
            case R.id.button4:
                cellID = 4;
                break;
            case R.id.button5:
                cellID = 5;
                break;
            case R.id.button6:
                cellID = 6;
                break;
            case R.id.button7:
                cellID = 7;
                break;
            case R.id.button8:
                cellID = 8;
                break;
            case R.id.button9:
                cellID = 9;
                break;
        }
        playGame(cellID,btn);

    }

    void checkIfWinner(){

        if(player1.contains(1)&& player1.contains(2)&& player1.contains(3)){
            winner = 1;
        }
        if(player2.contains(1)&& player2.contains(2)&& player2.contains(3)){
            winner = 2;
        }

        if(player1.contains(4)&& player1.contains(5)&& player1.contains(6)){
            winner = 1;
        }
        if(player2.contains(4)&& player2.contains(5)&& player2.contains(6)){
            winner = 2;
        }

        if(player1.contains(7)&& player2.contains(8)&& player2.contains(9)){
            winner = 1;
        }
        if(player2.contains(7)&& player2.contains(8)&& player2.contains(9)){
            winner = 2;
        }

        if(player1.contains(1)&& player1.contains(4)&& player1.contains(7)){
            winner = 1;
        }
        if(player2.contains(1)&& player2.contains(4)&& player2.contains(7)){
            winner = 2;
        }

        if(player1.contains(2)&& player1.contains(5)&& player1.contains(8)){
            winner = 1;
        }
        if(player2.contains(2)&& player2.contains(5)&& player2.contains(8)){
            winner = 2;
        }

        if(player1.contains(3)&& player1.contains(6)&& player1.contains(9)){
            winner = 1;
        }
        if(player2.contains(3)&& player2.contains(6)&& player2.contains(9)){
            winner = 2;
        }

        if(player1.contains(1)&& player1.contains(5)&& player1.contains(9)){
            winner = 1;
        }
        if(player2.contains(1)&& player2.contains(5)&& player2.contains(9)){
            winner = 2;
        }

        if(player1.contains(3)&& player1.contains(5)&& player1.contains(7)){
            winner = 1;
        }
        if(player2.contains(3)&& player2.contains(5)&& player2.contains(7)){
            winner = 2;
        }

        if (winner != -1){
            Toast.makeText(MainActivity.this,"Player " + winner + " is the winner!" ,Toast.LENGTH_SHORT).show();

        }


    }

    void playGame(int id, Button b){
        if(activePlayer == 1){
            b.setText("X");
            b.setBackgroundColor(Color.GREEN);
            player1.add(id);
            activePlayer = 2;
            computerPlay();
        }else{
            b.setText("O");
            b.setBackgroundColor(Color.BLUE);
            player2.add(id);
            activePlayer =1;
        }
        b.setEnabled(false);
        checkIfWinner();
    }

    void computerPlay() {
        if (winner != 1 && activePlayer != 1) {
            ArrayList<Integer> empty = new ArrayList<>();

            for (int id = 1; id < 10; id++) {
                if (!(player1.contains(id) || player2.contains(id))) {
                    empty.add(id);
                }
            }

            Random r = new Random();
            int d = r.nextInt(empty.size());
            int cellId = empty.get(d);
            Button b;

            switch (cellId) {
                case 1:
                    b = (Button) findViewById(R.id.button1);
                    break;
                case 2:
                    b = (Button) findViewById(R.id.button2);
                    break;
                case 3:
                    b = (Button) findViewById(R.id.button3);
                    break;
                case 4:
                    b = (Button) findViewById(R.id.button4);
                    break;
                case 5:
                    b = (Button) findViewById(R.id.button5);
                    break;
                case 6:
                    b = (Button) findViewById(R.id.button6);
                    break;
                case 7:
                    b = (Button) findViewById(R.id.button7);
                    break;
                case 8:
                    b = (Button) findViewById(R.id.button8);
                    break;
                case 9:
                    b = (Button) findViewById(R.id.button9);
                    break;
                default:
                    b = (Button) findViewById(R.id.button1);
                    break;

            }

            playGame(cellId, b);

        }
    }

}
