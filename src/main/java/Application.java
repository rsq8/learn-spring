import com.learnspring.service.SpeakerService;
import com.learnspring.service.SpeakerServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static java.lang.System.out;

public class Application {
    public static void main(String[] args){

        ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        //SpeakerService service = new SpeakerServiceImpl();

        SpeakerService service = appContext.getBean("speakerService", SpeakerService.class);
        out.println(service.findAll().get(2).getFirstName());
    }
}
