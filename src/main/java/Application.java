import com.learnspring.service.SpeakerService;
import com.learnspring.service.SpeakerServiceImpl;

import static java.lang.System.out;

public class Application {
    public static void main(String[] args){
        SpeakerService service = new SpeakerServiceImpl();
        out.println(service.findAll().get(2).getFirstName());
    }
}
