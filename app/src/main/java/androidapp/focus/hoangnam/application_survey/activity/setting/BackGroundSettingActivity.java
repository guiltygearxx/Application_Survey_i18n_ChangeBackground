package androidapp.focus.hoangnam.application_survey.activity.setting;

import android.os.Bundle;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import androidapp.focus.hoangnam.application_survey.R;
import androidapp.focus.hoangnam.application_survey.model.ApplicationContext;

/**
 * Created by huy.nquoc on 12/24/2017.
 */

public class BackGroundSettingActivity extends AppCompatActivity {

    private ApplicationContext context;

    private Integer bgColor;

    private Button activatedButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.popup_change_background);

        this.init();
    }

    @Override
    protected void onStart() {

        super.onStart();

        if (activatedButton != null) activatedButton.setText("X");
    }

    private void init() {

        context = ApplicationContext.instance;

        bgColor = context.getBgColor();

        if (bgColor != null) {

            switch (bgColor) {

                case R.color.darkGreen:
                    activatedButton = findViewById(R.id.btn_green);
                    break;

                case R.color.colorAccent:
                    activatedButton = findViewById(R.id.btn_red);
                    break;

                case R.color.yellow:
                    activatedButton = findViewById(R.id.btn_yellow);
                    break;
            }
        }
    }

    public void changeBackGround(View view) {

        if (view.equals(this.activatedButton)) return;

        if (activatedButton != null) this.activatedButton.setText("");

        this.activatedButton = (Button) view;

        this.activatedButton.setText("X");

        switch (view.getId()) {

            case R.id.btn_green:
                bgColor = ResourcesCompat.getColor(getResources(), R.color.darkGreen, null);
                break;

            case R.id.btn_red:
                bgColor = ResourcesCompat.getColor(getResources(), R.color.colorAccent, null);
                break;

            case R.id.btn_yellow:
                bgColor = ResourcesCompat.getColor(getResources(), R.color.yellow, null);
                break;
        }
    }

    public void saveSetting(View view) {

        context.setBgColor(this.bgColor);

        finish();
    }
}
