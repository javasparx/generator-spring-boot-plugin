package <%= basePackage %>.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//import org.springframework.beans.factory.annotation.Qualifier;
import <%= basePackage %>.config.<%= appnameCapitalized %>Properties;
import <%= basePackage %>.service.<%= appnameCapitalized %>Service;
<%if (lombok) { %>import lombok.extern.slf4j.Slf4j;<% } %>

import static <%= basePackage %>.service.<%= appnameCapitalized %>Service.NAME;

<%if (lombok) { %>@Slf4j<% } %>
@Service(NAME)
@ConditionalOnProperty(
        prefix = "<%= appnameKebab %>",
        name = "simulate",
        havingValue = "false"
)
public class <%= appnameCapitalized %>ServiceImpl implements <%= appnameCapitalized %>Service {
<%if (!lombok) { %>
    private final Logger log = LoggerFactory.getLogger(<%= appnameCapitalized %>ServiceImpl.class);
<% } %>
    private final <%= appnameCapitalized %>Properties <%= appname %>Properties;
//    private final RestTemplate <%= appname %>RestTemplate;

    @Autowired
    public <%= appnameCapitalized %>ServiceImpl(<%= appnameCapitalized %>Properties <%= appname %>Properties/*, @Qualifier("<%= appname %>RestTemplate") RestTemplate <%= appname %>RestTemplate*/) {
        this.<%= appname %>Properties = <%= appname %>Properties;
//        this.<%= appname %>RestTemplate = <%= appname %>RestTemplate;
    }

//    @Override
//    public String send(String request) {
//        log.debug("Request : {}, name : {}", request, <%= appname %>Properties.getName());
//        return "Response for : " + request;
//    }

}
