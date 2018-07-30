package <%= basePackage %>.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
import <%= basePackage %>.config.<%= appnameCapitalized %>Properties;
import <%= basePackage %>.service.<%= appnameCapitalized %>Service;

@Service
public class <%= appnameCapitalized %>ServiceImpl implements <%= appnameCapitalized %>Service {

    private final Logger log = LoggerFactory.getLogger(<%= appnameCapitalized %>ServiceImpl.class);
    private final <%= appnameCapitalized %>Properties <%= appname %>Properties;
//    private final RestTemplate restTemplate;

    @Autowired
    public <%= appnameCapitalized %>ServiceImpl(<%= appnameCapitalized %>Properties <%= appname %>Properties/*, RestTemplate restTemplate*/) {
        this.<%= appname %>Properties = <%= appname %>Properties;
//        this.restTemplate = restTemplate;
    }

    @Override
    public String send(String request) {
        log.debug("Request : {}, originator : {}", request, <%= appname %>Properties.getOriginator());
        return "Response for : " + request;
    }

}
