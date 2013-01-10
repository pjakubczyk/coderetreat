package pl.polidea.coderetreat.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.FrameLayout;
import pl.polidea.coderetreat.R;
import pl.polidea.coderetreat.game.GameOfLife;
import pl.polidea.coderetreat.view.ConwayView;

public class GameActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_layout);

        ConwayView conwayView = new ConwayView(this);
        GameOfLife game = new GameOfLife(GameOfLife.TYPE.LWSS);
        conwayView.enableGame(game);

        FrameLayout fl = (FrameLayout) findViewById(R.id.game_layout);
        fl.addView(conwayView);
    }
}
