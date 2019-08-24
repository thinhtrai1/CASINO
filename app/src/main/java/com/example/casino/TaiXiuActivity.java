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
    ArrayList true5 = new ArrayList();
    Vector select = new Vector();
    boolean open, viewSpace;
    Random random = new Random();
    CountDownTimer countDownTimer1, countDownTimer2, countDownTimer3;
    ImageView imgSicbo1, imgSicbo2, imgSicbo3, s43, s44, s45, s46, s47, s48;
    TextView tvMoney, tvBeforeMoney;
    Button btnStart, btnClear, s14, s15, s16, s17, s18, s19, s20, s21, s22, s23, s24, s25, s26, s27, s49, s50, s51, s52;
    Spinner betSpinner;
    View s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13,
            s28, s29, s30, s31, s32, s33, s34, s35, s36, s37, s38, s39, s40, s41, s42, space1, space2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tai_xiu);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Explode explode = new Explode();
            explode.setDuration(1000);
            getWindow().setEnterTransition(explode);
        }

        s1 = findViewById(R.id.s1);
        s2 = findViewById(R.id.s2);
        s3 = findViewById(R.id.s3);
        s4 = findViewById(R.id.s4);
        s5 = findViewById(R.id.s5);
        s6 = findViewById(R.id.s6);
        s7 = findViewById(R.id.s7);
        s8 = findViewById(R.id.s8);
        s9 = findViewById(R.id.s9);
        s10 = findViewById(R.id.s10);
        s11 = findViewById(R.id.s11);
        s12 = findViewById(R.id.s12);
        s13 = findViewById(R.id.s13);
        s14 = findViewById(R.id.s14);
        s15 = findViewById(R.id.s15);
        s16 = findViewById(R.id.s16);
        s17 = findViewById(R.id.s17);
        s18 = findViewById(R.id.s18);
        s19 = findViewById(R.id.s19);
        s20 = findViewById(R.id.s20);
        s21 = findViewById(R.id.s21);
        s22 = findViewById(R.id.s22);
        s23 = findViewById(R.id.s23);
        s24 = findViewById(R.id.s24);
        s25 = findViewById(R.id.s25);
        s26 = findViewById(R.id.s26);
        s27 = findViewById(R.id.s27);
        s28 = findViewById(R.id.s28);
        s29 = findViewById(R.id.s29);
        s30 = findViewById(R.id.s30);
        s31 = findViewById(R.id.s31);
        s32 = findViewById(R.id.s32);
        s33 = findViewById(R.id.s33);
        s34 = findViewById(R.id.s34);
        s35 = findViewById(R.id.s35);
        s36 = findViewById(R.id.s36);
        s37 = findViewById(R.id.s37);
        s38 = findViewById(R.id.s38);
        s39 = findViewById(R.id.s39);
        s40 = findViewById(R.id.s40);
        s41 = findViewById(R.id.s41);
        s42 = findViewById(R.id.s42);
        s43 = findViewById(R.id.s43);
        s44 = findViewById(R.id.s44);
        s45 = findViewById(R.id.s45);
        s46 = findViewById(R.id.s46);
        s47 = findViewById(R.id.s47);
        s48 = findViewById(R.id.s48);
        s49 = findViewById(R.id.s49);
        s50 = findViewById(R.id.s50);
        s51 = findViewById(R.id.s51);
        s52 = findViewById(R.id.s52);

        btnStart = findViewById(R.id.btn_start);
        btnClear = findViewById(R.id.btn_clear);
        imgSicbo1 = findViewById(R.id.sicbo1);
        imgSicbo2 = findViewById(R.id.sicbo2);
        imgSicbo3 = findViewById(R.id.sicbo3);
        betSpinner = findViewById(R.id.bet_spinner);
        tvMoney = findViewById(R.id.money);
        tvBeforeMoney = findViewById(R.id.tv_before_money);
        space1 = findViewById(R.id.view_space_1);
        space2 = findViewById(R.id.view_space_2);

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

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (open == false) {
                    open = true;
                    beforeMoney = money;
                    tvBeforeMoney.setText("");
                    true1 = true2 = true3 = true4 = true6 = true7 = true8 = true9 = true10 = 0;
                    true5.clear();
                    start();
                }
            }
        });
        btnStart.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if (open == false) {
                    if (viewSpace == false) {
                        viewSpace = true;
                        space1.setVisibility(View.VISIBLE);
                        space2.setVisibility(View.VISIBLE);
                    } else {
                        viewSpace = false;
                        space1.setVisibility(View.GONE);
                        space2.setVisibility(View.GONE);
                    }
                }
                return true;
            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clear();
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
        if (money > beforeMoney) tvBeforeMoney.setText("+" + (money - beforeMoney));
        else if (money < beforeMoney) tvBeforeMoney.setText("-" + (beforeMoney - money));
        tvMoney.setText("" + money);
        getSharedPreferences("money", MODE_PRIVATE).edit().putInt("money", money).apply();
    }

    public void onClick(View view) {
        if (open == false) {
            switch (view.getId()) {
                case R.id.s1:
                    if (!select.contains(1)) {
                        select.add(1);
                        s1.setBackgroundResource(R.drawable.background_click_2);
                    } else {
                        select.removeElement(1);
                        s1.setBackgroundResource(R.drawable.background_click);
                    }
                    break;
                case R.id.s2:
                    if (!select.contains(2)) {
                        select.add(2);
                        s2.setBackgroundResource(R.drawable.background_click_2);
                    } else {
                        select.removeElement(2);
                        s2.setBackgroundResource(R.drawable.background_click);
                    }
                    break;
                case R.id.s3:
                    if (!select.contains(3)) {
                        select.add(3);
                        s3.setBackgroundResource(R.drawable.background_click_2);
                    } else {
                        select.removeElement(3);
                        s3.setBackgroundResource(R.drawable.background_click);
                    }
                    break;
                case R.id.s4:
                    if (!select.contains(4)) {
                        select.add(4);
                        s4.setBackgroundResource(R.drawable.background_click_2);
                    } else {
                        select.removeElement(4);
                        s4.setBackgroundResource(R.drawable.background_click);
                    }
                    break;
                case R.id.s5:
                    if (!select.contains(5)) {
                        select.add(5);
                        s5.setBackgroundResource(R.drawable.background_click_2);
                    } else {
                        select.removeElement(5);
                        s5.setBackgroundResource(R.drawable.background_click);
                    }
                    break;
                case R.id.s6:
                    if (!select.contains(6)) {
                        select.add(6);
                        s6.setBackgroundResource(R.drawable.background_click_2);
                    } else {
                        select.removeElement(6);
                        s6.setBackgroundResource(R.drawable.background_click);
                    }
                    break;
                case R.id.s7:
                    if (!select.contains(7)) {
                        select.add(7);
                        s7.setBackgroundResource(R.drawable.background_click_2);
                    } else {
                        select.removeElement(7);
                        s7.setBackgroundResource(R.drawable.background_click);
                    }
                    break;
                case R.id.s8:
                    if (!select.contains(8)) {
                        select.add(8);
                        s8.setBackgroundResource(R.drawable.background_click_2);
                    } else {
                        select.removeElement(8);
                        s8.setBackgroundResource(R.drawable.background_click);
                    }
                    break;
                case R.id.s9:
                    if (!select.contains(9)) {
                        select.add(9);
                        s9.setBackgroundResource(R.drawable.background_click_2);
                    } else {
                        select.removeElement(9);
                        s9.setBackgroundResource(R.drawable.background_click);
                    }
                    break;
                case R.id.s10:
                    if (!select.contains(10)) {
                        select.add(10);
                        s10.setBackgroundResource(R.drawable.background_click_2);
                    } else {
                        select.removeElement(10);
                        s10.setBackgroundResource(R.drawable.background_click);
                    }
                    break;
                case R.id.s11:
                    if (!select.contains(11)) {
                        select.add(11);
                        s11.setBackgroundResource(R.drawable.background_click_2);
                    } else {
                        select.removeElement(11);
                        s11.setBackgroundResource(R.drawable.background_click);
                    }
                    break;
                case R.id.s12:
                    if (!select.contains(12)) {
                        select.add(12);
                        s12.setBackgroundResource(R.drawable.background_click_2);
                    } else {
                        select.removeElement(12);
                        s12.setBackgroundResource(R.drawable.background_click);
                    }
                    break;
                case R.id.s13:
                    if (!select.contains(13)) {
                        select.add(13);
                        s13.setBackgroundResource(R.drawable.background_click_2);
                    } else {
                        select.removeElement(13);
                        s13.setBackgroundResource(R.drawable.background_click);
                    }
                    break;
                case R.id.s14:
                    if (!select.contains(14)) {
                        select.add(14);
                        s14.setBackgroundResource(R.drawable.btn_red);
                    } else {
                        select.removeElement(14);
                        s14.setBackgroundResource(R.drawable.btn_grey);
                    }
                    break;
                case R.id.s15:
                    if (!select.contains(15)) {
                        select.add(15);
                        s15.setBackgroundResource(R.drawable.btn_red);
                    } else {
                        select.removeElement(15);
                        s15.setBackgroundResource(R.drawable.btn_grey);
                    }
                    break;
                case R.id.s16:
                    if (!select.contains(16)) {
                        select.add(16);
                        s16.setBackgroundResource(R.drawable.btn_red);
                    } else {
                        select.removeElement(16);
                        s16.setBackgroundResource(R.drawable.btn_grey);
                    }
                    break;
                case R.id.s17:
                    if (!select.contains(17)) {
                        select.add(17);
                        s17.setBackgroundResource(R.drawable.btn_red);
                    } else {
                        select.removeElement(17);
                        s17.setBackgroundResource(R.drawable.btn_grey);
                    }
                    break;
                case R.id.s18:
                    if (!select.contains(18)) {
                        select.add(18);
                        s18.setBackgroundResource(R.drawable.btn_red);
                    } else {
                        select.removeElement(18);
                        s18.setBackgroundResource(R.drawable.btn_grey);
                    }
                    break;
                case R.id.s19:
                    if (!select.contains(19)) {
                        select.add(19);
                        s19.setBackgroundResource(R.drawable.btn_red);
                    } else {
                        select.removeElement(19);
                        s19.setBackgroundResource(R.drawable.btn_grey);
                    }
                    break;
                case R.id.s20:
                    if (!select.contains(20)) {
                        select.add(20);
                        s20.setBackgroundResource(R.drawable.btn_red);
                    } else {
                        select.removeElement(20);
                        s20.setBackgroundResource(R.drawable.btn_grey);
                    }
                    break;
                case R.id.s21:
                    if (!select.contains(21)) {
                        select.add(21);
                        s21.setBackgroundResource(R.drawable.btn_red);
                    } else {
                        select.removeElement(21);
                        s21.setBackgroundResource(R.drawable.btn_grey);
                    }
                    break;
                case R.id.s22:
                    if (!select.contains(22)) {
                        select.add(22);
                        s22.setBackgroundResource(R.drawable.btn_red);
                    } else {
                        select.removeElement(22);
                        s22.setBackgroundResource(R.drawable.btn_grey);
                    }
                    break;
                case R.id.s23:
                    if (!select.contains(23)) {
                        select.add(23);
                        s23.setBackgroundResource(R.drawable.btn_red);
                    } else {
                        select.removeElement(23);
                        s23.setBackgroundResource(R.drawable.btn_grey);
                    }
                    break;
                case R.id.s24:
                    if (!select.contains(24)) {
                        select.add(24);
                        s24.setBackgroundResource(R.drawable.btn_red);
                    } else {
                        select.removeElement(24);
                        s24.setBackgroundResource(R.drawable.btn_grey);
                    }
                    break;
                case R.id.s25:
                    if (!select.contains(25)) {
                        select.add(25);
                        s25.setBackgroundResource(R.drawable.btn_red);
                    } else {
                        select.removeElement(25);
                        s25.setBackgroundResource(R.drawable.btn_grey);
                    }
                    break;
                case R.id.s26:
                    if (!select.contains(26)) {
                        select.add(26);
                        s26.setBackgroundResource(R.drawable.btn_red);
                    } else {
                        select.removeElement(26);
                        s26.setBackgroundResource(R.drawable.btn_grey);
                    }
                    break;
                case R.id.s27:
                    if (!select.contains(27)) {
                        select.add(27);
                        s27.setBackgroundResource(R.drawable.btn_red);
                    } else {
                        select.removeElement(27);
                        s27.setBackgroundResource(R.drawable.btn_grey);
                    }
                    break;
                case R.id.s28:
                    if (!select.contains(28)) {
                        select.add(28);
                        s28.setBackgroundResource(R.drawable.background_click_2);
                    } else {
                        select.removeElement(28);
                        s28.setBackgroundResource(R.drawable.background_click);
                    }
                    break;
                case R.id.s29:
                    if (!select.contains(29)) {
                        select.add(29);
                        s29.setBackgroundResource(R.drawable.background_click_2);
                    } else {
                        select.removeElement(29);
                        s29.setBackgroundResource(R.drawable.background_click);
                    }
                    break;
                case R.id.s30:
                    if (!select.contains(30)) {
                        select.add(30);
                        s30.setBackgroundResource(R.drawable.background_click_2);
                    } else {
                        select.removeElement(30);
                        s30.setBackgroundResource(R.drawable.background_click);
                    }
                    break;
                case R.id.s31:
                    if (!select.contains(31)) {
                        select.add(31);
                        s31.setBackgroundResource(R.drawable.background_click_2);
                    } else {
                        select.removeElement(31);
                        s31.setBackgroundResource(R.drawable.background_click);
                    }
                    break;
                case R.id.s32:
                    if (!select.contains(32)) {
                        select.add(32);
                        s32.setBackgroundResource(R.drawable.background_click_2);
                    } else {
                        select.removeElement(32);
                        s32.setBackgroundResource(R.drawable.background_click);
                    }
                    break;
                case R.id.s33:
                    if (!select.contains(33)) {
                        select.add(33);
                        s33.setBackgroundResource(R.drawable.background_click_2);
                    } else {
                        select.removeElement(33);
                        s33.setBackgroundResource(R.drawable.background_click);
                    }
                    break;
                case R.id.s34:
                    if (!select.contains(34)) {
                        select.add(34);
                        s34.setBackgroundResource(R.drawable.background_click_2);
                    } else {
                        select.removeElement(34);
                        s34.setBackgroundResource(R.drawable.background_click);
                    }
                    break;
                case R.id.s35:
                    if (!select.contains(35)) {
                        select.add(35);
                        s35.setBackgroundResource(R.drawable.background_click_2);
                    } else {
                        select.removeElement(35);
                        s35.setBackgroundResource(R.drawable.background_click);
                    }
                    break;
                case R.id.s36:
                    if (!select.contains(36)) {
                        select.add(36);
                        s36.setBackgroundResource(R.drawable.background_click_2);
                    } else {
                        select.removeElement(36);
                        s36.setBackgroundResource(R.drawable.background_click);
                    }
                    break;
                case R.id.s37:
                    if (!select.contains(37)) {
                        select.add(37);
                        s37.setBackgroundResource(R.drawable.background_click_2);
                    } else {
                        select.removeElement(37);
                        s37.setBackgroundResource(R.drawable.background_click);
                    }
                    break;
                case R.id.s38:
                    if (!select.contains(38)) {
                        select.add(38);
                        s38.setBackgroundResource(R.drawable.background_click_2);
                    } else {
                        select.removeElement(38);
                        s38.setBackgroundResource(R.drawable.background_click);
                    }
                    break;
                case R.id.s39:
                    if (!select.contains(39)) {
                        select.add(39);
                        s39.setBackgroundResource(R.drawable.background_click_2);
                    } else {
                        select.removeElement(39);
                        s39.setBackgroundResource(R.drawable.background_click);
                    }
                    break;
                case R.id.s40:
                    if (!select.contains(40)) {
                        select.add(40);
                        s40.setBackgroundResource(R.drawable.background_click_2);
                    } else {
                        select.removeElement(40);
                        s40.setBackgroundResource(R.drawable.background_click);
                    }
                    break;
                case R.id.s41:
                    if (!select.contains(41)) {
                        select.add(41);
                        s41.setBackgroundResource(R.drawable.background_click_2);
                    } else {
                        select.removeElement(41);
                        s41.setBackgroundResource(R.drawable.background_click);
                    }
                    break;
                case R.id.s42:
                    if (!select.contains(42)) {
                        select.add(42);
                        s42.setBackgroundResource(R.drawable.background_click_2);
                    } else {
                        select.removeElement(42);
                        s42.setBackgroundResource(R.drawable.background_click);
                    }
                    break;
                case R.id.s43:
                    if (!select.contains(43)) {
                        select.add(43);
                        s43.setBackgroundResource(R.drawable.background_click_2);
                    } else {
                        select.removeElement(43);
                        s43.setBackgroundResource(R.drawable.background_click);
                    }
                    break;
                case R.id.s44:
                    if (!select.contains(44)) {
                        select.add(44);
                        s44.setBackgroundResource(R.drawable.background_click_2);
                    } else {
                        select.removeElement(44);
                        s44.setBackgroundResource(R.drawable.background_click);
                    }
                    break;
                case R.id.s45:
                    if (!select.contains(45)) {
                        select.add(45);
                        s45.setBackgroundResource(R.drawable.background_click_2);
                    } else {
                        select.removeElement(45);
                        s45.setBackgroundResource(R.drawable.background_click);
                    }
                    break;
                case R.id.s46:
                    if (!select.contains(46)) {
                        select.add(46);
                        s46.setBackgroundResource(R.drawable.background_click_2);
                    } else {
                        select.removeElement(46);
                        s46.setBackgroundResource(R.drawable.background_click);
                    }
                    break;
                case R.id.s47:
                    if (!select.contains(47)) {
                        select.add(47);
                        s47.setBackgroundResource(R.drawable.background_click_2);
                    } else {
                        select.removeElement(47);
                        s47.setBackgroundResource(R.drawable.background_click);
                    }
                    break;
                case R.id.s48:
                    if (!select.contains(48)) {
                        select.add(48);
                        s48.setBackgroundResource(R.drawable.background_click_2);
                    } else {
                        select.removeElement(48);
                        s48.setBackgroundResource(R.drawable.background_click);
                    }
                    break;
                case R.id.s49:
                    if (!select.contains(49)) {
                        select.add(49);
                        s49.setBackgroundResource(R.drawable.btn_red);
                    } else {
                        select.removeElement(49);
                        s49.setBackgroundResource(R.drawable.btn_grey);
                    }
                    break;
                case R.id.s50:
                    if (!select.contains(50)) {
                        select.add(50);
                        s50.setBackgroundResource(R.drawable.btn_red);
                    } else {
                        select.removeElement(50);
                        s50.setBackgroundResource(R.drawable.btn_grey);
                    }
                    break;
                case R.id.s51:
                    if (!select.contains(51)) {
                        select.add(51);
                        s51.setBackgroundResource(R.drawable.btn_red);
                    } else {
                        select.removeElement(51);
                        s51.setBackgroundResource(R.drawable.btn_grey);
                    }
                    break;
                case R.id.s52:
                    if (!select.contains(52)) {
                        select.add(52);
                        s52.setBackgroundResource(R.drawable.btn_red);
                    } else {
                        select.removeElement(52);
                        s52.setBackgroundResource(R.drawable.btn_grey);
                    }
                    break;
            }
        }
    }

    void clear() {
        select.removeAllElements();
        tvBeforeMoney.setText("");
        s1.setBackgroundResource(R.drawable.background_click);
        s2.setBackgroundResource(R.drawable.background_click);
        s3.setBackgroundResource(R.drawable.background_click);
        s4.setBackgroundResource(R.drawable.background_click);
        s5.setBackgroundResource(R.drawable.background_click);
        s6.setBackgroundResource(R.drawable.background_click);
        s7.setBackgroundResource(R.drawable.background_click);
        s8.setBackgroundResource(R.drawable.background_click);
        s9.setBackgroundResource(R.drawable.background_click);
        s10.setBackgroundResource(R.drawable.background_click);
        s11.setBackgroundResource(R.drawable.background_click);
        s12.setBackgroundResource(R.drawable.background_click);
        s13.setBackgroundResource(R.drawable.background_click);
        s14.setBackgroundResource(R.drawable.btn_grey);
        s15.setBackgroundResource(R.drawable.btn_grey);
        s16.setBackgroundResource(R.drawable.btn_grey);
        s17.setBackgroundResource(R.drawable.btn_grey);
        s18.setBackgroundResource(R.drawable.btn_grey);
        s19.setBackgroundResource(R.drawable.btn_grey);
        s20.setBackgroundResource(R.drawable.btn_grey);
        s21.setBackgroundResource(R.drawable.btn_grey);
        s22.setBackgroundResource(R.drawable.btn_grey);
        s23.setBackgroundResource(R.drawable.btn_grey);
        s24.setBackgroundResource(R.drawable.btn_grey);
        s25.setBackgroundResource(R.drawable.btn_grey);
        s26.setBackgroundResource(R.drawable.btn_grey);
        s27.setBackgroundResource(R.drawable.btn_grey);
        s28.setBackgroundResource(R.drawable.background_click);
        s29.setBackgroundResource(R.drawable.background_click);
        s30.setBackgroundResource(R.drawable.background_click);
        s31.setBackgroundResource(R.drawable.background_click);
        s32.setBackgroundResource(R.drawable.background_click);
        s33.setBackgroundResource(R.drawable.background_click);
        s34.setBackgroundResource(R.drawable.background_click);
        s35.setBackgroundResource(R.drawable.background_click);
        s36.setBackgroundResource(R.drawable.background_click);
        s37.setBackgroundResource(R.drawable.background_click);
        s38.setBackgroundResource(R.drawable.background_click);
        s39.setBackgroundResource(R.drawable.background_click);
        s40.setBackgroundResource(R.drawable.background_click);
        s41.setBackgroundResource(R.drawable.background_click);
        s42.setBackgroundResource(R.drawable.background_click);
        s43.setBackgroundResource(R.drawable.background_click);
        s44.setBackgroundResource(R.drawable.background_click);
        s45.setBackgroundResource(R.drawable.background_click);
        s46.setBackgroundResource(R.drawable.background_click);
        s47.setBackgroundResource(R.drawable.background_click);
        s48.setBackgroundResource(R.drawable.background_click);
        s49.setBackgroundResource(R.drawable.btn_grey);
        s50.setBackgroundResource(R.drawable.btn_grey);
        s51.setBackgroundResource(R.drawable.btn_grey);
        s52.setBackgroundResource(R.drawable.btn_grey);
    }

    public void onBackPressed() {
        Intent intent = new Intent(TaiXiuActivity.this, MainActivity.class);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(TaiXiuActivity.this);
            startActivity(intent, options.toBundle());
        } else startActivity(intent);
    }
}
