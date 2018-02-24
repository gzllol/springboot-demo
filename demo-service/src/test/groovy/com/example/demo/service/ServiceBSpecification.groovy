import com.example.demo.DemoApplication
import com.example.demo.service.ServiceB
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@ContextConfiguration(classes = [DemoApplication.class])
class ServiceBSpecification extends Specification {

    @Autowired
    ServiceB serviceB

    def "1 * 2 + 4 = 6"() {
        expect:
            6 == serviceB.mulAdd(1, 2, 4)
    }

}