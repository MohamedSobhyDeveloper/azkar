package light.open.mohamed.azkar.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.material.snackbar.Snackbar;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import light.open.mohamed.azkar.MySharedPref;
import light.open.mohamed.azkar.R;

public class MainActivity extends AppCompatActivity {
    Button b1,b2,b3,b4;
    EditText e1,e2;
    TextView t1;
    RelativeLayout r1,r2;
    private MediaPlayer mp,m;
    private AdView mAdView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.cancel);
        b2=(Button)findViewById(R.id.start);
        b3=(Button)findViewById(R.id.close);
        b4=(Button)findViewById(R.id.choose);
        e1=(EditText)findViewById(R.id.editText);
        e2=(EditText)findViewById(R.id.countedittext);
        t1=(TextView)findViewById(R.id.tnumber);
        r1=(RelativeLayout)findViewById(R.id.ticket_popup);
        r2=(RelativeLayout)findViewById(R.id.ticket_popup1);
        mp = MediaPlayer.create(MainActivity.this, R.raw.mmbb);
        m = MediaPlayer.create(MainActivity.this, R.raw.click);


        e1.setText(MySharedPref.getData(MainActivity.this, "azkar", null));
        e2.setText(MySharedPref.getData(MainActivity.this, "count", null));

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        if (e2.getText().toString().equals("")){
            e2.setText("0");
        }

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final CharSequence colors[] = new CharSequence[]{"سبحان الله", "الحمد لله","لا اله الا الله","الله اكبر","استغفر الله","اللهم صلى على سيدنا محمد","لا حوله ولا قوة الا بالله","سبحان الله وبحمده","لا اله الا انت سبحانك إنى كنت من الظالمين"};

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("اختر الذكر");
                builder.setItems(colors, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.e("value is", "" + which);
                        switch (which) {
                            case 0:
                                e1.setText(colors[0]);


                                break;
                            case 1:
                                e1.setText(colors[1]);



                                break;
                            case 2:
                                e1.setText(colors[2]);


                                break;
                            case 3:
                                e1.setText(colors[3]);


                                break;
                            case 4:
                                e1.setText(colors[4]);



                                break;
                            case 5:
                                e1.setText(colors[5]);


                                break;
                            case 6:
                                e1.setText(colors[6]);


                                break;
                            case 7:
                                e1.setText(colors[7]);



                                break;
                            case 8:
                                e1.setText(colors[8]);


                                break;

                        }
                    }
                });
                builder.show();




            }
        });


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (e2.getText().toString().equals("0")) {
                    Snackbar.make(view, "لم تقوم بالتسبيح بعد", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
                            else {
                    r1.setVisibility(View.VISIBLE);
                    r2.setVisibility(View.GONE);
                    t1.setText(e2.getText().toString()+" "+"مرة");
                    MySharedPref.saveData(MainActivity.this,"count","0");
                    MySharedPref.saveData(MainActivity.this,"azkar","اختر الذكر من القائمة");
                }
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                r1.setVisibility(View.VISIBLE);
                r2.setVisibility(View.VISIBLE);
                e1.setText(MySharedPref.getData(MainActivity.this, "azkar", null));
                e2.setText(MySharedPref.getData(MainActivity.this, "count", null));




            }
        });

        b2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String str=e2.getText().toString();
                int x= Integer.parseInt(str);

                if (e1.getText().toString().equals("")||e1.getText().toString().equals("اختر الذكر من القائمة")){
                    Snackbar.make(view, "قم بالاختيار من القائمة", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();


                }else {
                    x++;
                    e2.setText(x+"");
                    MySharedPref.saveData(MainActivity.this,"count",e2.getText().toString());
                    MySharedPref.saveData(MainActivity.this,"azkar",e1.getText().toString());
                    m.start();
                    mp.stop();


                }


            }
        });



    }


    @Override
    protected void onStart() {
        super.onStart();
        mp.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mp.stop();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
        System.exit(0);
    }
}
