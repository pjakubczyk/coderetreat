package pl.polidea.coderetreat.view

import com.xtremelabs.robolectric.Robolectric
import pl.polidea.coderetreat.ShadowConwayCanvas
import pl.polidea.coderetreat.ShadowConwayView
import pl.polidea.coderetreat.game.GameOfLife
import pl.polidea.robospock.RoboSpecification
import pl.polidea.robospock.UseShadows

@UseShadows([ShadowConwayView, ShadowConwayCanvas])
class ConwayViewSpecification extends RoboSpecification {

    def "check setting new game"() {
        given:
        def conwayView = new ConwayView(Robolectric.application)

        when:
        conwayView.enableGame(Mock(GameOfLife))

        then:
        conwayView.game
    }

    def "should conway view create table view inside"() {
        given:
        def conwayView = new ConwayView(Robolectric.application)
        def mock = Mock(GameOfLife)
        mock.size() >> 25

        when:
        conwayView.enableGame(mock)

        then:
        conwayView.getNumberOfCells() == 25
    }

    def "view should draw 100 rectangles"() {
        given:
        def conwayView = new ConwayView(Robolectric.application)

        when:
        conwayView.enableGame(Mock(GameOfLife))
        conwayView.invalidate()
        ShadowConwayCanvas canvas = Robolectric.shadowOf(((ShadowConwayView)Robolectric.shadowOf(conwayView)).canvas)

        then:
        canvas.rects.size() == 100
    }

}