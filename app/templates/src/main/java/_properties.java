package <%= basePackage %>.config;

<%if (lombok) { %>import lombok.Getter;
import lombok.Setter;<% } %>
import org.springframework.boot.context.properties.ConfigurationProperties;

<%if (lombok) { %>@Setter
@Getter<% } %>
@ConfigurationProperties(prefix = "<%= appnameKebab %>")
public class <%= appnameCapitalized %>Properties {
<%if (useReactive) { %>
    private String url = "http://www.your-url.com";
//    private String username = "my-login";
//    private String password = "change-me";
<% } %>
}
