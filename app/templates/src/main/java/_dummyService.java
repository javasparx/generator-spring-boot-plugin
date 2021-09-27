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
        havingValue = "true",
        matchIfMissing = true
)
public class Dummy<%= appnameCapitalized %>ServiceImpl implements <%= appnameCapitalized %>Service {
<%if (!lombok) { %>
    private final Logger log = LoggerFactory.getLogger(<%= appnameCapitalized %>ServiceImpl.class);
<% } %>
    public Dummy<%= appnameCapitalized %>ServiceImpl() {
        log.debug("############### <%= appnameCapitalized %> simulation is ON ###############");
    }

//    @Override
//    public String send(String request) {
//        log.debug("Dummy request : {}", request);
//        return "Response for : " + request;
//    }

}
