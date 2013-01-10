package pl.polidea.coderetreat;

import android.graphics.Canvas;
import com.xtremelabs.robolectric.internal.Implements;
import com.xtremelabs.robolectric.shadows.ShadowView;
import pl.polidea.coderetreat.view.ConwayView;

@Implements(ConwayView.class)
public class ShadowConwayView extends ShadowView {
    Canvas canvas = new Canvas();

    @Override
    public void invalidate() {
        super.invalidate();
        canvas.restore();
        realView.draw(canvas);
    }
}
