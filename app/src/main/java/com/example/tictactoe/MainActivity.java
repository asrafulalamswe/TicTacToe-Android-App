package com.example.tictactoe;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {
//    private ActivityMainBinding binding;
    private int counter = 0;
    private TextView p1Turn,resultTv;
    private Button startBtn, btn11,btn12,btn13,btn21,btn22,btn23,btn31,btn32,btn33,playAgainBtn;
    private boolean checkPlayer1Turn = true;
    private boolean checkPlayer2Turn = false;
    private int b0,b1,b2,b3,b4,b5,b6,b7,b8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_main);
        setButton();
        setTextView();
        setOnclicklistener();
        mainBoxBtnDisable();
        startBtn.setOnClickListener(view -> {
            mainBoxBtnEnable();
            startBtn.setVisibility(View.GONE);
            p1Turn.setVisibility(View.VISIBLE);
        });
        playAgainBtn.setOnClickListener(view -> {
            mainBoxBtnEnable();
           btn11.setText("");
           btn12.setText("");
           btn13.setText("");
           btn21.setText("");
           btn22.setText("");
           btn23.setText("");
           btn31.setText("");
           btn32.setText("");
           btn33.setText("");
           resultTv.setVisibility(View.GONE);
           p1Turn.setText("Player 1's Turn");
           startBtn.setVisibility(View.GONE);
           playAgainBtn.setVisibility(View.GONE);
            btnReset();
        });

    }

    private void btnReset(){
        b0=0;
        b1=0;
        b2=0;
        b3=0;
        b4=0;
        b5=0;
        b6=0;
        b7=0;
        b8=0;
    }

    private void setOnclicklistener(){
        btn11.setOnClickListener(this);
        btn12.setOnClickListener(this);
        btn13.setOnClickListener(this);
        btn21.setOnClickListener(this);
        btn22.setOnClickListener(this);
        btn23.setOnClickListener(this);
        btn31.setOnClickListener(this);
        btn32.setOnClickListener(this);
        btn33.setOnClickListener(this);
        p1Turn.setOnClickListener(this);
        playAgainBtn.setOnClickListener(this);
//        p2Turn.setOnClickListener(this);
        resultTv.setOnClickListener(this);
    }
    private void setButton(){
        startBtn = findViewById(R.id.startBtn);
        playAgainBtn = findViewById(R.id.playAgainBtn);
        btn11 = findViewById(R.id.btn11);
        btn12 = findViewById(R.id.btn12);
        btn13 = findViewById(R.id.btn13);
        btn21 = findViewById(R.id.btn21);
        btn22 = findViewById(R.id.btn22);
        btn23 = findViewById(R.id.btn23);
        btn31 = findViewById(R.id.btn31);
        btn32 = findViewById(R.id.btn32);
        btn33 = findViewById(R.id.btn33);
    }
    private void setTextView(){
        p1Turn = findViewById(R.id.p1sTurn);
//        p2Turn = findViewById(R.id.p2sTurn);
        resultTv = findViewById(R.id.resultTV);
    }

    private void mainBoxBtnDisable(){
        btn11.setEnabled(false);
        btn12.setEnabled(false);
        btn13.setEnabled(false);
        btn21.setEnabled(false);
        btn22.setEnabled(false);
        btn23.setEnabled(false);
        btn31.setEnabled(false);
        btn32.setEnabled(false);
        btn33.setEnabled(false);
    }
    private void mainBoxBtnEnable(){
        btn11.setEnabled(true);
        btn12.setEnabled(true);
        btn13.setEnabled(true);
        btn21.setEnabled(true);
        btn22.setEnabled(true);
        btn23.setEnabled(true);
        btn31.setEnabled(true);
        btn32.setEnabled(true);
        btn33.setEnabled(true);
    }

    @Override
    public void onClick(View view) {
            if (checkPlayer1Turn){
                p1Turn.setText("Player 1's Turn");
                switch (view.getId()){
                    case R.id.btn11:
                        btn11.setText("X");
                        btn11.setEnabled(false);
                        b0 = 1;
                        break;

                    case R.id.btn12:
                        btn12.setText("X");
                        btn12.setEnabled(false);
                        b1 = 1;
                        break;

                    case R.id.btn13:
                        btn13.setText("X");
                        btn13.setEnabled(false);
                        b2 = 1;
                        break;

                    case R.id.btn21:
                        btn21.setText("X");
                        btn21.setEnabled(false);
                        b3 = 1;
                        break;

                    case R.id.btn22:
                        btn22.setText("X");
                        btn22.setEnabled(false);
                        b4 = 1;
                        break;

                    case R.id.btn23:
                        btn23.setText("X");
                        btn23.setEnabled(false);
                        b5 = 1;
                        break;

                    case R.id.btn31:
                        btn31.setText("X");
                        btn31.setEnabled(false);
                        b6  = 1;
                        break;
                    case R.id.btn32:
                        btn32.setText("X");
                        btn32.setEnabled(false);
                        b7  = 1;
                        break;
                    case R.id.btn33:
                        btn33.setText("X");
                        btn33.setEnabled(false);
                         b8 = 1;
                        break;
                }
                checkPlayer1Turn = false;
                checkPlayer2Turn = true;
                p1Turn.setText("Player 2's Turn");
                counter++;
                if ((b0==1 &&b1==1&&b2==1) || (b3==1&&b4==1&&b5==1) || (b6==1&&b7==1&&b8==1) ||
                            (b0==1&&b3==1&&b6==1) || (b1==1&&b4==1&&b7==1) || (b2==1&&b5==1&&b8==1) || (b0==1&&b4==1&&b8==1)
                            || (b2==1&&b4==1&&b6==1)) {
                        playAgainBtn.setVisibility(View.VISIBLE);
                        resultTv.setVisibility(View.VISIBLE);
                        resultTv.setText("Player 1 WIN! (*_*)");
                        p1Turn.setText("Game Over");
                        mainBoxBtnDisable();
                    checkPlayer1Turn = true;
                    checkPlayer2Turn = false;
                    counter=0;

                }else if ((b0==2 &&b1==2&&b2==2) || (b3==2&&b4==2&&b5==2) || (b6==2&&b7==2&&b8==2) ||
                            (b0==2&&b3==2&&b6==2) || (b1==2&&b4==2&&b7==2) || (b2==2&&b5==2&&b8==2) || (b0==2&&b4==2&&b8==2)
                            || (b2==2&&b4==2&&b6==2))  {
                    playAgainBtn.setVisibility(View.VISIBLE);
                    resultTv.setVisibility(View.VISIBLE);
                    resultTv.setText("Player 2 WIN! (*_*)");
                    p1Turn.setText("Game Over");
                    mainBoxBtnDisable();
                    checkPlayer1Turn = true;
                    checkPlayer2Turn = false;
                    counter=0;

                }else if (counter == 9){
                    resultTv.setVisibility(View.VISIBLE);
                    p1Turn.setText("Game Over");
                    resultTv.setText(" DRAW!! (*_*)");
                    playAgainBtn.setVisibility(View.VISIBLE);
                    checkPlayer1Turn = true;
                    checkPlayer2Turn = false;
                    counter=0;

                }

//            p1Turn.setVisibility(View.GONE);
            }  else if (checkPlayer2Turn){
                switch (view.getId()){
                    case R.id.btn11:
                        btn11.setText("0");
                        btn11.setEnabled(false);
                        b0=2;
                        break;
                    case R.id.btn12:
                        btn12.setText("O");
                        btn12.setEnabled(false);
                        b1=2;
                        break;
                    case R.id.btn13:
                        btn13.setText("O");
                        btn13.setEnabled(false);
                        b2=2;
                        break;
                    case R.id.btn21:
                        btn21.setText("O");
                        btn21.setEnabled(false);
                        b3=2;
                        break;
                    case R.id.btn22:
                        btn22.setText("O");
                        btn22.setEnabled(false);
                        b4=2;
                        break;
                    case R.id.btn23:
                        btn23.setText("O");
                        btn23.setEnabled(false);
                        b5=2;
                        break;
                    case R.id.btn31:
                        btn31.setText("O");
                        btn31.setEnabled(false);
                        b6=2;
                        break;
                    case R.id.btn32:
                        btn32.setText("O");
                        btn32.setEnabled(false);
                        b7=2;
                        break;
                    case R.id.btn33:
                        btn33.setText("O");
                        btn33.setEnabled(false);
                        b8=2;
                        break;
                }
                checkPlayer1Turn = true;
                checkPlayer2Turn = false;
                p1Turn.setText("Player 1's Turn");
                counter++;
                    if ((b0==1 &&b1==1&&b2==1) || (b3==1&&b4==1&&b5==1) || (b6==1&&b7==1&&b8==1) ||
                            (b0==1&&b3==1&&b6==1) || (b1==1&&b4==1&&b7==1) || (b2==1&&b5==1&&b8==1) || (b0==1&&b4==1&&b8==1)
                            || (b2==1&&b4==1&&b6==1)) {
                        resultTv.setVisibility(View.VISIBLE);
                        resultTv.setText("Player 1 WIN! (*_*)");
                        p1Turn.setText("Game Over");
                        playAgainBtn.setVisibility(View.VISIBLE);
                        mainBoxBtnDisable();
                        checkPlayer1Turn = true;
                        checkPlayer2Turn = false;
                        counter=0;

                    } else if ((b0==2 &&b1==2&&b2==2) || (b3==2&&b4==2&&b5==2) || (b6==2&&b7==2&&b8==2) ||
                            (b0==2&&b3==2&&b6==2) || (b1==2&&b4==2&&b7==2) || (b2==2&&b5==2&&b8==2) || (b0==2&&b4==2&&b8==2)
                            || (b2==2&&b4==2&&b6==2)) {
                        resultTv.setVisibility(View.VISIBLE);
                        resultTv.setText("Player 2 WIN! (*_*)");
                        p1Turn.setText("Game Over");
                        playAgainBtn.setVisibility(View.VISIBLE);
                        mainBoxBtnDisable();
                        checkPlayer1Turn = true;
                        checkPlayer2Turn = false;
                        counter=0;

                    } else if (counter == 9){
                        resultTv.setVisibility(View.VISIBLE);
                        p1Turn.setText("Game Over");
                        resultTv.setText(" DRAW!! (*_*)");
                        playAgainBtn.setVisibility(View.VISIBLE);
                        checkPlayer1Turn = true;
                        checkPlayer2Turn = false;
                        counter=0;

                    }
                
//            p2Turn.setVisibility(View.GONE);
            }
    }
}