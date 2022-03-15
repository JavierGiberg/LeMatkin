package com.example.test;

import android.content.Intent;
import android.content.SharedPreferences;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.Buffer;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    int count,temp0,temp1,temp2,temp3,temp4,temp5,temp6,temp7,temp8,temp9,temp10,temp11
            ,temp12,temp13,temp14,temp15,temp16,temp17,temp18,temp19,temp20,temp21,temp22,temp23,temp24,temp25
            ,special1,special2,finalSpecial,finalCount,divider
            ,RfNew,RfCh,RfEm;
    boolean flag;
    TextView txtview;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences spTotal=getSharedPreferences("details",MODE_PRIVATE);
        SharedPreferences spSpecial=getSharedPreferences("Special",MODE_PRIVATE);

        RfNew=spSpecial.getInt("specialCN",0);
        RfCh=spSpecial.getInt("specialCH",0);
        RfEm=spSpecial.getInt("specialEM",0);
        divider=spTotal.getInt("divider",0);
        flag =true;

        txtview= findViewById(R.id.txt_view);

        Spinner btnSrak=findViewById(R.id.btn_srak);
        Spinner btnNewRf=findViewById(R.id.btn_new_RF);
        Spinner btnChRf=findViewById(R.id.btn_ch_RF);
        Spinner btnEmRf=findViewById(R.id.btn_empty_RF);
        Spinner btnTel=findViewById(R.id.btn_new_tel);
        Spinner btnFixMove=findViewById(R.id.btn_fix_move);
        Spinner btnFix2=findViewById(R.id.btn_fix2);
        Spinner btnFixch=findViewById(R.id.btn_fix2_ch);
        Spinner btnSc=findViewById(R.id.btn_sc);
        Spinner btnUpmodem=findViewById(R.id.btn_up_modem);
        Spinner btnModemCombo=findViewById(R.id.btn_modem_combo);
        Spinner btnIntModem=findViewById(R.id.btn_int_modem);
        Spinner btnUpMini=findViewById(R.id.btn_up_mini);
        Spinner btnUpMemir=findViewById(R.id.btn_up_memir);
        Spinner btnUpFirstMini=findViewById(R.id.btn_up_firs_mini);
        Spinner btnNewMemir=findViewById(R.id.btn_hd_mini);
        Spinner btnFiber4k=findViewById(R.id.btn_4k);
        Spinner btnComplite=findViewById(R.id.btn_complite);
        Spinner btnLidTripel=findViewById(R.id.btn_lid_tripel);
        Spinner btnLidInt=findViewById(R.id.btn_lid_int);
        Spinner btnLidMobile=findViewById(R.id.btn_lid_moblie);
        Spinner btnMineral=findViewById(R.id.btn_mineral);
        Spinner btnSivHitzoni =findViewById(R.id.btn_siv_hitzoni);
        Spinner btnSivPnimi =findViewById(R.id.btn_siv_pnimi);
        Spinner btnSivAfala =findViewById(R.id.btn_siv_afala);

        Button btnFinish =findViewById(R.id.finish_btn);
        Button btnSend = findViewById(R.id.send_btn);
        Button bntCleer =findViewById(R.id.cleen_btn);
        Button btnMinus =findViewById(R.id.btn_minus);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.numbers, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,R.array.numbers1, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);



        btnSrak.setAdapter(adapter1);
        btnSrak.setOnItemSelectedListener(this);
        btnNewRf.setAdapter(adapter);
        btnNewRf.setOnItemSelectedListener(this);
        btnChRf.setAdapter(adapter);
        btnChRf.setOnItemSelectedListener(this);
        btnEmRf.setAdapter(adapter);
        btnEmRf.setOnItemSelectedListener(this);
        btnTel.setAdapter(adapter);
        btnTel.setOnItemSelectedListener(this);
        btnFixMove.setAdapter(adapter);
        btnFixMove.setOnItemSelectedListener(this);
        btnFix2.setAdapter(adapter);
        btnFix2.setOnItemSelectedListener(this);
        btnFixch.setAdapter(adapter);
        btnFixch.setOnItemSelectedListener(this);
        btnSc.setAdapter(adapter1);
        btnSc.setOnItemSelectedListener(this);
        btnUpmodem.setAdapter(adapter);
        btnUpmodem.setOnItemSelectedListener(this);
        btnModemCombo.setAdapter(adapter);
        btnModemCombo.setOnItemSelectedListener(this);
        btnIntModem.setAdapter(adapter);
        btnIntModem.setOnItemSelectedListener(this);
        btnUpMini.setAdapter(adapter);
        btnUpMini.setOnItemSelectedListener(this);
        btnUpMemir.setAdapter(adapter);
        btnUpMemir.setOnItemSelectedListener(this);
        btnUpFirstMini.setAdapter(adapter);
        btnUpFirstMini.setOnItemSelectedListener(this);
        btnNewMemir.setAdapter(adapter);
        btnNewMemir.setOnItemSelectedListener(this);
        btnFiber4k.setAdapter(adapter1);
        btnFiber4k.setOnItemSelectedListener(this);
        btnComplite.setAdapter(adapter1);
        btnComplite.setOnItemSelectedListener(this);
        btnLidTripel.setAdapter(adapter);
        btnLidTripel.setOnItemSelectedListener(this);
        btnLidInt.setAdapter(adapter);
        btnLidInt.setOnItemSelectedListener(this);
        btnLidMobile.setAdapter(adapter);
        btnLidMobile.setOnItemSelectedListener(this);
        btnMineral.setAdapter(adapter);
        btnMineral.setOnItemSelectedListener(this);
        btnSivHitzoni.setAdapter(adapter1);
        btnSivHitzoni.setOnItemSelectedListener(this);
        btnSivPnimi.setAdapter(adapter1);
        btnSivPnimi.setOnItemSelectedListener(this);
        btnSivAfala.setAdapter(adapter1);
        btnSivAfala.setOnItemSelectedListener(this);

        finalCount=spTotal.getInt("count",0);
        finalSpecial=spSpecial.getInt("special",0);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                SharedPreferences.Editor editor=spTotal.edit();
                editor.putInt("count",finalCount);
                editor.commit();

                SharedPreferences.Editor editor1=spSpecial.edit();
                editor1.putInt("special",finalSpecial);
                editor1.commit();

                SharedPreferences.Editor editor2=spSpecial.edit();
                editor2.putInt("specialCN",RfNew);
                editor2.commit();
                SharedPreferences.Editor editor3=spSpecial.edit();
                editor3.putInt("specialCH",RfCh);
                editor3.commit();
                SharedPreferences.Editor editor4=spSpecial.edit();
                editor4.putInt("specialEM",RfEm);
                editor4.commit();
                SharedPreferences.Editor editor5=spTotal.edit();
                editor5.putInt("divider",divider);
                editor5.commit();





                Intent intent =new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);
            }
        });

        bntCleer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             if(flag) {
                 count += temp0 * 12;
                 count += temp1 * 51;
                 special1 += temp1 * 19;
                 count += temp2 * 25;
                 special2 += temp2 * 3;
                 count += temp3 * 0;
                 count += temp4 * 32;
                 count += temp5 * 44;
                 count += temp6 * 70;
                 count += temp7 * 28;
                 count += temp8 * 70;
                 count += temp9 * 28;
                 count += temp10 * 56;
                 count += temp11 * 28;
                 count += temp12 * 66;
                 count += temp13 * 45;
                 count += temp14 * 32;
                 count += temp15 * 28;
                 count += temp16 * 42;
                 count += temp17 * 32;
                 count += temp18 * 100;
                 count += temp19 * 56;
                 count += temp20 * 350;
                 count += temp21 * 70;
                 count += temp22 * 12;
                 count += temp23 * 230;
                 count += temp24 * 100;
                 count += temp25 * 40;

                 txtview.setText("  סכום לא כולל מע'מ:  " + count);
                 finalCount += count;
                 finalSpecial += special1 + special2;

                 RfNew += temp1;
                 RfCh += temp2;
                 RfEm += temp3;
                 divider++;
                 flag=false;
             }
            }
        });
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(flag) {
                    count -= temp0 * 12;
                    count -= temp1 * 51;
                    special1 -= temp1 * 19;
                    count -= temp2 * 25;
                    special2 -= temp2 * 3;
                    count -= temp3 * 0;
                    count -= temp4 * 32;
                    count -= temp5 * 44;
                    count -= temp6 * 70;
                    count -= temp7 * 28;
                    count -= temp8 * 70;
                    count -= temp9 * 28;
                    count -= temp10 * 56;
                    count -= temp11 * 28;
                    count -= temp12 * 66;
                    count -= temp13 * 45;
                    count -= temp14 * 32;
                    count -= temp15 * 28;
                    count -= temp16 * 42;
                    count -= temp17 * 32;
                    count -= temp18 * 100;
                    count -= temp19 * 56;
                    count -= temp20 * 350;
                    count -= temp21 * 70;
                    count -= temp22 * 12;
                    count -= temp23 * 230;
                    count -= temp24 * 100;
                    count -= temp25 * 40;

                    txtview.setText("  סכום לא כולל מע'מ:  " + count);
                    finalCount += count;
                    finalSpecial += (special1 + special2);

                    RfNew -= temp1;
                    RfCh -= temp2;
                    RfEm -= temp3;
                    divider--;
                    flag=false;
                }
            }
        });
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        int temp;
        if(adapterView.getId()==R.id.btn_srak) {
            String txt = adapterView.getItemAtPosition(i).toString();
            temp0=0;
            temp0 = Integer.parseInt(txt);

          //  Toast.makeText(adapterView.getContext(), txt, Toast.LENGTH_SHORT).show();
        }
        if(adapterView.getId()==R.id.btn_new_RF) {
            String txt = adapterView.getItemAtPosition(i).toString();
            temp1=0;
            temp1 = Integer.parseInt(txt);

           // Toast.makeText(adapterView.getContext(), txt, Toast.LENGTH_SHORT).show();
        }
        if(adapterView.getId()==R.id.btn_ch_RF) {
            String txt = adapterView.getItemAtPosition(i).toString();
            temp2=0;
            temp2 = Integer.parseInt(txt);

           // Toast.makeText(adapterView.getContext(), txt, Toast.LENGTH_SHORT).show();
        }
        if(adapterView.getId()==R.id.btn_empty_RF) {
            String txt = adapterView.getItemAtPosition(i).toString();
            temp3=0;
            temp3 = Integer.parseInt(txt);

            //  Toast.makeText(adapterView.getContext(), txt, Toast.LENGTH_SHORT).show();
        }
        if(adapterView.getId()==R.id.btn_new_tel) {
            String txt = adapterView.getItemAtPosition(i).toString();
            temp4=0;
            temp4 = Integer.parseInt(txt);

          //  Toast.makeText(adapterView.getContext(), txt, Toast.LENGTH_SHORT).show();
        }
        if(adapterView.getId()==R.id.btn_fix_move) {
            String txt = adapterView.getItemAtPosition(i).toString();
            temp5=0;
            temp5 = Integer.parseInt(txt);

           // Toast.makeText(adapterView.getContext(), txt, Toast.LENGTH_SHORT).show();
        }
        if(adapterView.getId()==R.id.btn_fix2) {
            String txt = adapterView.getItemAtPosition(i).toString();
            temp6=0;
            temp6 = Integer.parseInt(txt);

           // Toast.makeText(adapterView.getContext(), txt, Toast.LENGTH_SHORT).show();
        }
        if(adapterView.getId()==R.id.btn_fix2_ch) {
            String txt = adapterView.getItemAtPosition(i).toString();
            temp7=0;
            temp7 = Integer.parseInt(txt);

          //  Toast.makeText(adapterView.getContext(), txt, Toast.LENGTH_SHORT).show();
        }
        /*if(adapterView.getId()==R.id.) {
            String txt = adapterView.getItemAtPosition(i).toString();
            temp8=0;
            temp8 = Integer.parseInt(txt);

           // Toast.makeText(adapterView.getContext(), txt, Toast.LENGTH_SHORT).show();
        }*/
      /*  if(adapterView.getId()==R.id.btn_fix2_ch) {
            String txt = adapterView.getItemAtPosition(i).toString();
            temp9=0;
            temp9 = Integer.parseInt(txt);

           // Toast.makeText(adapterView.getContext(), txt, Toast.LENGTH_SHORT).show();
        }*/
        if(adapterView.getId()==R.id.btn_sc) {
            String txt = adapterView.getItemAtPosition(i).toString();
            temp10=0;
            temp10 = Integer.parseInt(txt);

           // Toast.makeText(adapterView.getContext(), txt, Toast.LENGTH_SHORT).show();
        }
        if(adapterView.getId()==R.id.btn_up_modem) {
            String txt = adapterView.getItemAtPosition(i).toString();
            temp11=0;
            temp11 = Integer.parseInt(txt);

          //  Toast.makeText(adapterView.getContext(), txt, Toast.LENGTH_SHORT).show();
        }
        if(adapterView.getId()==R.id.btn_modem_combo) {
            String txt = adapterView.getItemAtPosition(i).toString();
            temp12=0;
            temp12= Integer.parseInt(txt);

           // Toast.makeText(adapterView.getContext(), txt, Toast.LENGTH_SHORT).show();
        }
        if(adapterView.getId()==R.id.btn_int_modem) {
            String txt = adapterView.getItemAtPosition(i).toString();
            temp13=0;
            temp13 = Integer.parseInt(txt);

            //Toast.makeText(adapterView.getContext(), txt, Toast.LENGTH_SHORT).show();
        }
        if(adapterView.getId()==R.id.btn_up_mini) {
            String txt = adapterView.getItemAtPosition(i).toString();
            temp14=0;
            temp14= Integer.parseInt(txt);

           // Toast.makeText(adapterView.getContext(), txt, Toast.LENGTH_SHORT).show();
        }
        if(adapterView.getId()==R.id.btn_up_memir) {
            String txt = adapterView.getItemAtPosition(i).toString();
            temp15=0;
            temp15 = Integer.parseInt(txt);

            //Toast.makeText(adapterView.getContext(), txt, Toast.LENGTH_SHORT).show();
        }
        if(adapterView.getId()==R.id.btn_up_firs_mini) {
            String txt = adapterView.getItemAtPosition(i).toString();
            temp16=0;
            temp16= Integer.parseInt(txt);

           // Toast.makeText(adapterView.getContext(), txt, Toast.LENGTH_SHORT).show();
        }
        if(adapterView.getId()==R.id.btn_hd_mini) {
            String txt = adapterView.getItemAtPosition(i).toString();
            temp17=0;
            temp17 = Integer.parseInt(txt);

           // Toast.makeText(adapterView.getContext(), txt, Toast.LENGTH_SHORT).show();
        }
        if(adapterView.getId()==R.id.btn_4k) {
            String txt = adapterView.getItemAtPosition(i).toString();
            temp18=0;
            temp18 = Integer.parseInt(txt);

           // Toast.makeText(adapterView.getContext(), txt, Toast.LENGTH_SHORT).show();
        }
        if(adapterView.getId()==R.id.btn_complite) {
            String txt = adapterView.getItemAtPosition(i).toString();
            temp19=0;
            temp19 = Integer.parseInt(txt);

           // Toast.makeText(adapterView.getContext(), txt, Toast.LENGTH_SHORT).show();
        }
        if(adapterView.getId()==R.id.btn_lid_tripel) {
            String txt = adapterView.getItemAtPosition(i).toString();
            temp20=0;
            temp20= Integer.parseInt(txt);

            //Toast.makeText(adapterView.getContext(), txt, Toast.LENGTH_SHORT).show();
        }
        if(adapterView.getId()==R.id.btn_lid_int) {
            String txt = adapterView.getItemAtPosition(i).toString();
            temp21=0;
            temp21= Integer.parseInt(txt);

            //Toast.makeText(adapterView.getContext(), txt, Toast.LENGTH_SHORT).show();
        }
        if(adapterView.getId()==R.id.btn_mineral) {
            String txt = adapterView.getItemAtPosition(i).toString();
            temp22=0;
            temp22 = Integer.parseInt(txt);

            // Toast.makeText(adapterView.getContext(), txt, Toast.LENGTH_SHORT).show();
        }
        if(adapterView.getId()==R.id.btn_siv_hitzoni) {
            String txt = adapterView.getItemAtPosition(i).toString();
            temp23=0;
            temp23 = Integer.parseInt(txt);

           // Toast.makeText(adapterView.getContext(), txt, Toast.LENGTH_SHORT).show();
        }
        if(adapterView.getId()==R.id.btn_siv_pnimi) {
            String txt = adapterView.getItemAtPosition(i).toString();
            temp24=0;
            temp24 = Integer.parseInt(txt);

            // Toast.makeText(adapterView.getContext(), txt, Toast.LENGTH_SHORT).show();
        }
        if(adapterView.getId()==R.id.btn_siv_afala) {
            String txt = adapterView.getItemAtPosition(i).toString();
            temp25=0;
            temp25 = Integer.parseInt(txt);

            // Toast.makeText(adapterView.getContext(), txt, Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


}