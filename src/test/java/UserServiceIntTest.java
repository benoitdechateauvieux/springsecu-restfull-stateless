import org.apache.http.client.HttpClient;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;
import org.exoplatform.bch.service.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

/**
 * Created by bdechateauvieux on 4/8/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext-test.xml"})
public class UserServiceIntTest {

    private Server server;

    @Autowired
    private RestTemplate restTemplate;

    @Before
    public void startServer() throws Exception {
        server = new Server(8080);
        server.setStopAtShutdown(true);
        WebAppContext webAppContext = new WebAppContext();
        webAppContext.setContextPath("/");
        webAppContext.setResourceBase("src/main/webapp");
        webAppContext.setClassLoader(getClass().getClassLoader());
        server.setHandler(webAppContext);
        server.start();
    }


    @Test
    public void shouldBePreAuthenticated() throws Exception {
        ResponseEntity<User[]> response = restTemplate.getForEntity("http://localhost:8080/user", User[].class);
        for (User user : response.getBody()) {
            System.out.println(user.getName());
        }
    }

    @After
    public void shutdownServer() throws Exception {
        server.stop();
    }


}
