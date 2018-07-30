package <%= basePackage %>.config;

<%if (lombok) { %>import lombok.Getter;
import lombok.Setter;<% } %>
import org.springframework.boot.context.properties.ConfigurationProperties;

<%if (lombok) { %>@Setter
@Getter<% } %>
@ConfigurationProperties(prefix = "<%= appname %>")
public class <%= appnameCapitalized %>Properties {
    private String originator = "abc123";
}
