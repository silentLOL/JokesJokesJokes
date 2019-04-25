package stefanirndorfer.at.jokingactivities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.TextView;


public class JokingActivity extends AppCompatActivity {

    public static final String JOKE_KEY = "joke";

    private TextView jokeOutputView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joking);

        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            return;
        }
        String joke = extras.getString(JOKE_KEY);
        if (TextUtils.isEmpty(joke)) {
            throw new IllegalArgumentException("There is no Joke!");
        }
        jokeOutputView = findViewById(R.id.joke_output_tv);
        jokeOutputView.setText(joke);
    }
}
