package com.example.test;


import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import android.Manifest;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.pdf.PdfDocument;
import android.net.Uri;
import android.os.Build;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.Switch;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.util.Calendar;


public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {

    SharedPreferences spTotal;
    SharedPreferences spSpecial;
    int buy;
    int totalNew,totalCh;
    final int CALL_PERMISSION=1;
    String number;
    private AlertDialog.Builder dialodBuilder;
    private AlertDialog dialog;
    TextView txtBuy;
    Button deleteMoney,deleteAll;
    AdView adView,adView1;
    private InterstitialAd mInterstitialAd;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        PdfDocument [] pdf ;

        adView =findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
        adView1 =findViewById(R.id.adView1);
        AdRequest adRequest1 = new AdRequest.Builder().build();
        adView1.loadAd(adRequest1);
        //ca-app-pub-1073128512622518/1370952766  //real Bunner
        //ca-app-pub-1073128512622518/7335974741  //real pass
        //ca-app-pub-3940256099942544/6300978111  //not real bunner
        //ca-app-pub-3940256099942544/1033173712  //not real pass


        txtBuy=findViewById(R.id.txt_delete_money);
        TextView txt1=findViewById(R.id.txt_date1);
        TextView txt2 =findViewById(R.id.txt_money);
        TextView txt3 =findViewById(R.id.txt_special);
        TextView txt4 =findViewById(R.id.txt_mam);
        TextView txt5 = findViewById(R.id.txt_Rf_total);
        TextView txt6=findViewById(R.id.txt_percent_new);
        TextView txt7=findViewById(R.id.txt_percent_ch);
        TextView txt8 =findViewById(R.id.txt_percent_total);
        TextView txt9 = findViewById(R.id.txt_total_use);

        Button btnCallMashlat = findViewById(R.id.btn_call_mashlat);
        Button btnCallMatat = findViewById(R.id.btn_call_matat);
        Button btnCallMahavatDira = findViewById(R.id.btn_mavar_dira);
        Button btnCallAtzalot = findViewById(R.id.btn_atzalot);
        Button btnCallVip = findViewById(R.id.btn_call_vip);

        btnCallMashlat.setOnClickListener(this);
        btnCallMatat.setOnClickListener(this);
        btnCallMahavatDira.setOnClickListener(this);
        btnCallAtzalot.setOnClickListener(this);
        btnCallVip.setOnClickListener(this);

        spTotal= getSharedPreferences("details",MODE_PRIVATE);
        txt2.setText("סה'כ ללא מע'מ: "+spTotal.getInt("count",0)+" ש'ח ");

        spSpecial =getSharedPreferences("Special",MODE_PRIVATE);
        txt3.setText("סה'כ סכום מחסן: "+spSpecial.getInt("special",0)+" ש'ח ");
        buy= spSpecial.getInt("special",0);

        txt4.setText("סה'כ פלוס מעמ:  "+(spTotal.getInt("count",0)+((spTotal.getInt("count",0)*17)/100))+" ש'ח ");

        int RfNew=spSpecial.getInt("specialCN",0);
        int RfCh=spSpecial.getInt("specialCH",0);
        int RfEm=spSpecial.getInt("specialEM",0);
        int total=RfNew+RfCh+RfEm;
        if(total!=0)totalNew= RfNew*100/total;
        if(total!=0)totalCh = RfCh*100/total;
        txt5.setText("סה'כ שקעים: ["+total+"]");

        txt6.setText("אחוז התקנות שקעים: ["+totalNew+"%]");
        txt7.setText("אחוז החלפות שקעים: ["+totalCh+"%]");

        int divider = spTotal.getInt("divider",0);
        int totalpercent = spTotal.getInt("count",0);
        int curent=0;
        if(divider!=0) curent=totalpercent/divider;
        txt8.setText("ממוצע להתקנה: "+curent+" ש'ח ");

        txt9.setText("כמות פקעות שחושבו:  ["+divider+"]");

        Button btnNewPaka=findViewById(R.id.btn_new_paka);
        btnNewPaka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity2.this,MainActivity.class);
                startActivity(intent);

            }
        });
        Button btnCleer =findViewById(R.id.btn_cleer);
        btnCleer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                CleerAll();

            }
        });
        Button btnBuy =findViewById(R.id.btn_buy);
        btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DeletDialog();

            }
        });
        Button btnAqvariom = findViewById(R.id.btn_aqvarium);
        btnAqvariom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://tat.simple-sites.co.il/login?tech=true"));
                startActivity(browserIntent);
            }
        });


        Calendar calendar =Calendar.getInstance();
        String currenDate = DateFormat.getDateInstance().format(calendar.getTime());
        txt1.setText(currenDate);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            createPersonaileAd();


            }
        });

    }
    public void DeletDialog (){
        dialodBuilder= new AlertDialog.Builder(this);
        final View contactPopupView =getLayoutInflater().inflate(R.layout.activity_main3,null);
        txtBuy= (EditText) contactPopupView.findViewById(R.id.txt_delete_money);
        deleteMoney = (Button) contactPopupView.findViewById(R.id.btn_delete_money);

        dialodBuilder.setView(contactPopupView);
        dialog=dialodBuilder.create();
        dialog.show();


        deleteMoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int sum = Integer.parseInt(txtBuy.getText().toString());
                buy-=sum;
                SharedPreferences.Editor editor1 = spSpecial.edit();
                editor1.putInt("special",buy);
                editor1.commit();

                Intent intent = new Intent(MainActivity2.this,MainActivity2.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onRequestPermissionsResult(int requestCode,  String[] permissions,  int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode==CALL_PERMISSION){
            if (grantResults[0]==PackageManager.PERMISSION_GRANTED){
                makeCall(number);
            }

        }
    }

    public void CleerAll(){
        dialodBuilder= new AlertDialog.Builder(this);
        final View contactPopupView =getLayoutInflater().inflate(R.layout.cleer_all,null);

        deleteAll =(Button) contactPopupView.findViewById(R.id.btn_delete_all);

        dialodBuilder.setView(contactPopupView);
        dialog=dialodBuilder.create();
        dialog.show();

        deleteAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = spTotal.edit();
                editor.putInt("count",0);
                editor.commit();
                SharedPreferences.Editor editor1 = spSpecial.edit();
                editor1.putInt("special",0);
                editor1.commit();
                SharedPreferences.Editor editor2 = spSpecial.edit();
                editor2.putInt("specialCN",0);
                editor2.commit();
                SharedPreferences.Editor editor3 = spSpecial.edit();
                editor3.putInt("specialCH",0);
                editor3.commit();
                SharedPreferences.Editor editor4 = spSpecial.edit();
                editor4.putInt("specialEM",0);
                editor4.commit();
                SharedPreferences.Editor editor5 = spTotal.edit();
                editor5.putInt("divider",0);
                editor5.commit();


                if (mInterstitialAd != null) {
                    mInterstitialAd.show(MainActivity2.this);
                } else {
                    Log.d("AdMob", "The interstitial ad wasn't ready yet.");
                    Intent intent = new Intent(MainActivity2.this,MainActivity2.class);
                    startActivity(intent);
                }


            }
        });

    }
    private void makeCall(String number) {
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + number));
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.btn_call_mashlat)number="0777075120";
        if(view.getId()==R.id.btn_call_matat)number="0777078958";
        if(view.getId()==R.id.btn_call_vip)number="0536062544";
        if(view.getId()==R.id.btn_atzalot)number="0777078326";
        if(view.getId()==R.id.btn_mavar_dira)number="0777078445";
        if(Build.VERSION.SDK_INT<23){

            makeCall(number);

        }
        else {
            int hasCallPermission = checkSelfPermission(Manifest.permission.CALL_PHONE);
            if (hasCallPermission == PackageManager.PERMISSION_GRANTED) {
                makeCall(number);
            } else {
                requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, CALL_PERMISSION);
            }
        }
    }
    private void createPersonaileAd(){
        AdRequest adRequest = new AdRequest.Builder().build();
        createInterstitialAd(adRequest);
    }
    private void createInterstitialAd(AdRequest adRequest){
        InterstitialAd.load(this,"ca-app-pub-1073128512622518/7335974741", adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        // The mInterstitialAd reference will be null until
                        // an ad is loaded.
                        mInterstitialAd = interstitialAd;
                        Log.d("AdMob", "onAdLoaded");
                        mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback(){
                            @Override
                            public void onAdDismissedFullScreenContent() {
                                // Called when fullscreen content is dismissed.
                                Log.d("AdMob", "The ad was dismissed.");
                                Intent intent = new Intent(MainActivity2.this,MainActivity2.class);
                                startActivity(intent);
                            }

                            @Override
                            public void onAdFailedToShowFullScreenContent(AdError adError) {
                                // Called when fullscreen content failed to show.
                                Log.d("AdMob", "The ad failed to show.");
                            }

                            @Override
                            public void onAdShowedFullScreenContent() {
                                // Called when fullscreen content is shown.
                                // Make sure to set your reference to null so you don't
                                // show it a second time.
                                mInterstitialAd = null;
                                Log.d("AdMob", "The ad was shown.");
                            }
                        });
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error
                        Log.d("AdMob", loadAdError.getMessage());
                        mInterstitialAd = null;
                    }
                });
    }

}
