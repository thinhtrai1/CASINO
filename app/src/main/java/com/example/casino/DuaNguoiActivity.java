package com.example.casino;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.transition.Explode;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Random;

public class DuaNguoiActivity extends AppCompatActivity {

    SeekBar sb1, sb2, sb3, sb4, sb5, sb6, sb7;
    Button play;
    TextView textView, tvMoney, tvName;
    Spinner betSpinner;
    CountDownTimer countDownTimer, countDownTimer1;
    int money, bet, select, win;
    boolean isRun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dua_nguoi);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Explode explode = new Explode();
            explode.setDuration(1000);
            getWindow().setEnterTransition(explode);
        }

        sb1 = findViewById(R.id.sb1);
        sb2 = findViewById(R.id.sb2);
        sb3 = findViewById(R.id.sb3);
        sb4 = findViewById(R.id.sb4);
        sb5 = findViewById(R.id.sb5);
        sb6 = findViewById(R.id.sb6);
        sb7 = findViewById(R.id.sb7);
        play = findViewById(R.id.play_btn);
        textView = findViewById(R.id.tv);
        tvMoney = findViewById(R.id.money);
        tvName = findViewById(R.id.name_tv);
        betSpinner = findViewById(R.id.bet_spinner);

        money = getSharedPreferences("money", MODE_PRIVATE).getInt("money", 500000);
        tvMoney.setText("" + money);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.bet_array, android.R.layout.simple_spinner_dropdown_item);
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

        sb1.setProgress(sb1.getMax());
        sb2.setProgress(sb1.getMax());
        sb3.setProgress(sb1.getMax());
        sb4.setProgress(sb1.getMax());
        sb5.setProgress(sb1.getMax());
        sb6.setProgress(sb1.getMax());
        sb7.setProgress(sb1.getMax());

        countDownTimer = new CountDownTimer(100000, 100) {
            @Override
            public void onTick(long l) {
                Random random = new Random();
                sb1.setProgress(sb1.getProgress() - random.nextInt(50));
                sb2.setProgress(sb2.getProgress() - random.nextInt(50));
                sb3.setProgress(sb3.getProgress() - random.nextInt(50));
                sb4.setProgress(sb4.getProgress() - random.nextInt(50));
                sb5.setProgress(sb5.getProgress() - random.nextInt(50));
                sb6.setProgress(sb6.getProgress() - random.nextInt(50));
                sb7.setProgress(sb7.getProgress() - random.nextInt(50));

                if (sb1.getProgress() <= 0) {
                    this.cancel();
                    win = 1;
                    done();
                }
                if (sb2.getProgress() <= 0) {
                    this.cancel();
                    win = 2;
                    done();
                }
                if (sb3.getProgress() <= 0) {
                    this.cancel();
                    win = 3;
                    done();
                }
                if (sb4.getProgress() <= 0) {
                    this.cancel();
                    win = 4;
                    done();
                }
                if (sb5.getProgress() <= 0) {
                    this.cancel();
                    win = 5;
                    done();
                }
                if (sb6.getProgress() <= 0) {
                    this.cancel();
                    win = 6;
                    done();
                }
                if (sb7.getProgress() <= 0) {
                    this.cancel();
                    win = 7;
                    done();
                }
            }

            @Override
            public void onFinish() {

            }
        };
        countDownTimer1 = new CountDownTimer(2500, 500) {
            @Override
            public void onTick(long l) {
                textView.setText("" + (l / 500 - 1));
                if (l / 500 == 1) {
                    textView.setText("Go!");
                    this.cancel();
                    countDownTimer.start();
                    isRun = true;
                }
            }

            @Override
            public void onFinish() {
            }
        };

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (select == 0) tvName.setText("");
                else {
                    money = money - bet;
                    tvMoney.setText("" + money);
                    getSharedPreferences("money", MODE_PRIVATE).edit().putInt("money", money).apply();
                }
                countDownTimer.cancel();
                sb1.setProgress(sb1.getMax());
                sb2.setProgress(sb1.getMax());
                sb3.setProgress(sb1.getMax());
                sb4.setProgress(sb1.getMax());
                sb5.setProgress(sb1.getMax());
                sb6.setProgress(sb1.getMax());
                sb7.setProgress(sb1.getMax());

                countDownTimer1.start();
                getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                        WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
            }
        });
    }

    public void selectClick(View view) {
        switch (view.getId()) {
            case R.id.garen:
                tvName.setText("GAREN");
                select = 1;
                break;
            case R.id.diana:
                tvName.setText("DIANA");
                select = 2;
                break;
            case R.id.darius:
                tvName.setText("DARIUS");
                select = 3;
                break;
            case R.id.caitlyn:
                tvName.setText("CAITLYN");
                select = 4;
                break;
            case R.id.jarvan:
                tvName.setText("JARVAN");
                select = 5;
                break;
            case R.id.katarina:
                tvName.setText("KATARINA");
                select = 6;
                break;
            case R.id.draven:
                tvName.setText("DRAVEN");
                select = 7;
                break;
        }
        tvName.setTextColor(Color.WHITE);
    }

    void done() {
        if (isRun == true) {
            if (win == 1) textView.setText("GAREN WIN");
            else if (win == 2) textView.setText("DIANA WIN");
            else if (win == 3) textView.setText("DARIUS WIN");
            else if (win == 4) textView.setText("CAITLYN WIN");
            else if (win == 5) textView.setText("JARVAN WIN");
            else if (win == 6) textView.setText("KATARINA WIN");
            else if (win == 7) textView.setText("DRAVEN WIN");
            if (select != 0) {
                if (select == win) {
                    money = money + bet * 6;
                    tvMoney.setText("" + money);
                    getSharedPreferences("money", MODE_PRIVATE).edit().putInt("money", money).apply();
                    tvName.setTextColor(Color.RED);
                } else tvName.setTextColor(Color.parseColor("#999999"));
            }
            select = 0;
            isRun = false;
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
        }
    }

    public void onStop() {
        countDownTimer.cancel();
        countDownTimer1.cancel();
        super.onStop();
    }

    public void onBackPressed() {
        Intent intent = new Intent(DuaNguoiActivity.this, MainActivity.class);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(DuaNguoiActivity.this);
            startActivity(intent, options.toBundle());
        } else startActivity(intent);
    }
}

@SuppressLint("AppCompatCustomView")
class VerticalSeekBar extends SeekBar {

    public VerticalSeekBar(Context context) {
        super(context);
    }

    public VerticalSeekBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public VerticalSeekBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(h, w, oldh, oldw);
    }

    @Override
    public synchronized void setProgress(int progress) {
        super.setProgress(progress);
        onSizeChanged(getWidth(), getHeight(), 0, 0);
    }

    @Override
    protected synchronized void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(heightMeasureSpec, widthMeasureSpec);
        setMeasuredDimension(getMeasuredHeight(), getMeasuredWidth());
    }

    protected void onDraw(Canvas c) {
        c.rotate(-90);
        c.translate(-getHeight(), 0);
        super.onDraw(c);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (!isEnabled()) {
            return false;
        }
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_MOVE:
            case MotionEvent.ACTION_UP:
                setProgress(getMax() - (int) (getMax() * event.getY() / getHeight()));
                onSizeChanged(getWidth(), getHeight(), 0, 0);
                break;

            case MotionEvent.ACTION_CANCEL:
                break;
        }
        return true;
    }
}
