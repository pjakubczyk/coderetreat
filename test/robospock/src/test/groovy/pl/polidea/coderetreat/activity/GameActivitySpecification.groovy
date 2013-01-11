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

        when:
        activity.nextBtn.performClick()

        then:
        gameView.wasInvalidated()
    }

    def "Step counter should increase every click on Next Button"(){
        given:
        GameActivity activity = new GameActivity()
        activity.onCreate()

        when:
        activity.nextBtn.performClick()
        activity.nextBtn.performClick()
        activity.nextBtn.performClick()

        then:
        activity.counterTv.text == "3"
    }

    def "clicking start button should should trigger n times game step"(){
        given:
        GameActivity activity = new GameActivity()
        activity.onCreate()
        activity.stepsEt.setText("4")

        when:
        activity.startBtn.performClick()

        then:
        activity.counterTv.text == "4"
    }
}
