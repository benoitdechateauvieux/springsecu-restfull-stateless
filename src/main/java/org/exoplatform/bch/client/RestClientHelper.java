package org.exoplatform.bch.client;

import org.apache.http.auth.Credentials;
import org.springframework.web.client.RestTemplate;

/**
 * Created by bdechateauvieux on 4/8/15.
 */
public class RestClientHelper {
    private RestTemplate restTemplate;
    private String baseUrl;

    protected RestClientHelper() {}

    /**
     * Constructeur par défaut
     * @param restTemplate Est définit dans le applicationContext-RestClient.xml
     */
    public RestClientHelper(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * Constructeur à utiliser pour paramétrer l'authentification
     * @param restTemplate Est définit dans le applicationContext-RestClient.xml
     * @param credentials A configurer dans le contexte Spring
     */
    public RestClientHelper(RestTemplate restTemplate, Credentials credentials) {
        this(restTemplate);
//        HttpComponentsClientHttpRequestFactory factory = (HttpComponentsClientHttpRequestFactory) restTemplate.getRequestFactory();
//        HttpClient client = factory.getHttpClient();
//        client.getState().setCredentials(AuthScope.ANY, credentials);
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    /**
     * @return Le RestTemplate permettant de réaliser les requêtes HTTP
     */
    public RestTemplate getRestTemplate() {
        return restTemplate;
    }
}
