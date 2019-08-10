package <%= basePackage %>.config;

<%if (lombok) { %>import lombok.Getter;
import lombok.Setter;<% } %>
import org.springframework.boot.context.properties.ConfigurationProperties;

<%if (lombok) { %>@Setter
@Getter<% } %>
@ConfigurationProperties(prefix = "<%= appnameKebab %>")
public class <%= appnameCapitalized %>Properties {
    private String name = "<%= appnameKebab %>-sample2";
}
