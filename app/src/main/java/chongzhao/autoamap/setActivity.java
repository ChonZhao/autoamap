package chongzhao.autoamap;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

public class setActivity extends AppCompatActivity implements View.OnClickListener {
    /**
     * 是否自动开启高德地图
     */
    private Switch mSwitch1;
    private RadioGroup mTime;
    /**
     * 确定并退出界面
     */
    private Button mButton2;
    private int sec =30;
    private preferencesOper preferencesoper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set);
        initView();
    }

    private void initView() {
        preferencesoper = new preferencesOper(this);
        mSwitch1 =  findViewById(R.id.switch1);
        mTime = findViewById(R.id.time);
        //读取之前设置
        mSwitch1.setChecked(preferencesoper.radePrefer_shifoukaiqi());
        switch (preferencesoper.radePrefer_yanchi()){
            case 30:
                mTime.check(R.id.sec30);
                break;
            case 60:
                mTime.check(R.id.sec60);
                break;
            case 120:
                mTime.check(R.id.sec120);
                break;
        }
        mSwitch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    preferencesoper.savePrefer_shifoukaiqi(isChecked);
                    mTime.setClickable(isChecked);
            }
        });

        mTime.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int id = group.getCheckedRadioButtonId();
                switch (id){
                    case R.id.sec30:
                        sec=30;
                        break;
                    case R.id.sec60:
                        sec=60;
                        break;
                    case R.id.sec120:
                        sec=120;
                        break;
                }
            }
        });
        mButton2 =  findViewById(R.id.button2);
        mButton2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.button2:
                preferencesoper.savePrefer_yanchi(sec);
                Toast.makeText(this,sec+"s set",Toast.LENGTH_LONG).show();
               this.finish();
        }
    }

}
