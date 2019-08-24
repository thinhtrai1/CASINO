package com.example.casino;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.Vector;

public class XiDachActivity extends AppCompatActivity {

    int x, z, botNum, diemA, diemB, diemC, diemD, a1, a2, a3, a4, a5, b1, b2, b3, b4, b5, c1, c2, c3, c4, c5, d1, d2, d3, d4, d5;
    int beforeMoney, moneyA, moneyB = 100000, moneyC = 100000, moneyD = 100000, betB, betC, betD;
    String S, b1S, b2S, b3S, b4S, b5S, c1S, c2S, c3S, c4S, c5S, d1S, d2S, d3S, d4S, d5S;
    TextView tvBeforeMoney, tvMoneyA, tvScoreA, tvMoneyB, tvScoreB, tvMoneyC, tvScoreC, tvMoneyD, tvScoreD, tvBetB, tvBetC, tvBetD;
    TextView a1Tv, a2Tv, a3Tv, a4Tv, a5Tv, b1Tv, b2Tv, b3Tv, b4Tv, b5Tv, c1Tv, c2Tv, c3Tv, c4Tv, c5Tv, d1Tv, d2Tv, d3Tv, d4Tv, d5Tv;
    Button playBtn, botBtn, openBtn, openB, openC, openD;
    boolean checkOpenB = true, checkOpenC = true, checkOpenD = true;
    Random random = new Random();
    Vector vector = new Vector();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xi_dach);

        a1Tv = findViewById(R.id.a1);
        a2Tv = findViewById(R.id.a2);
        a3Tv = findViewById(R.id.a3);
        a4Tv = findViewById(R.id.a4);
        a5Tv = findViewById(R.id.a5);
        b1Tv = findViewById(R.id.b1);
        b2Tv = findViewById(R.id.b2);
        b3Tv = findViewById(R.id.b3);
        b4Tv = findViewById(R.id.b4);
        b5Tv = findViewById(R.id.b5);
        c1Tv = findViewById(R.id.c1);
        c2Tv = findViewById(R.id.c2);
        c3Tv = findViewById(R.id.c3);
        c4Tv = findViewById(R.id.c4);
        c5Tv = findViewById(R.id.c5);
        d1Tv = findViewById(R.id.d1);
        d2Tv = findViewById(R.id.d2);
        d3Tv = findViewById(R.id.d3);
        d4Tv = findViewById(R.id.d4);
        d5Tv = findViewById(R.id.d5);
        botBtn = findViewById(R.id.bot_btn);
        playBtn = findViewById(R.id.play_btn);
        openBtn = findViewById(R.id.open_all_btn);
        openB = findViewById(R.id.open_b);
        openC = findViewById(R.id.open_c);
        openD = findViewById(R.id.open_d);
        tvBeforeMoney = findViewById(R.id.tv_before_money);
        tvMoneyA = findViewById(R.id.money_a);
        tvMoneyB = findViewById(R.id.money_b);
        tvMoneyC = findViewById(R.id.money_c);
        tvMoneyD = findViewById(R.id.money_d);
        tvScoreA = findViewById(R.id.score_a);
        tvScoreB = findViewById(R.id.score_b);
        tvScoreC = findViewById(R.id.score_c);
        tvScoreD = findViewById(R.id.score_d);
        tvBetB = findViewById(R.id.bet_b);
        tvBetC = findViewById(R.id.bet_c);
        tvBetD = findViewById(R.id.bet_d);

        moneyA = getSharedPreferences("money", MODE_PRIVATE).getInt("money", 500000);
        tvMoneyA.setText("" + moneyA);

        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkOpenB && checkOpenC && checkOpenD) {
                    botNum = 0;
                    vector.clear();
                    beforeMoney = moneyA;
                    tvBeforeMoney.setText("");
                    checkOpenB = false;
                    checkOpenC = false;
                    checkOpenD = false;
                    a3Tv.setVisibility(View.INVISIBLE);
                    a4Tv.setVisibility(View.INVISIBLE);
                    a5Tv.setVisibility(View.INVISIBLE);
                    b3Tv.setVisibility(View.INVISIBLE);
                    b4Tv.setVisibility(View.INVISIBLE);
                    b5Tv.setVisibility(View.INVISIBLE);
                    c3Tv.setVisibility(View.INVISIBLE);
                    c4Tv.setVisibility(View.INVISIBLE);
                    c5Tv.setVisibility(View.INVISIBLE);
                    d3Tv.setVisibility(View.INVISIBLE);
                    d4Tv.setVisibility(View.INVISIBLE);
                    d5Tv.setVisibility(View.INVISIBLE);
                    b1Tv.setText("♠♣");
                    b2Tv.setText("♠♣");
                    b3Tv.setText("♠♣");
                    b4Tv.setText("♠♣");
                    b5Tv.setText("♠♣");
                    c1Tv.setText("♠\n♡");
                    c2Tv.setText("♠\n♡");
                    c3Tv.setText("♠\n♡");
                    c4Tv.setText("♠\n♡");
                    c5Tv.setText("♠\n♡");
                    d1Tv.setText("♣♠");
                    d2Tv.setText("♣♠");
                    d3Tv.setText("♣♠");
                    d4Tv.setText("♣♠");
                    d5Tv.setText("♣♠");
                    tvScoreB.setText("?");
                    tvScoreC.setText("?");
                    tvScoreD.setText("?");

                    start();

                    CountDownTimer countDownTimer = new CountDownTimer(500, 500) {
                        @Override
                        public void onTick(long l) {
                        }

                        @Override
                        public void onFinish() {
                            bot();
                        }
                    };
                    countDownTimer.start();
                } else Toast.makeText(XiDachActivity.this, "Chưa OPEN", Toast.LENGTH_SHORT).show();
            }
        });

        botBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (a1!=0){
                    botNum++;
                    bot_nha_cai();
                }
            }
        });

        openBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (diemA < 16 && diemA > 0)
                    Toast.makeText(XiDachActivity.this, "Chưa đủ tuổi 16", Toast.LENGTH_SHORT).show();
                else {
                    openB();
                    openC();
                    openD();
                }
            }
        });

        openB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (diemA < 16 && diemA > 0)
                    Toast.makeText(XiDachActivity.this, "Chưa đủ tuổi 16", Toast.LENGTH_SHORT).show();
                else openB();
            }
        });
        openC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (diemA < 16 && diemA > 0)
                    Toast.makeText(XiDachActivity.this, "Chưa đủ tuổi 16", Toast.LENGTH_SHORT).show();
                else openC();
            }
        });
        openD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (diemA < 16 && diemA > 0)
                    Toast.makeText(XiDachActivity.this, "Chưa đủ tuổi 16", Toast.LENGTH_SHORT).show();
                else openD();
            }
        });
    }

    void start() {
        betB = (random.nextInt(10) + 1) * 1000;
        betC = (random.nextInt(10) + 1) * 1000;
        betD = (random.nextInt(10) + 1) * 1000;
        tvBetB.setText("" + betB);
        tvBetC.setText("" + betC);
        tvBetD.setText("" + betD);

        xx();
        a1 = x;
        a1Tv.setText(S);
        xx();
        a2 = x;
        a2Tv.setText(S);
        diemA = a1 + a2;
        tvScoreA.setText("" + diemA);
        if ((a1 == 11 && a2 == 10) || (a1 == 10 && a2 == 11)) {
            tvScoreA.setText("Xì lác");
            diemA = 200;
        } else if (a1 == 11 && a2 == 11) {
            tvScoreA.setText("Xì bàng");
            diemA = 300;
        }

        xx();
        b1 = x;
        b1S = S;
        xx();
        b2 = x;
        b2S = S;
        xx();
        c1 = x;
        c1S = S;
        xx();
        c2 = x;
        c2S = S;
        xx();
        d1 = x;
        d1S = S;
        xx();
        d2 = x;
        d2S = S;
    }

    void xx() {
        x = random.nextInt(52);
        if (vector.contains(x)) xx();
        else {
            vector.add(x);
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
                x = 11;
            } else {
                S = "" + (x % 13 + 2);
                x = x % 13 + 2;
            }
        }
    }

    void bot() {
        diemB = b1 + b2;
        if ((b1 == 11 && b2 == 10) || (b1 == 10 && b2 == 11)) {
            tvScoreB.setText("Xì\nlác");
            diemB = 200;
            b1Tv.setText(b1S);
            b2Tv.setText(b2S);
        } else if (b1 == 11 && b2 == 11) {
            tvScoreB.setText("Xì\nbàng");
            diemB = 300;
            b1Tv.setText(b1S);
            b2Tv.setText(b2S);
        } else {
            if (((b1 == 11 || b2 == 11) && diemB < 19) || diemB < 17) {
                xx();
                b3 = x;
                b3S = S;
                b3Tv.setVisibility(View.VISIBLE);
                diemB = diemB + b3;
                if ((b1 == 11 || b2 == 11 || b3 == 11) && diemB == 22) diemB = 21;
                if (((b1 == 11 || b2 == 11 || b3 == 11) && diemB < 19) || ((b1 == 11 || b2 == 11 || b3 == 11) && diemB > 21)
                        || (b1 == 11 && b3 == 11) || (b2 == 11 && b3 == 11) || diemB < 17) {
                    xx();
                    b4 = x;
                    b4S = S;
                    b4Tv.setVisibility(View.VISIBLE);
                    diemB = diemB + b4;
                    if (b1 == 11) diemB = diemB - 10;
                    if (b2 == 11) diemB = diemB - 10;
                    if (b3 == 11) diemB = diemB - 10;
                    if (b4 == 11) diemB = diemB - 10;
                    if (diemB < 17) {
                        xx();
                        b5 = x;
                        b5S = S;
                        b5Tv.setVisibility(View.VISIBLE);
                        if (b5 == 11) b5 = 1;
                        diemB = diemB + b5;
                        if (diemB < 22) {
                            diemB = diemB + 100;
                        }
                    }
                }
            }
        }

        diemC = c1 + c2;
        if ((c1 == 11 && c2 == 10) || (c1 == 10 && c2 == 11)) {
            tvScoreC.setText("Xì\nlác");
            diemC = 200;
            c1Tv.setText(c1S);
            c2Tv.setText(c2S);
        } else if (c1 == 11 && c2 == 11) {
            tvScoreC.setText("Xì\nbàng");
            diemC = 300;
            c1Tv.setText(c1S);
            c2Tv.setText(c2S);
        } else {
            if (((c1 == 11 || c2 == 11) && diemC < 19) || diemC < 17) {
                xx();
                c3 = x;
                c3S = S;
                c3Tv.setVisibility(View.VISIBLE);
                diemC = diemC + c3;
                if ((c1 == 11 || c2 == 11 || c3 == 11) && diemC == 22) diemC = 21;
                if (((c1 == 11 || c2 == 11 || c3 == 11) && diemC < 19) || ((c1 == 11 || c2 == 11 || c3 == 11) && diemC > 21)
                        || (c1 == 11 && c3 == 11) || (c2 == 11 && c3 == 11) || diemC < 17) {
                    xx();
                    c4 = x;
                    c4S = S;
                    c4Tv.setVisibility(View.VISIBLE);
                    diemC = diemC + c4;
                    if (c1 == 11) diemC = diemC - 10;
                    if (c2 == 11) diemC = diemC - 10;
                    if (c3 == 11) diemC = diemC - 10;
                    if (c4 == 11) diemC = diemC - 10;
                    if (diemC < 18) {
                        xx();
                        c5 = x;
                        c5S = S;
                        c5Tv.setVisibility(View.VISIBLE);
                        if (c5 == 11) c5 = 1;
                        diemC = diemC + c5;
                        if (diemC < 22) {
                            diemC = diemC + 100;
                        }
                    }
                }
            }
        }

        diemD = d1 + d2;
        if ((d1 == 11 && d2 == 10) || (d1 == 10 && d2 == 11)) {
            tvScoreD.setText("Xì\nlác");
            diemD = 200;
            d1Tv.setText(d1S);
            d2Tv.setText(d2S);
        } else if (d1 == 11 && d2 == 11) {
            tvScoreD.setText("Xì\nbàng");
            diemD = 300;
            d1Tv.setText(d1S);
            d2Tv.setText(d2S);
        } else {
            if (((d1 == 11 || d2 == 11) && diemD < 19) || diemD < 17) {
                xx();
                d3 = x;
                d3S = S;
                d3Tv.setVisibility(View.VISIBLE);
                diemD = diemD + d3;
                if ((d1 == 11 || d2 == 11 || d3 == 11) && diemD == 22) diemD = 21;
                if (((d1 == 11 || d2 == 11 || d3 == 11) && diemD < 19) || ((d1 == 11 || d2 == 11 || d3 == 11) && diemD > 21)
                        || (d1 == 11 && d3 == 11) || (d2 == 11 && d3 == 11) || diemD < 17) {
                    xx();
                    d4 = x;
                    d4S = S;
                    d4Tv.setVisibility(View.VISIBLE);
                    diemD = diemD + d4;
                    if (d1 == 11) diemD = diemD - 10;
                    if (d2 == 11) diemD = diemD - 10;
                    if (d3 == 11) diemD = diemD - 10;
                    if (d4 == 11) diemD = diemD - 10;
                    if (diemD < 17) {
                        xx();
                        d5 = x;
                        d5S = S;
                        d5Tv.setVisibility(View.VISIBLE);
                        if (d5 == 11) d5 = 1;
                        diemD = diemD + d5;
                        if (diemD < 22) {
                            diemD = diemD + 100;
                        }
                    }
                }
            }
        }
    }

    void bot_nha_cai() {
        xx();
        if ((botNum == 1) && (a1 != 11 || a2 != 10) && (a1 != 10 || a2 != 11)) {
            a3 = x;
            a3Tv.setText(S);
            a3Tv.setVisibility(View.VISIBLE);
            diemA = diemA + a3;
            if ((a1 == 11 || a2 == 11 || a3 == 11) && diemA == 22) diemA = 21;
            tvScoreA.setText("" + diemA);
        } else if (botNum == 2 && (diemA < 22 || ((a1 == 11 || a2 == 11 || a3 == 11) && diemA > 21))
                && (a1 != 11 || a2 != 10) && (a1 != 10 || a2 != 11)) {
            a4 = x;
            a4Tv.setText(S);
            a4Tv.setVisibility(View.VISIBLE);
            diemA = diemA + a4;
            if (a1 == 11) diemA = diemA - 10;
            if (a2 == 11) diemA = diemA - 10;
            if (a3 == 11) diemA = diemA - 10;
            if (a4 == 11) diemA = diemA - 10;
            tvScoreA.setText("" + diemA);
        } else if (botNum == 3 && diemA < 22) {
            a5 = x;
            a5Tv.setText(S);
            a5Tv.setVisibility(View.VISIBLE);
            if (a5 == 11) a5 = 1;
            diemA = diemA + a5;
            tvScoreA.setText("" + diemA);
            if (diemA < 22) {
                tvScoreA.setText("Ngũ linh " + diemA);
                diemA = diemA + 100;
            }
        }

        if (diemA > 21 && diemA < 100) {
            tvScoreA.setText("Quắc " + diemA);
        }
    }

    void openB() {
        z = diemA;
        if (diemA > 21 && diemA < 100) {
            diemA = 0;
        }
        if (!checkOpenB) {
            b1Tv.setText(b1S);
            b2Tv.setText(b2S);
            b3Tv.setText(b3S);
            b4Tv.setText(b4S);
            b5Tv.setText(b5S);
            if (diemB > 21 && diemB < 100) {
                tvScoreB.setText("Quắc");
                diemB = 0;
            } else if (diemB > 100 && diemB < 200) {
                tvScoreB.setText("Ngũ\nlinh\n" + diemB % 100);
            } else if (diemB < 22) tvScoreB.setText("" + diemB);

            if (diemA > 100 && diemA < 200 && diemB > 100 && diemB < 200) {
                if (diemA < diemB) {
                    moneyA = moneyA + betB;
                    moneyB = moneyB - betB;
                } else if (diemA > diemB) {
                    moneyA = moneyA - betB;
                    moneyB = moneyB + betB;
                }
            } else if (diemA > diemB) {
                moneyA = moneyA + betB;
                moneyB = moneyB - betB;
            } else if (diemA < diemB) {
                moneyA = moneyA - betB;
                moneyB = moneyB + betB;
            }
            tvMoneyA.setText("" + moneyA);
            tvMoneyB.setText("" + moneyB);
            checkOpenB = true;
            diemA = z;
            if (checkOpenC && checkOpenD) {
                if (beforeMoney > moneyA) tvBeforeMoney.setText("-" + (beforeMoney - moneyA));
                else tvBeforeMoney.setText("+" + (moneyA - beforeMoney));
                getSharedPreferences("money", MODE_PRIVATE).edit().putInt("money", moneyA).apply();
            }
        }
    }

    void openC() {
        z = diemA;
        if (diemA > 21 && diemA < 100) {
            diemA = 0;
        }
        if (!checkOpenC) {
            c1Tv.setText(c1S);
            c2Tv.setText(c2S);
            c3Tv.setText(c3S);
            c4Tv.setText(c4S);
            c5Tv.setText(c5S);
            if (diemC > 21 && diemC < 100) {
                tvScoreC.setText("Quắc");
                diemC = 0;
            } else if (diemC > 100 && diemC < 200) {
                tvScoreC.setText("Ngũ linh\n" + diemC % 100);
            } else if (diemC < 22) tvScoreC.setText("" + diemC);

            if (diemA > 100 && diemA < 200 && diemC > 100 && diemC < 200) {
                if (diemA < diemC) {
                    moneyA = moneyA + betC;
                    moneyC = moneyC - betC;
                } else if (diemA > diemC) {
                    moneyA = moneyA - betC;
                    moneyC = moneyC + betC;
                }
            } else if (diemA > diemC) {
                moneyA = moneyA + betC;
                moneyC = moneyC - betC;
            } else if (diemA < diemC) {
                moneyA = moneyA - betC;
                moneyC = moneyC + betC;
            }
            tvMoneyA.setText("" + moneyA);
            tvMoneyC.setText("" + moneyC);
            checkOpenC = true;
            diemA = z;
            if (checkOpenB && checkOpenD) {
                if (beforeMoney > moneyA) tvBeforeMoney.setText("-" + (beforeMoney - moneyA));
                else tvBeforeMoney.setText("+" + (moneyA - beforeMoney));
                getSharedPreferences("money", MODE_PRIVATE).edit().putInt("money", moneyA).apply();
            }
        }
    }

    void openD() {
        z = diemA;
        if (diemA > 21 && diemA < 100) {
            diemA = 0;
        }
        if (!checkOpenD) {
            d1Tv.setText(d1S);
            d2Tv.setText(d2S);
            d3Tv.setText(d3S);
            d4Tv.setText(d4S);
            d5Tv.setText(d5S);
            if (diemD > 21 && diemD < 100) {
                tvScoreD.setText("Quắc");
                diemD = 0;
            } else if (diemD > 100 && diemD < 200) {
                tvScoreD.setText("Ngũ\nlinh\n" + diemD % 100);
            } else if (diemD < 22) tvScoreD.setText("" + diemD);

            if (diemA > 100 && diemA < 200 && diemD > 100 && diemD < 200) {
                if (diemA < diemD) {
                    moneyA = moneyA + betD;
                    moneyD = moneyD - betD;
                } else if (diemA > diemD) {
                    moneyA = moneyA - betD;
                    moneyD = moneyD + betD;
                }
            } else if (diemA > diemD) {
                moneyA = moneyA + betD;
                moneyD = moneyD - betD;
            } else if (diemA < diemD) {
                moneyA = moneyA - betD;
                moneyD = moneyD + betD;
            }
            tvMoneyA.setText("" + moneyA);
            tvMoneyD.setText("" + moneyD);
            checkOpenD = true;
            diemA = z;
            if (checkOpenB && checkOpenC) {
                if (beforeMoney > moneyA) tvBeforeMoney.setText("-" + (beforeMoney - moneyA));
                else tvBeforeMoney.setText("+" + (moneyA - beforeMoney));
                getSharedPreferences("money", MODE_PRIVATE).edit().putInt("money", moneyA).apply();
            }
        }
    }

    public void onBackPressed() {
        Intent intent = new Intent(XiDachActivity.this, MainActivity.class);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(XiDachActivity.this);
            startActivity(intent, options.toBundle());
        } else startActivity(intent);
    }

    public void onStop() {
        if (!checkOpenB || !checkOpenC || !checkOpenD) {
            moneyA = moneyA - (betB + betC + betD);
            getSharedPreferences("money", MODE_PRIVATE).edit().putInt("money", moneyA).apply();
        }
        super.onStop();
    }
}
