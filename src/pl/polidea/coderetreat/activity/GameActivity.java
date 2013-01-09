package pl.polidea.coderetreat.activity;

import android.app.Activity;
import android.os.Bundle;
import pl.polidea.coderetreat.R;

public class GameActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_layout);
    }
}
