package com.example.casino;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Random;
import java.util.Vector;

public class BaiCaoActivity extends AppCompatActivity {
    TextView a1Tv, a2Tv, a3Tv, b1Tv, b2Tv, b3Tv, c1Tv, c2Tv, c3Tv, d1Tv, d2Tv, d3Tv,
            tvMoneyBefore, tvMoney, tvScore, tvMoneyB, tvScoreB, tvMoneyC, tvScoreC, tvMoneyD, tvScoreD, chatA, chatB, chatC, chatD;
    Button btnStart, btnTo, btnUp, btnTheo;
    Spinner toSpinner;
    int x, bet = 5000, to, to_num, to_mem, win, maxA, maxB, maxC, maxD, macA, macB, macC, macD, madA, madB, madC, madD,
            beforeMoney, money, moneyB = 300000, moneyC = 300000, moneyD = 300000, diemA, diemB, diemC, diemD,
            a1, a2, a3, b1, b2, b3, c1, c2, c3, d1, d2, d3;
    String S, s, b1S, b2S, b3S, c1S, c2S, c3S, d1S, d2S, d3S;
    Random random = new Random();
    Vector vector = new Vector();
    boolean theoA, theoB, theoC, theoD;
    CountDownTimer countDownTimer50, countDownTimerToB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai_cao);

        toSpinner = findViewById(R.id.bet_spinner);
        a1Tv = findViewById(R.id.a1);
        a2Tv = findViewById(R.id.a2);
        a3Tv = findViewById(R.id.a3);
        b1Tv = findViewById(R.id.b1);
        b2Tv = findViewById(R.id.b2);
        b3Tv = findViewById(R.id.b3);
        c1Tv = findViewById(R.id.c1);
        c2Tv = findViewById(R.id.c2);
        c3Tv = findViewById(R.id.c3);
        d1Tv = findViewById(R.id.d1);
        d2Tv = findViewById(R.id.d2);
        d3Tv = findViewById(R.id.d3);
        tvMoneyBefore = findViewById(R.id.tv_before_money);
        tvMoney = findViewById(R.id.money);
        tvMoneyB = findViewById(R.id.money_b);
        tvMoneyC = findViewById(R.id.money_c);
        tvMoneyD = findViewById(R.id.money_d);
        tvScore = findViewById(R.id.score);
        tvScoreB = findViewById(R.id.score_b);
        tvScoreC = findViewById(R.id.score_c);
        tvScoreD = findViewById(R.id.score_d);
        chatA = findViewById(R.id.chat_a);
        chatB = findViewById(R.id.chat_b);
        chatC = findViewById(R.id.chat_c);
        chatD = findViewById(R.id.chat_d);
        btnStart = findViewById(R.id.start_btn);
        btnTo = findViewById(R.id.to_btn);
        btnTheo = findViewById(R.id.theo_btn);
        btnUp = findViewById(R.id.up_btn);

        money = getSharedPreferences("money", MODE_PRIVATE).getInt("money", 500000);
        tvMoney.setText("" + money);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter
                .createFromResource(this, R.array.to_array, android.R.layout.simple_spinner_dropdown_item);
        toSpinner.setAdapter(adapter);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnStart.setEnabled(false);
                tvMoneyBefore.setText("");
                to = win = to_num = to_mem = 0;
                beforeMoney = money;
                vector.removeAllElements();
                theoA = theoB = theoC = theoD = false;
                diemA = diemB = diemC = diemD = madA = madB = madC = madD = 0;
                tvScore.setBackgroundResource(R.drawable.background_score);
                tvScoreB.setBackgroundResource(R.drawable.background_score);
                tvScoreC.setBackgroundResource(R.drawable.background_score);
                tvScoreD.setBackgroundResource(R.drawable.background_score);
                tvScoreB.setText("?");
                tvScoreC.setText("?");
                tvScoreD.setText("?");
                b1Tv.setText("♡♡");
                b2Tv.setText("♡♡");
                b3Tv.setText("♡♡");
                c1Tv.setText("♢\n♢");
                c2Tv.setText("♢\n♢");
                c3Tv.setText("♢\n♢");
                d1Tv.setText("♣♣");
                d2Tv.setText("♣♣");
                d3Tv.setText("♣♣");
                chatA.setText("");
                chatB.setText("");
                chatC.setText("");
                chatD.setText("");
                start();
                startB();
                startC();
                startD();
                money = money - bet;
                moneyB = moneyB - bet;
                moneyC = moneyC - bet;
                moneyD = moneyD - bet;
                tvMoney.setText("" + money);
                tvMoneyB.setText("" + moneyB);
                tvMoneyC.setText("" + moneyC);
                tvMoneyD.setText("" + moneyD);
                countDownTimer50 = new CountDownTimer(500, 500) {
                    @Override
                    public void onTick(long l) {

                    }

                    @Override
                    public void onFinish() {
                        int st = random.nextInt(4);
                        if (st == 0) {
                            btnTo.setEnabled(true);
                            btnUp.setEnabled(true);
                            if (diemA > 900000) toSpinner.setSelection(4);
                            if (diemA > 800000 && diemA < 900000) toSpinner.setSelection(3);
                            if (diemA > 700000 && diemA < 800000) toSpinner.setSelection(2);
                            if (diemA > 600000 && diemA < 700000) toSpinner.setSelection(1);
                            if (diemA < 600000) toSpinner.setSelection(0);
                        } else if (st == 1) toB();
                        else if (st == 2) toC();
                        else if (st == 3) toD();
                    }
                };
                countDownTimer50.start();
                countDownTimerToB = new CountDownTimer(500, 500) {
                    @Override
                    public void onTick(long l) {

                    }

                    @Override
                    public void onFinish() {
                        toB();
                    }
                };
            }
        });
        btnTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnTo.setEnabled(false);
                btnUp.setEnabled(false);
                to_num++;
                to_mem++;
                theoA = true;
                if (toSpinner.getSelectedItemPosition() == 0) to = 2000;
                else if (toSpinner.getSelectedItemPosition() == 1) to = 4000;
                else if (toSpinner.getSelectedItemPosition() == 2) to = 6000;
                else if (toSpinner.getSelectedItemPosition() == 3) to = 8000;
                else if (toSpinner.getSelectedItemPosition() == 4) to = 10000;
                money = money - to;
                tvMoney.setText("" + money);
                chatA.setText(" Tố " + to + " ");
                countDownTimerToB.start();
            }
        });
        btnTheo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnTheo.setEnabled(false);
                btnUp.setEnabled(false);
                to_mem++;
                to_num++;
                theoA = true;
                money = money - to;
                tvMoney.setText("" + money);
                chatA.setText(" Theo ");
                countDownTimerToB.start();
            }
        });
        btnUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnTheo.setEnabled(false);
                btnTo.setEnabled(false);
                btnUp.setEnabled(false);
                chatA.setText(" Úp ");
                to_num++;
                countDownTimerToB.start();
            }
        });
    }

    void start() {
        a1 = random.nextInt(52);
        vector.add(a1);
        a2 = random.nextInt(52);
        if (vector.contains(a2)) start();
        else {
            vector.add(a2);
            a3 = random.nextInt(52);
            if (vector.contains(a3)) start();
            else {
                vector.add(a3);
                maxA = a1 % 13 + 2;
                macA = a1 / 13;
                if (a2 % 13 + 2 > maxA) {
                    maxA = a2 % 13 + 2;
                    macA = a2 / 13;
                } else if (a2 % 13 + 2 == maxA && a2 / 13 > maxA / 13) {
                    maxA = a2 % 13 + 2;
                    macA = a2 / 13;
                }
                if (a3 % 13 + 2 > maxA) {
                    maxA = a3 % 13 + 2;
                    macA = a3 / 13;
                } else if (a3 % 13 + 2 == maxA && a3 / 13 > maxA / 13) {
                    maxA = a3 % 13 + 2;
                    macA = a3 / 13;
                }
                if (a1 % 13 + 2 == a2 % 13 + 2 || a1 % 13 + 2 == a3 % 13 + 2) madA = a1 % 13 + 2;
                if (a2 % 13 + 2 == a3 % 13 + 2) madA = a2 % 13 + 2;

                if ((a1 % 13 + 2) == (a2 % 13 + 2) && (a2 % 13 + 2) == (a3 % 13 + 2)) {
                    x = a1;
                    xx();
                    if (S.length() == 2)
                        tvScore.setText("Cù 10");
                    else tvScore.setText("Cù " + S.charAt(0));
                    diemA = 3000000 + (madA * 1000) + (maxA * 10);
                } else if (a1 % 13 + 2 > 10 && a1 % 13 + 2 < 14
                        && a2 % 13 + 2 > 10 && a2 % 13 + 2 < 14 && a3 % 13 + 2 > 10 && a3 % 13 + 2 < 14) {
                    tvScore.setText("Ba Tiên");
                    diemA = 2000000 + (madA * 1000) + (maxA * 10) + macA;
                }
                x = a1;
                xx();
                a1 = x;
                a1Tv.setText(S + "\n" + s);
                x = a2;
                xx();
                a2 = x;
                a2Tv.setText(S + "\n" + s);
                x = a3;
                xx();
                a3 = x;
                a3Tv.setText(S + "\n" + s);
                if (diemA < 2000000) {
                    diemA = (a1 + a2 + a3) % 10;
                    if (diemA == 0) tvScore.setText("Bù");
                    else tvScore.setText("" + diemA);
                    diemA = ((a1 + a2 + a3) % 10) * 100000 + (madA * 1000) + maxA * 10 + macA;
                }
            }
        }
    }

    void startB() {
        b1 = random.nextInt(52);
        if (vector.contains(b1)) startB();
        else {
            vector.add(b1);
            b2 = random.nextInt(52);
            if (vector.contains(b2)) startB();
            else {
                vector.add(b2);
                b3 = random.nextInt(52);
                if (vector.contains(b3)) startB();
                else {
                    vector.add(b3);
                    maxB = b1 % 13 + 2;
                    macB = b1 / 13;
                    if (b2 % 13 + 2 > maxB) {
                        maxB = b2 % 13 + 2;
                        macB = b2 / 13;
                    } else if (b2 % 13 + 2 == maxB && b2 / 13 > maxB / 13) {
                        maxB = b2 % 13 + 2;
                        macB = b2 / 13;
                    }
                    if (b3 % 13 + 2 > maxB) {
                        maxB = b3 % 13 + 2;
                        macB = b3 / 13;
                    } else if (b3 % 13 + 2 == maxB && b3 / 13 > maxB / 13) {
                        maxB = b3 % 13 + 2;
                        macB = b3 / 13;
                    }
                    if (b1 % 13 + 2 == b2 % 13 + 2 || b1 % 13 + 2 == b3 % 13 + 2)
                        madB = b1 % 13 + 2;
                    if (b2 % 13 + 2 == b3 % 13 + 2) madB = b2 % 13 + 2;

                    if ((b1 % 13 + 2) == (b2 % 13 + 2) && (b2 % 13 + 2) == (b3 % 13 + 2)) {
                        diemB = 3000000 + (madB * 1000) + (maxB * 10);
                    } else if (b1 % 13 + 2 > 10 && b1 % 13 + 2 < 14
                            && b2 % 13 + 2 > 10 && b2 % 13 + 2 < 14 && b3 % 13 + 2 > 10 && b3 % 13 + 2 < 14) {
                        diemB = 2000000 + (madB * 1000) + (maxB * 10) + macB;
                    }
                    x = b1;
                    xx();
                    b1 = x;
                    b1S = S + s;
                    x = b2;
                    xx();
                    b2 = x;
                    b2S = S + s;
                    x = b3;
                    xx();
                    b3 = x;
                    b3S = S + s;
                    if (diemB < 2000000) {
                        diemB = ((b1 + b2 + b3) % 10) * 100000 + (madB * 1000) + maxB * 10 + macB;
                    }
                }
            }
        }
    }

    void startC() {
        c1 = random.nextInt(52);
        if (vector.contains(c1)) startC();
        else {
            vector.add(c1);
            c2 = random.nextInt(52);
            if (vector.contains(c2)) startC();
            else {
                vector.add(c2);
                c3 = random.nextInt(52);
                if (vector.contains(c3)) startC();
                else {
                    vector.add(c3);
                    maxC = c1 % 13 + 2;
                    macC = c1 / 13;
                    if (c2 % 13 + 2 > maxC) {
                        maxC = c2 % 13 + 2;
                        macC = c2 / 13;
                    } else if (c2 % 13 + 2 == maxC && c2 / 13 > maxC / 13) {
                        maxC = c2 % 13 + 2;
                        macC = c2 / 13;
                    }
                    if (c3 % 13 + 2 > maxC) {
                        maxC = c3 % 13 + 2;
                        macC = c3 / 13;
                    } else if (c3 % 13 + 2 == maxC && c3 / 13 > maxC / 13) {
                        maxC = c3 % 13 + 2;
                        macC = c3 / 13;
                    }
                    if (c1 % 13 + 2 == c2 % 13 + 2 || c1 % 13 + 2 == c3 % 13 + 2)
                        madC = c1 % 13 + 2;
                    if (c2 % 13 + 2 == c3 % 13 + 2) madC = c2 % 13 + 2;

                    if ((c1 % 13 + 2) == (c2 % 13 + 2) && (c2 % 13 + 2) == (c3 % 13 + 2)) {
                        diemC = 3000000 + (madC * 1000) + (maxC * 10);
                    } else if (c1 % 13 + 2 > 10 && c1 % 13 + 2 < 14
                            && c2 % 13 + 2 > 10 && c2 % 13 + 2 < 14 && c3 % 13 + 2 > 10 && c3 % 13 + 2 < 14) {
                        diemC = 2000000 + (madC * 1000) + (maxC * 10) + macC;
                    }
                    x = c1;
                    xx();
                    c1 = x;
                    c1S = S + "\n" + s;
                    x = c2;
                    xx();
                    c2 = x;
                    c2S = S + "\n" + s;
                    x = c3;
                    xx();
                    c3 = x;
                    c3S = S + "\n" + s;
                    if (diemC < 2000000) {
                        diemC = ((c1 + c2 + c3) % 10) * 100000 + (madC * 1000) + maxC * 10 + macC;
                    }
                }
            }
        }
    }

    void startD() {
        d1 = random.nextInt(52);
        if (vector.contains(d1)) startD();
        else {
            vector.add(d1);
            d2 = random.nextInt(52);
            if (vector.contains(d2)) startD();
            else {
                vector.add(d2);
                d3 = random.nextInt(52);
                if (vector.contains(d3)) startD();
                else {
                    vector.add(d3);
                    maxD = d1 % 13 + 2;
                    macD = d1 / 13;
                    if (d2 % 13 + 2 > maxD) {
                        maxD = d2 % 13 + 2;
                        macD = d2 / 13;
                    } else if (d2 % 13 + 2 == maxD && d2 / 13 > maxD / 13) {
                        maxD = d2 % 13 + 2;
                        macD = d2 / 13;
                    }
                    if (d3 % 13 + 2 > maxD) {
                        maxD = d3 % 13 + 2;
                        macD = d3 / 13;
                    } else if (d3 % 13 + 2 == maxD && d3 / 13 > maxD / 13) {
                        maxD = d3 % 13 + 2;
                        macD = d3 / 13;
                    }
                    if (d1 % 13 + 2 == d2 % 13 + 2 || d1 % 13 + 2 == d3 % 13 + 2)
                        madD = d1 % 13 + 2;
                    if (d2 % 13 + 2 == d3 % 13 + 2) madD = d2 % 13 + 2;
                    macD = maxD / 13;

                    if ((d1 % 13 + 2) == (d2 % 13 + 2) && (d2 % 13 + 2) == (d3 % 13 + 2)) {
                        diemD = 3000000 + (madD * 1000) + (maxD * 10);
                    } else if (d1 % 13 + 2 > 10 && d1 % 13 + 2 < 14
                            && d2 % 13 + 2 > 10 && d2 % 13 + 2 < 14 && d3 % 13 + 2 > 10 && d3 % 13 + 2 < 14) {
                        diemD = 2000000 + (madD * 1000) + (maxD * 10) + macD;
                    }
                    x = d1;
                    xx();
                    d1 = x;
                    d1S = S + s;
                    x = d2;
                    xx();
                    d2 = x;
                    d2S = S + s;
                    x = d3;
                    xx();
                    d3 = x;
                    d3S = S + s;
                    if (diemD < 2000000) {
                        diemD = ((d1 + d2 + d3) % 10) * 100000 + (madD * 1000) + maxD * 10 + macD;
                    }
                }
            }
        }
    }

    void xx() {
        if (x / 13 == 0) s = "♠";
        else if (x / 13 == 1) s = "♣";
        else if (x / 13 == 2) s = "♢";
        else if (x / 13 == 3) s = "♡";

        if (x % 13 + 2 == 11) {
            S = "J";
            x = 10;
        } else if (x % 13 + 2 == 12) {
            S = "Q";
            x = 10;
        } else if (x % 13 + 2 == 13) {
            S = "K";
            x = 10;
        } else if (x % 13 + 2 == 14) {
            S = "A";
            x = 1;
        } else {
            S = "" + (x % 13 + 2);
            x = x % 13 + 2;
        }
    }

    void toB() {
        countDownTimer50 = new CountDownTimer(500, 500) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                toC();
            }
        };
        to_num++;
        if (to_num == 5) open();
        else if (to == 0) {
            if (diemB > 600000 || (to_num == 4 && to_mem == 0)) {
                to = 2000 + 2000 * random.nextInt(5);
                moneyB = moneyB - to;
                tvMoneyB.setText("" + moneyB);
                chatB.setText(" Tố " + to + " ");
                theoB = true;
                to_mem++;
            } else if (diemB > 400000 && diemB < 600000
                    && ((random.nextInt(2) == 0 && to_num > 1)) || (random.nextInt(4) == 0 && to_num == 1)) {
                to = 2000 + 2000 * random.nextInt(5);
                moneyB = moneyB - to;
                tvMoneyB.setText("" + moneyB);
                chatB.setText(" Tố " + to + " ");
                theoB = true;
                to_mem++;
            } else if (diemB < 400000 && ((random.nextInt(2) == 0 && to_num > 2) || (random.nextInt(5) == 0 && to_num < 3))) {
                to = 2000 + 2000 * random.nextInt(5);
                moneyB = moneyB - to;
                tvMoneyB.setText("" + moneyB);
                chatB.setText(" Tố " + to + " ");
                theoB = true;
                to_mem++;
            } else chatB.setText(" Úp ");
            countDownTimer50.start();
        } else {
            if (diemB > 800000) {
                moneyB = moneyB - to;
                tvMoneyB.setText("" + moneyB);
                chatB.setText(" Theo ");
                theoB = true;
                to_mem++;
            } else if (diemB > 600000 && diemB < 800000 && (random.nextInt(2) == 0 || to_mem < 3)) {
                moneyB = moneyB - to;
                tvMoneyB.setText("" + moneyB);
                chatB.setText(" Theo ");
                theoB = true;
                to_mem++;
            } else if (diemB > 400000 && diemB < 600000 && ((random.nextInt(5) == 0
                    && to_mem == 1 && to_num == 3) || (random.nextInt(2) == 0 && to_mem == 1 && to_num == 4))) {
                moneyB = moneyB - to;
                tvMoneyB.setText("" + moneyB);
                chatB.setText(" Theo ");
                theoB = true;
                to_mem++;
            } else if (diemB < 400000 && diemB > 100110 && random.nextInt(5) == 0 && to_mem == 1 && to_num == 4 && !theoC) {
                moneyB = moneyB - to;
                tvMoneyB.setText("" + moneyB);
                chatB.setText(" Theo ");
                theoB = true;
                to_mem++;
            } else chatB.setText(" Úp ");
            countDownTimer50.start();
        }
    }

    void toC() {
        countDownTimer50 = new CountDownTimer(500, 500) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                toD();
            }
        };
        to_num++;
        if (to_num == 5) open();
        else if (to == 0) {
            if (diemC > 600000 || (to_num == 4 && to_mem == 0)) {
                to = 2000 + 2000 * random.nextInt(5);
                moneyC = moneyC - to;
                tvMoneyC.setText("" + moneyC);
                chatC.setText(" Tố " + to + " ");
                theoC = true;
                to_mem++;
            } else if (diemC > 400000 && diemC < 600000
                    && ((random.nextInt(2) == 0 && to_num > 1)) || (random.nextInt(4) == 0 && to_num == 1)) {
                to = 2000 + 2000 * random.nextInt(5);
                moneyC = moneyC - to;
                tvMoneyC.setText("" + moneyC);
                chatC.setText(" Tố " + to + " ");
                theoC = true;
                to_mem++;
            } else if (diemC < 400000 && ((random.nextInt(2) == 0 && to_num > 2) || (random.nextInt(5) == 0 && to_num < 3))) {
                to = 2000 + 2000 * random.nextInt(5);
                moneyC = moneyC - to;
                tvMoneyC.setText("" + moneyC);
                chatC.setText(" Tố " + to + " ");
                theoC = true;
                to_mem++;
            } else chatC.setText(" Úp ");
            countDownTimer50.start();
        } else {
            if (diemC > 800000 || (to_num == 4 && to_mem == 0)) {
                moneyC = moneyC - to;
                tvMoneyC.setText("" + moneyC);
                chatC.setText(" Theo ");
                theoC = true;
                to_mem++;
            } else if (diemC > 600000 && diemC < 800000 && (random.nextInt(2) == 0 || to_mem < 3)) {
                moneyC = moneyC - to;
                tvMoneyC.setText("" + moneyC);
                chatC.setText(" Theo ");
                theoC = true;
                to_mem++;
            } else if (diemC > 400000 && diemC < 600000 && ((random.nextInt(5) == 0
                    && to_mem == 1 && to_num == 3) || (random.nextInt(2) == 0 && to_mem == 1 && to_num == 4))) {
                moneyC = moneyC - to;
                tvMoneyC.setText("" + moneyC);
                chatC.setText(" Theo ");
                theoC = true;
                to_mem++;
            } else if (diemC < 400000 && diemC > 100110 && random.nextInt(5) == 0 && to_mem < 2 && to_num > 3 && !theoD) {
                moneyC = moneyC - to;
                tvMoneyC.setText("" + moneyC);
                chatC.setText(" Theo ");
                theoC = true;
                to_mem++;
            } else chatC.setText(" Úp ");
            countDownTimer50.start();
        }
    }

    void toD() {
        to_num++;
        if (to_num == 5) open();
        else if (to == 0) {
            if (diemD > 600000 || (to_num == 4 && to_mem == 0)) {
                to = 2000 + 2000 * random.nextInt(5);
                moneyD = moneyD - to;
                tvMoneyD.setText("" + moneyD);
                chatD.setText(" Tố " + to + " ");
                theoD = true;
                to_mem++;
            } else if (diemD > 400000 && diemD < 600000
                    && ((random.nextInt(2) == 0 && to_num > 1)) || (random.nextInt(4) == 0 && to_num == 1)) {
                to = 2000 + 2000 * random.nextInt(5);
                moneyD = moneyD - to;
                tvMoneyD.setText("" + moneyD);
                chatD.setText(" Tố " + to + " ");
                theoD = true;
                to_mem++;
            } else if (diemD < 400000 && ((random.nextInt(2) == 0 && to_num > 2) || (random.nextInt(5) == 0 && to_num < 3))) {
                to = 2000 + 2000 * random.nextInt(5);
                moneyD = moneyD - to;
                tvMoneyD.setText("" + moneyD);
                chatD.setText(" Tố " + to + " ");
                theoD = true;
                to_mem++;
            } else chatD.setText(" Úp ");
        } else {
            if (diemD > 800000) {
                moneyD = moneyD - to;
                tvMoneyD.setText("" + moneyD);
                chatD.setText(" Theo ");
                theoD = true;
                to_mem++;
            } else if (diemD > 600000 && diemD < 800000 && (random.nextInt(2) == 0 || to_mem < 3)) {
                moneyD = moneyD - to;
                tvMoneyD.setText("" + moneyD);
                chatD.setText(" Theo ");
                theoD = true;
                to_mem++;
            } else if (diemD > 400000 && diemD < 600000 && ((random.nextInt(5) == 0
                    && to_mem < 2 && to_num == 3) || (random.nextInt(2) == 0 && to_mem == 1 && to_num == 4))) {
                moneyD = moneyD - to;
                tvMoneyD.setText("" + moneyD);
                chatD.setText(" Theo ");
                theoD = true;
                to_mem++;
            } else if (diemD < 400000 && diemD > 100110 && random.nextInt(5) == 0 && to_mem < 2 && to_num > 3 && !theoA) {
                moneyD = moneyD - to;
                tvMoneyD.setText("" + moneyD);
                chatD.setText(" Theo ");
                theoD = true;
                to_mem++;
            } else chatD.setText(" Úp ");
        }
        countDownTimer50 = new CountDownTimer(200, 200) {
            @Override
            public void onTick(long l) {
            }

            @Override
            public void onFinish() {
                toA();
            }
        };
        countDownTimer50.start();
    }

    void toA() {
        if (to_num == 4) {
            to_num++;
            open();
        } else if (to_num < 4) {
            btnUp.setEnabled(true);
            if (to_mem == 0) {
                if (diemA > 900000) toSpinner.setSelection(4);
                if (diemA > 800000 && diemA < 900000) toSpinner.setSelection(3);
                if (diemA > 700000 && diemA < 800000) toSpinner.setSelection(2);
                if (diemA > 600000 && diemA < 700000) toSpinner.setSelection(1);
                if (diemA < 600000) toSpinner.setSelection(0);
                btnTo.setEnabled(true);
            } else {
                btnTheo.setEnabled(true);
            }
        }
    }

    void open() {
        b1Tv.setText(b1S);
        b2Tv.setText(b2S);
        b3Tv.setText(b3S);
        if (diemB > 3000000) {
            if (("" + b1S.charAt(0) + b1S.charAt(1)).equals("10"))
                tvScoreB.setText("Cù 10");
            else tvScoreB.setText("Cù " + b1S.charAt(0));
        } else if (diemB > 2000000) tvScoreB.setText("Ba Tiên");
        else {
            if (diemB / 100000 == 0) tvScoreB.setText("Bù");
            else tvScoreB.setText("" + diemB / 100000);
        }
        c1Tv.setText(c1S);
        c2Tv.setText(c2S);
        c3Tv.setText(c3S);
        if (diemC > 3000000) {
            if (("" + c1S.charAt(0) + c1S.charAt(1)).equals("10"))
                tvScoreC.setText("Cù 10");
            else tvScoreC.setText("Cù " + c1S.charAt(0));
        } else if (diemC > 2000000) tvScoreC.setText("Ba Tiên");
        else {
            if (diemC / 100000 == 0) tvScoreC.setText("Bù");
            else tvScoreC.setText("" + diemC / 100000);
        }
        d1Tv.setText(d1S);
        d2Tv.setText(d2S);
        d3Tv.setText(d3S);
        if (diemD > 3000000) {
            if (("" + d1S.charAt(0) + d1S.charAt(1)).equals("10"))
                tvScoreD.setText("Cù 10");
            else tvScoreD.setText("Cù " + d1S.charAt(0));
        } else if (diemD > 2000000) tvScoreD.setText("Ba Tiên");
        else {
            if (diemD / 100000 == 0) tvScoreD.setText("Bù");
            else tvScoreD.setText("" + diemD / 100000);
        }

        if (!theoA && !theoB && !theoC && !theoD) {
            win = diemA;
            if (diemB > win) win = diemB;
            if (diemC > win) win = diemC;
            if (diemD > win) win = diemD;
        } else {
            if (theoA) win = diemA;
            if (diemB > win && theoB) win = diemB;
            if (diemC > win && theoC) win = diemC;
            if (diemD > win && theoD) win = diemD;
        }
        if (diemA == win) {
            money = money + bet * 4 + to * to_mem;
            tvScore.setBackgroundResource(R.drawable.background_score_win);
        } else if (diemB == win) {
            moneyB = moneyB + bet * 4 + to * to_mem;
            tvScoreB.setBackgroundResource(R.drawable.background_score_win);
        } else if (diemC == win) {
            moneyC = moneyC + bet * 4 + to * to_mem;
            tvScoreC.setBackgroundResource(R.drawable.background_score_win);
        } else if (diemD == win) {
            moneyD = moneyD + bet * 4 + to * to_mem;
            tvScoreD.setBackgroundResource(R.drawable.background_score_win);
        }
        if (money > beforeMoney) tvMoneyBefore.setText("+" + (money - beforeMoney));
        else tvMoneyBefore.setText("-" + (beforeMoney - money));
        tvMoney.setText("" + money);
        tvMoneyB.setText("" + moneyB);
        tvMoneyC.setText("" + moneyC);
        tvMoneyD.setText("" + moneyD);
        getSharedPreferences("money", MODE_PRIVATE).edit().putInt("money", money).apply();
        btnStart.setEnabled(true);
    }

    public void onBackPressed() {
        getSharedPreferences("money", MODE_PRIVATE).edit().putInt("money", money).apply();
        Intent intent = new Intent(BaiCaoActivity.this, MainActivity.class);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(BaiCaoActivity.this);
            startActivity(intent, options.toBundle());
        } else startActivity(intent);
    }
}
