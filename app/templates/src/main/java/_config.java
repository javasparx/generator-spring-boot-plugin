package <%= basePackage %>.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.boot.web.client.RestTemplateBuilder;
//import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.web.client.RestTemplate;

@Configuration
@EnableConfigurationProperties(<%= appnameCapitalized %>Properties.class)
public class <%= appnameCapitalized %>Configuration {

//    @Bean("<%= appname %>RestTemplate")
//    public RestTemplate <%= appname %>RestTemplate(RestTemplateBuilder restTemplateBuilder, <%= appnameCapitalized %>Properties <%= appname %>Properties) {
//        return restTemplateBuilder
//                .setReadTimeout(<%= appname %>Properties.getReadTimeout())
//                .setConnectTimeout(<%= appname %>Properties.getConnectTimeout())
//                .basicAuthorization(<%= appname %>Properties.getLogin(), <%= appname %>Properties.getPassword())
//                .build();
//    }

}
