package androidapp.focus.hoangnam.application_survey.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.RadioButton;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import androidapp.focus.hoangnam.application_survey.R;
import androidapp.focus.hoangnam.application_survey.activity.setting.BackGroundSettingActivity;


public class MainActivity extends BaseQuestionActivity {

    List<RadioButton> radioButtons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        radioButtons = Arrays.asList(
                (RadioButton) findViewById(R.id.radioButton),
                (RadioButton) findViewById(R.id.radioButton2),
                (RadioButton) findViewById(R.id.radioButton3),
                (RadioButton) findViewById(R.id.radioButton4),
                (RadioButton) findViewById(R.id.radioButton5)
        );
    }

    @Override
    protected Object getAnswerData() {

        for (RadioButton radioButton : radioButtons) {

            if (radioButton.isChecked()) return radioButton.getText();
        }

        return null;
    }

    @Override
    protected void changeBackGroundColor() {

        if (bgColor != null) {

            findViewById(R.id.rootLayout).setBackgroundColor(bgColor);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.menu.tab_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.language_en:
                this.changeLocale("en");
                break;

            case R.id.language_vn:
                this.changeLocale("vi");
                break;

            case R.id.change_background:
                this.goToChangeBackGroundActivity();
                break;
        }

        return true;
    }

    private void goToChangeBackGroundActivity() {

        Intent intent = new Intent(this, BackGroundSettingActivity.class);

        startActivity(intent);
    }

    private void changeLocale(String languageCode) {

        Resources res = getResources();

        DisplayMetrics dm = res.getDisplayMetrics();

        Configuration conf = res.getConfiguration();

        conf.setLocale(new Locale(languageCode.toLowerCase())); // API 17+ only.

        res.updateConfiguration(conf, dm);

        this.recreate();
    }
}
