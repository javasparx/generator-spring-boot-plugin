package <%= basePackage %>.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.boot.web.client.RestTemplateBuilder;
//import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.web.client.RestTemplate;

@Configuration
@EnableConfigurationProperties(<%= appnameCapitalized %>Properties.class)
public class <%= appnameCapitalized %>Configuration {

//    @Bean("playRestTemplate")
//    public RestTemplate playRestTemplate(RestTemplateBuilder restTemplateBuilder, PlaySmsProperties playSmsProperties) {
//        return restTemplateBuilder
//                .setReadTimeout(playSmsProperties.getReadTimeout())
//                .setConnectTimeout(playSmsProperties.getConnectTimeout())
//                .basicAuthorization(playSmsProperties.getLogin(), playSmsProperties.getPassword())
//                .build();
//    }

}
