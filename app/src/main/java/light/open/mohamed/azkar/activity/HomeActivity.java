package light.open.mohamed.azkar.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import light.open.mohamed.azkar.R;

public class HomeActivity extends AppCompatActivity {

    @BindView(R.id.werdToday_Btn)
    Button werdTodayBtn;
    @BindView(R.id.azkar_Btn)
    Button azkarBtn;
    @BindView(R.id.masbaha_Btn)
    Button masbahaBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.werdToday_Btn, R.id.azkar_Btn, R.id.masbaha_Btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.werdToday_Btn:
                Intent intent=new Intent(HomeActivity.this,Ward_Activity.class);
                startActivity(intent);
                finish();

                break;
            case R.id.azkar_Btn:
                Intent intent1=new Intent(HomeActivity.this,Azkar_Activity.class);
                startActivity(intent1);
                finish();
                break;
            case R.id.masbaha_Btn:
                Intent intent2=new Intent(HomeActivity.this,MainActivity.class);
                startActivity(intent2);
                finish();
                break;
        }
    }
}
