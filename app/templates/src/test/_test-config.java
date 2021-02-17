package <%= basePackage %>.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import <%= basePackage %>.config.<%= appnameCapitalized %>Configuration;
import <%= basePackage %>.service.<%= appnameCapitalized %>Service;

import static org.junit.Assert.*;

@Configuration
@ComponentScan("<%= basePackage %>")
public class TestConfig {

}
