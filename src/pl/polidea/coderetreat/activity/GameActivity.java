package pl.polidea.coderetreat.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import pl.polidea.coderetreat.R;
import pl.polidea.coderetreat.game.GameOfLife;
import pl.polidea.coderetreat.view.ConwayView;

public class GameActivity extends Activity {
    Button nextBtn;
    ConwayView gameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_layout);

        nextBtn = (Button) findViewById(R.id.next_step_btn);

        gameView = new ConwayView(this);
        GameOfLife game = new GameOfLife(GameOfLife.TYPE.LWSS);
        gameView.enableGame(game);

        FrameLayout fl = (FrameLayout) findViewById(R.id.game_layout);
        fl.addView(gameView);

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gameView.nextStep();
            }
        });
    }
}
