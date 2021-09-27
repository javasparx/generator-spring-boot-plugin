package <%= basePackage %>.config;

<%if (useReactive) { %>
import java.nio.charset.StandardCharsets;
import org.springframework.util.Base64Utils;
//import io.netty.handler.logging.LogLevel;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;
import javax.net.ssl.SSLException;
import reactor.netty.http.client.HttpClient;
//import reactor.netty.transport.logging.AdvancedByteBufFormat;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.http.MediaType;
import org.springframework.http.HttpHeaders;<% } %>

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

<%if (useReactive) { %>
    @Bean("<%= appname %>-web-client")
    public WebClient webClient(<%= appnameCapitalized %>Properties <%= appname %>Properties) throws SSLException {

        SslContext sslContext = SslContextBuilder
            .forClient()
            .trustManager(InsecureTrustManagerFactory.INSTANCE)
            .build();

        HttpClient httpClient = HttpClient
            .create().secure(t -> t.sslContext(sslContext))
//            .wiretap("reactor.netty.http.client.HttpClient", LogLevel.DEBUG, AdvancedByteBufFormat.TEXTUAL)
            ;

        return WebClient.builder()
            .clientConnector(new ReactorClientHttpConnector(httpClient))
            .baseUrl(<%= appname %>Properties.getUrl())
    //        .defaultHeader(HttpHeaders.AUTHORIZATION, "Basic " + Base64Utils.encodeToString((<%= appname %>Properties.getUsername() + ":" + <%= appname %>Properties.getPassword()).getBytes(StandardCharsets.UTF_8)))
            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
    //                .filters(exchangeFilterFunctions -> {
    //                    exchangeFilterFunctions.add(logRequest());
    //                    exchangeFilterFunctions.add(logResponse());
    //                })
            .build();
    }
<% } %>

}
