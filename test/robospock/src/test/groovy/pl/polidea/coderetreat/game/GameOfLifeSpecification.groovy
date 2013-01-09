package pl.polidea.coderetreat.game

import spock.lang.Specification

class GameOfLifeSpecification extends Specification {

    def "game table size should be 16"() {
        when:
        def gameOfLife = new GameOfLife(4)

        then:
        gameOfLife.size() == 16
    }

    def "game table shouldn't be empty"() {
        when:
        def gameOfLife = new GameOfLife(4)

        then:
        gameOfLife.isEmpty()
    }

    def "test initial loaf game"() {
        when:
        def game = new GameOfLife(GameOfLife.TYPE.LOAF)

        then:
        game.get(i, j) == value

        where:
        i | j | value
        0 | 0 | false
        0 | 1 | true
        0 | 2 | true
        0 | 3 | false
        1 | 0 | true
        1 | 1 | false
        1 | 2 | false
        1 | 3 | true
        2 | 0 | false
        2 | 1 | true
        2 | 2 | false
        2 | 3 | true
        3 | 0 | false
        3 | 1 | false
        3 | 2 | true
        3 | 3 | false
    }

    def "test initial LWSS game"(){
        when:
        def game = new GameOfLife(GameOfLife.TYPE.LWSS)

        then:
        game.get(i, j) == value

        where:
        i | j | value
        0 | 0 | false
        0 | 1 | true
        0 | 2 | false
        0 | 3 | false
        0 | 4 | true
        1 | 0 | true
        1 | 1 | false
        1 | 2 | false
        1 | 3 | false
        1 | 4 | false
        2 | 0 | true
        2 | 1 | false
        2 | 2 | false
        2 | 3 | false
        2 | 4 | true
        3 | 0 | true
        3 | 1 | true
        3 | 2 | true
        3 | 3 | true
        3 | 4 | false
    }
}
