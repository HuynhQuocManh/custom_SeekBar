package com.huynhquocmanh.cuoc_dua_ki_thu;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView txtdiem;
    CheckBox cb1, cb2, cb3;
    SeekBar skb1, skb2, skb3;
    ImageButton btnplay;
    int sodiem = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();
        skb1.setEnabled(false);
        skb2.setEnabled(false);
        skb3.setEnabled(false);
        txtdiem.setText(sodiem + "");
        final CountDownTimer countDownTimer = new CountDownTimer(60000, 100) {
            @Override
            public void onTick(long millisUntilFinished) {
                Random randum = new Random();
                int number = 5;
                int one = randum.nextInt(number);
                int two = randum.nextInt(number);
                int three = randum.nextInt(number);
                //kiểm tra win  skb1
                if (skb1.getProgress() >= skb1.getMax()) {
                    this.cancel();
                    btnplay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "Naruto win", Toast.LENGTH_SHORT).show();
                    //kiem tra đặt cược
                    if (cb1.isChecked()) {
                        sodiem = sodiem + 10;
                        Toast.makeText(MainActivity.this, "bạn thắng rồi được công 10 điểm", Toast.LENGTH_SHORT).show();

                    } else {
                        sodiem = sodiem - 5;
                        Toast.makeText(MainActivity.this, "bạn thua rồi bị trừ 5 điểm", Toast.LENGTH_SHORT).show();

                    }
                    txtdiem.setText(sodiem + "");
                    enblecheeckbox();
                }//kiểm tra win  skb2
                if (skb2.getProgress() >= skb2.getMax()) {
                    this.cancel();
                    btnplay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "Kakashi win", Toast.LENGTH_SHORT).show();
                    //kiem tra đặt cược
                    if (cb2.isChecked()) {
                        sodiem = sodiem + 10;
                        Toast.makeText(MainActivity.this, "bạn thắng rồi được công 10 điểm", Toast.LENGTH_SHORT).show();
                    } else {
                        sodiem = sodiem - 5;
                        Toast.makeText(MainActivity.this, "bạn thua rồi bị trừ 5 điểm", Toast.LENGTH_SHORT).show();
                    }
                    txtdiem.setText(sodiem + "");
                    enblecheeckbox();
                }//kiểm tra win  skb3
                if (skb3.getProgress() >= skb3.getMax()) {
                    this.cancel();
                    btnplay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "Sonic win", Toast.LENGTH_SHORT).show();

                    //kiem tra đặt cược
                    if (cb3.isChecked()) {
                        sodiem = sodiem + 10;
                        Toast.makeText(MainActivity.this, "bạn thắng rồi được công 10 điểm", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(MainActivity.this, "bạn thua rồi bị trừ 5 điểm", Toast.LENGTH_SHORT).show();

                        sodiem = sodiem - 5;
                    }
                    txtdiem.setText(sodiem + "");
                    enblecheeckbox();
                }
                skb1.setProgress(skb1.getProgress() + one);
                skb2.setProgress(skb2.getProgress() + two);
                skb3.setProgress(skb3.getProgress() + three);
            }

            @Override
            public void onFinish() {
            }
        };
        btnplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cb1.isChecked() || cb2.isChecked() || cb3.isChecked()) {
                    skb1.setProgress(4);
                    skb2.setProgress(4);
                    skb3.setProgress(4);
                    btnplay.setVisibility(View.INVISIBLE);
                    Disablecheeckbox();
                    countDownTimer.start();
                } else {
                    Toast.makeText(MainActivity.this, "vui lòng đặt cược trước khi chơi", Toast.LENGTH_SHORT).show();
                }

            }
        });
        cb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {
                if (b) {
                    cb2.setChecked(false);
                    cb3.setChecked(false);
                }
            }
        });
        cb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {
                if (b) {
                    cb1.setChecked(false);
                    cb3.setChecked(false);
                }
            }
        });
        cb3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {
                if (b) {
                    cb1.setChecked(false);
                    cb2.setChecked(false);
                }

            }
        });
    }

    private void anhxa() {
        btnplay = (ImageButton) findViewById(R.id.buttonplay);
        txtdiem = (TextView) findViewById(R.id.txtdiemso);
        cb1 = (CheckBox) findViewById(R.id.checkbox1);
        cb2 = (CheckBox) findViewById(R.id.checkbox2);
        cb3 = (CheckBox) findViewById(R.id.checkbox3);
        skb1 = (SeekBar) findViewById(R.id.seekbar1);
        skb2 = (SeekBar) findViewById(R.id.seekbar2);
        skb3 = (SeekBar) findViewById(R.id.seekbar3);
    }

    private void enblecheeckbox() {
        cb1.setEnabled(true);
        cb2.setEnabled(true);
        cb3.setEnabled(true);
    }

    private void Disablecheeckbox() {
        cb1.setEnabled(false);
        cb2.setEnabled(false);
        cb3.setEnabled(false);
    }
}
