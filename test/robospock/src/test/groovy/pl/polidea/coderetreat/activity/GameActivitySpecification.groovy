package pl.polidea.coderetreat.activity

import android.view.View
import com.xtremelabs.robolectric.Robolectric
import pl.polidea.robospock.RoboSpecification

class GameActivitySpecification extends RoboSpecification {

    def "check next step button listener"() {
        given:
        GameActivity activity = new GameActivity()
        activity.onCreate()
        def btn = activity.nextBtn
        def mock = Mock(View.OnClickListener)

        when:
        btn.setOnClickListener(mock)
        btn.performClick()

        then:
        1 * mock.onClick(_)
    }

    def "check if game view was invalidated after next button click"(){
        given:
        GameActivity activity = new GameActivity()
        activity.onCreate()
        def gameView = Robolectric.shadowOf(activity.gameView)
        gameView.clearWasInvalidated()

        when:
        activity.nextBtn.performClick()

        then:
        gameView.wasInvalidated()
    }
}
