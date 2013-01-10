package pl.polidea.coderetreat;

import android.graphics.Canvas;
import android.graphics.RectF;
import com.xtremelabs.robolectric.internal.Implementation;
import com.xtremelabs.robolectric.internal.Implements;
import com.xtremelabs.robolectric.shadows.ShadowCanvas;

import java.util.ArrayList;
import java.util.List;

@Implements(Canvas.class)
public class ShadowConwayCanvas extends ShadowCanvas {

    List<RectF> rects = new ArrayList<RectF>();

    @Implementation
    public void drawRect(float left, float top, float right, float bottom, android.graphics.Paint paint){
        paint.getColor();
        RectF rect = new RectF();
        rect.left = left;
        rect.top = top;
        rect.right = right;
        rect.bottom = bottom;
        rects.add(rect);
    }
}
