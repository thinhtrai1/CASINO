package com.example.casino;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.transition.Explode;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;

public class TaiXiuActivity extends AppCompatActivity {
    int money, beforeMoney, bet, sicbo1, sicbo2, sicbo3, true1, true2, true3, true4, true6, true7, true8, true9, true10;
    int[] s = {R.drawable.dice1, R.drawable.dice2, R.drawable.dice3, R.drawable.dice4, R.drawable.dice5, R.drawable.dice6};
    ArrayList<Integer> true5 = new ArrayList();
    Vector<Integer> select = new Vector();
    boolean open;
    Random random = new Random();
    CountDownTimer countDownTimer1, countDownTimer2, countDownTimer3;
    ImageView imgSicbo1, imgSicbo2, imgSicbo3;
    TextView tvMoney, tvBeforeMoney;
    Button btnStart, btnClear;
    Spinner betSpinner;
    Button[] mButtons = new Button[18];
    View[] mViews = new View[28];
    ImageView[] mImages = new ImageView[6];
    int[] mId = {R.id.s1, R.id.s2, R.id.s3, R.id.s4, R.id.s5, R.id.s6, R.id.s7, R.id.s8, R.id.s9, R.id.s10, R.id.s11, R.id.s12, R.id.s13
            , R.id.s14, R.id.s15, R.id.s16, R.id.s17, R.id.s18, R.id.s19, R.id.s20, R.id.s21, R.id.s22, R.id.s23, R.id.s24, R.id.s25, R.id.s26
            , R.id.s27, R.id.s28, R.id.s29, R.id.s30, R.id.s31, R.id.s32, R.id.s33, R.id.s34, R.id.s35, R.id.s36, R.id.s37, R.id.s38, R.id.s39
            , R.id.s40, R.id.s41, R.id.s42, R.id.s43, R.id.s44, R.id.s45, R.id.s46, R.id.s47, R.id.s48, R.id.s49, R.id.s50, R.id.s51, R.id.s52};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tai_xiu);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Explode explode = new Explode();
            explode.setDuration(1000);
            getWindow().setEnterTransition(explode);
        }

        btnStart = findViewById(R.id.btn_start);
        btnClear = findViewById(R.id.btn_clear);
        imgSicbo1 = findViewById(R.id.sicbo1);
        imgSicbo2 = findViewById(R.id.sicbo2);
        imgSicbo3 = findViewById(R.id.sicbo3);
        betSpinner = findViewById(R.id.bet_spinner);
        tvMoney = findViewById(R.id.money);
        tvBeforeMoney = findViewById(R.id.tv_before_money);

        money = getSharedPreferences("money", MODE_PRIVATE).getInt("money", 500000);
        tvMoney.setText("" + money);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter
                .createFromResource(this, R.array.bet_array, android.R.layout.simple_spinner_dropdown_item);
        betSpinner.setAdapter(adapter);
        betSpinner.setSelection(1);
        betSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) bet = 2000;
                else if (i == 1) bet = 5000;
                else bet = 10000;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        for (int i = 0; i < 13; i++) {
            final int temp = i;
            mViews[i] = findViewById(mId[i]);
            mViews[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    s1_13(temp);
                }
            });
        }

        for (int i = 0; i < 14; i++) {
            final int temp = i;
            mButtons[i] = findViewById(mId[i + 13]);
            mButtons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    s14_27(temp);
                }
            });
        }

        for (int i = 13; i < 28; i++) {
            final int temp = i;
            mViews[i] = findViewById(mId[i + 14]);
            mViews[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    s28_42(temp);
                }
            });
        }

        for (int i = 0; i < 6; i++) {
            final int temp = i;
            mImages[i] = findViewById(mId[i + 42]);
            mImages[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    s43_48(temp);
                }
            });
        }

        for (int i = 14; i < 18; i++) {
            final int temp = i;
            mButtons[i] = findViewById(mId[i + 34]);
            mButtons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    s49_52(temp);
                }
            });
        }
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!open) {
                    open = true;
                    beforeMoney = money;
                    tvBeforeMoney.setText("");
                    true1 = true2 = true3 = true4 = true6 = true7 = true8 = true9 = true10 = 0;
                    true5.clear();
                    start();
                }
            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!open) clear();
            }
        });
    }

    void start() {
        imgSicbo1.startAnimation(AnimationUtils.loadAnimation(TaiXiuActivity.this, R.anim.spin1));
        imgSicbo2.startAnimation(AnimationUtils.loadAnimation(TaiXiuActivity.this, R.anim.spin2));
        imgSicbo3.startAnimation(AnimationUtils.loadAnimation(TaiXiuActivity.this, R.anim.spin3));
        countDownTimer1 = new CountDownTimer(3000, 100) {
            @Override
            public void onTick(long l) {
                sicbo1 = random.nextInt(6);
                imgSicbo1.setImageResource(s[sicbo1]);
            }

            @Override
            public void onFinish() {
                sicbo1++;
            }
        };
        countDownTimer2 = new CountDownTimer(4000, 100) {
            @Override
            public void onTick(long l) {
                sicbo2 = random.nextInt(6);
                imgSicbo2.setImageResource(s[sicbo2]);
            }

            @Override
            public void onFinish() {
                sicbo2++;
            }
        };
        countDownTimer3 = new CountDownTimer(5000, 100) {
            @Override
            public void onTick(long l) {
                sicbo3 = random.nextInt(6);
                imgSicbo3.setImageResource(s[sicbo3]);
            }

            @Override
            public void onFinish() {
                sicbo3++;
                if (select.size() != 0) {
                    end();
                    money();
                }
                open = false;
            }
        };
        countDownTimer1.start();
        countDownTimer2.start();
        countDownTimer3.start();
    }

    void end() {
        if (sicbo1 == sicbo2 && sicbo2 == sicbo3) {
            true2 = sicbo1 + 6;
            true3 = 13;
        } else {
            if (sicbo1 == sicbo2) true1 = sicbo1;
            else if (sicbo1 == sicbo3 || sicbo2 == sicbo3) true1 = sicbo3;
        }
        if (sicbo1 + sicbo2 + sicbo3 > 3 && sicbo1 + sicbo2 + sicbo3 < 18)
            true4 = 10 + sicbo1 + sicbo2 + sicbo3;
        if (sicbo1 == 1 || sicbo2 == 1 || sicbo3 == 1) {
            if (sicbo1 == 2 || sicbo2 == 2 || sicbo3 == 2) true5.add(28);
            if (sicbo1 == 3 || sicbo2 == 3 || sicbo3 == 3) true5.add(29);
            if (sicbo1 == 4 || sicbo2 == 4 || sicbo3 == 4) true5.add(30);
            if (sicbo1 == 5 || sicbo2 == 5 || sicbo3 == 5) true5.add(31);
            if (sicbo1 == 6 || sicbo2 == 6 || sicbo3 == 6) true5.add(32);
        }
        if (sicbo1 == 2 || sicbo2 == 2 || sicbo3 == 2) {
            if (sicbo1 == 3 || sicbo2 == 3 || sicbo3 == 3) true5.add(33);
            if (sicbo1 == 4 || sicbo2 == 4 || sicbo3 == 4) true5.add(34);
            if (sicbo1 == 5 || sicbo2 == 5 || sicbo3 == 5) true5.add(35);
            if (sicbo1 == 6 || sicbo2 == 6 || sicbo3 == 6) true5.add(36);
        }
        if (sicbo1 == 3 || sicbo2 == 3 || sicbo3 == 3) {
            if (sicbo1 == 4 || sicbo2 == 4 || sicbo3 == 4) true5.add(37);
            if (sicbo1 == 5 || sicbo2 == 5 || sicbo3 == 5) true5.add(38);
            if (sicbo1 == 6 || sicbo2 == 6 || sicbo3 == 6) true5.add(39);
        }
        if (sicbo1 == 4 || sicbo2 == 4 || sicbo3 == 4) {
            if (sicbo1 == 5 || sicbo2 == 5 || sicbo3 == 5) true5.add(40);
            if (sicbo1 == 6 || sicbo2 == 6 || sicbo3 == 6) true5.add(41);
        }
        if ((sicbo1 == 5 || sicbo2 == 5 || sicbo3 == 5) && (sicbo1 == 6 || sicbo2 == 6 || sicbo3 == 6))
            true5.add(42);
        true6 = 42 + sicbo1;
        true7 = 42 + sicbo2;
        true8 = 42 + sicbo3;
        if (sicbo1 + sicbo2 + sicbo3 > 10 && true3 != 13)
            true9 = 49;
        else if (sicbo1 + sicbo2 + sicbo3 < 11 && true3 != 13)
            true9 = 52;
        if ((sicbo1 + sicbo2 + sicbo3) % 2 == 0 && true3 != 13)
            true10 = 50;
        else if ((sicbo1 + sicbo2 + sicbo3) % 2 == 1 && true3 != 13)
            true10 = 51;
    }

    void money() {
        money = money - bet * select.size();
        if (select.contains(true1)) money = money + bet * 14;
        if (select.contains(true2)) money = money + bet * 216;
        if (select.contains(true3)) money = money + bet * 36;
        if (select.contains(true4)) {
            if (true4 == 14 || true4 == 27) money = money + bet * 71;
            else if (true4 == 15 || true4 == 26) money = money + bet * 36;
            else if (true4 == 16 || true4 == 25) money = money + bet * 21;
            else if (true4 == 17 || true4 == 24) money = money + bet * 14;
            else if (true4 == 18 || true4 == 23) money = money + bet * 10;
            else if (true4 == 19 || true4 == 22) money = money + bet * 9;
            else if (true4 == 20 || true4 == 21) money = money + bet * 8;
        }
        for (int i = 0; i < true5.size(); i++) {
            if (select.contains(true5.get(i))) money = money + bet * 7;
        }
        if (select.contains(true6)) money = money + bet * 2;
        if (select.contains(true7)) {
            if (true7 == true6) money = money + bet;
            else money = money + bet * 2;
        }
        if (select.contains(true8)) {
            if (true8 == true6 || true8 == true7) money = money + bet;
            else money = money + bet * 2;
        }
        if (select.contains(true9)) money = money + bet * 2;
        if (select.contains(true10)) money = money + bet * 2;
        if (beforeMoney > money) tvBeforeMoney.setText("-" + (beforeMoney - money));
        else tvBeforeMoney.setText("+" + (money - beforeMoney));
        tvMoney.setText("" + money);
        getSharedPreferences("money", MODE_PRIVATE).edit().putInt("money", money).apply();
    }

    void s1_13(int n) {
        if (!select.contains(n + 1)) {
            select.add(n + 1);
            mViews[n].setBackgroundResource(R.drawable.background_click_2);
        } else {
            select.removeElement(n + 1);
            mViews[n].setBackgroundResource(R.drawable.background_click);
        }
    }

    void s14_27(int n){
        if (!select.contains(n + 14)) {
            select.add(n + 14);
            mButtons[n].setBackgroundResource(R.drawable.btn_red);
        } else {
            select.removeElement(n + 14);
            mButtons[n].setBackgroundResource(R.drawable.btn_grey);
        }
    }

    void s28_42(int n){
        if (!select.contains(n + 15)) {
            select.add(n + 15);
            mViews[n].setBackgroundResource(R.drawable.background_click_2);
        } else {
            select.removeElement(n + 15);
            mViews[n].setBackgroundResource(R.drawable.background_click);
        }
    }

    void s43_48(int n) {
        if (!select.contains(n + 43)) {
            select.add(n + 43);
            mImages[n].setBackgroundResource(R.drawable.background_click_2);
        } else {
            select.removeElement(n + 43);
            mImages[n].setBackgroundResource(R.drawable.background_click);
        }
    }

    void s49_52(int n) {
        if (!select.contains(n + 35)) {
            select.add(n + 35);
            mButtons[n].setBackgroundResource(R.drawable.btn_red);
        } else {
            select.removeElement(n + 35);
            mButtons[n].setBackgroundResource(R.drawable.btn_grey);
        }
    }

    void clear() {
        select.removeAllElements();
        tvBeforeMoney.setText("");
        for (int i = 0; i < mViews.length; i++) {
            mViews[i].setBackgroundResource(R.drawable.background_click);
        }
        for (int i = 0; i < mButtons.length; i++) {
            mButtons[i].setBackgroundResource(R.drawable.btn_grey);
        }
        for (int i = 0; i < mImages.length; i++) {
            mImages[i].setBackgroundResource(R.drawable.background_click);
        }
    }

    public void onBackPressed() {
        Intent intent = new Intent(TaiXiuActivity.this, MainActivity.class);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(TaiXiuActivity.this);
            startActivity(intent, options.toBundle());
        } else startActivity(intent);
    }
}
