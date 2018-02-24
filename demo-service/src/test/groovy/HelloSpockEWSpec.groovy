import spock.lang.Specification

class HelloSpockEWSpec extends Specification {

    def "a == b + c"() {
        expect:
        a == b + c

        where:
        a || b | c
        2 || 1 | 1
        8 || 5 | 3
        9 || 2 | 7
    }
}