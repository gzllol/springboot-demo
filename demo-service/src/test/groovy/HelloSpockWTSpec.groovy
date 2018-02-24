import spock.lang.Specification

class HelloSpockWTSpec extends Specification {

    def "1 + 2 = 3"() {
        when:
        def a = 1 + 2
        then:
        a == 4
    }

}
