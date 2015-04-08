import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;
import org.exoplatform.bch.service.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;

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
    public void authentOK() throws Exception {
        ResponseEntity<User[]> response = restTemplate.getForEntity("http://localhost:8080/user", User[].class);
        for (Map.Entry<String, List<String>> header : response.getHeaders().entrySet()) {
            for (String value : header.getValue()) {
                assertThat(value, not(startsWith("JSESSIONID")));
            }
        }

        assertThat(response.getBody().length, is(1));
        assertThat(response.getBody()[0].getName(), is("Benoit"));
    }

    @After
    public void shutdownServer() throws Exception {
        server.stop();
    }


}
