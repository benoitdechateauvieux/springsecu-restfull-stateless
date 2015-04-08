# springsecu-restfull-stateless
Test to check how Spring-Secu manages stateless REST services (no session).   
In the UserService, there is an explicit creation of a session 
```java
request.getSession(true);
```

Even if Spring Security is configured as stateless, the session is created
```xml
    <http create-session="stateless">
        <intercept-url pattern="/**" access="hasRole('USER')"/>
        <http-basic/>
    </http>
```
