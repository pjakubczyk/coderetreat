package pl.polidea.coderetreat.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import pl.polidea.coderetreat.R;
import pl.polidea.coderetreat.game.GameOfLife;
import pl.polidea.coderetreat.view.ConwayView;

public class GameActivity extends Activity {
    Button nextBtn;
    ConwayView gameView;
    TextView counterTv;
    int counter;
    EditText stepsEt;
    Button startBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_layout);

        nextBtn = (Button) findViewById(R.id.next_step_btn);
        stepsEt = (EditText) findViewById(R.id.steps_et);
        startBtn = (Button) findViewById(R.id.start_button);

        gameView = new ConwayView(this);
        GameOfLife game = new GameOfLife(GameOfLife.TYPE.LWSS);
        gameView.enableGame(game);

        FrameLayout fl = (FrameLayout) findViewById(R.id.game_layout);
        fl.addView(gameView);

        counterTv = (TextView) findViewById(R.id.current_step_tv);
        counter = 0;
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gameView.nextStep();
                ++counter;
                counterTv.setText(Integer.toString(counter));
            }
        });

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int steps = Integer.parseInt(stepsEt.getText().toString());
                for (int i = 0; i < steps; ++i) {
                    nextBtn.performClick();
                }
            }
        });
    }
}
