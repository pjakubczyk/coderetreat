package pl.polidea.coderetreat.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
import pl.polidea.coderetreat.game.GameOfLife;

public class ConwayView extends View {
    private GameOfLife game;

    public ConwayView(Context context) {
        super(context);

    }

    public void enableGame(GameOfLife game) {
        this.game = game;
        game.proceed();
        invalidate();
    }

    public Integer getNumberOfCells() {
        return game.size();
    }

    Paint paint = new Paint();

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        for (int x = 0; x < 10; ++x) {
            for (int y = 0; y < 10; ++y) {
                paint.setColor(game.get(x, y) ? Color.BLUE : Color.CYAN);
                canvas.drawRect(x * 40, y * 40, (x + 1) * 40, (y + 1) * 40, paint);
            }
        }

    }


}
