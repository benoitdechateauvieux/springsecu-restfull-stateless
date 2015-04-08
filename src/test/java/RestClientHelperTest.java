
import org.apache.http.auth.Credentials;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.exoplatform.bch.client.RestClientHelper;
import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.client.RestTemplate;

/**
 * Created by bdechateauvieux on 4/8/15.
 */
public class RestClientHelperTest {
    @Test
    @Ignore
    public void testContructorOneArg() {
        RestTemplate restTemplate = new RestTemplate();
        RestClientHelper restClientHelper = new RestClientHelper(restTemplate);
        assertEquals(restTemplate, restClientHelper.getRestTemplate());
    }

    @Test
    @Ignore
    public void testContructorTwoArgs() {
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("WEB-INF/applicationContext.xml");
        RestTemplate restTemplate = (RestTemplate) applicationContext.getBean("restTemplate");
        Credentials credentials = new UsernamePasswordCredentials("user", "pwd");
        RestClientHelper restClientHelper = new RestClientHelper(restTemplate, credentials);
        assertEquals(restTemplate, restClientHelper.getRestTemplate());

//        CommonsClientHttpRequestFactory factory = (CommonsClientHttpRequestFactory) restClientHelper.getRestTemplate().getRequestFactory();
//        HttpClient client = factory.getHttpClient();

//        assertEquals(credentials, client.getState().getCredentials(AuthScope.ANY));
    }
}
