package <%= basePackage %>.service;

public interface <%= appnameCapitalized %>Service {

    String NAME = "<%= appname %>Service";

    String send(String request);
}
