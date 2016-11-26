import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by root on 2016/11/25.
 */
@SpringBootApplication
@EnableSwagger2
@RestController
@ComponentScan(basePackages = "com.mypet.social")
public class Application {

    private static Logger log = LoggerFactory.getLogger(Application.class);
    private static final String ENV = "test";

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!";
    }

    public static void main(String[] args) throws Exception {
        System.setProperty("spring.profiles.active", ENV);
        ApplicationContext context = SpringApplication.run(Application.class);

        String profiles[] = context.getEnvironment().getActiveProfiles();
        for(String profile : profiles){
            log.info("当前环境："+profile);
        }
    }



}
