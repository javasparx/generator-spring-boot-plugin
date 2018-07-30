package <%= basePackage %>.service.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import <%= basePackage %>.config.<%= appnameCapitalized %>Configuration;
import <%= basePackage %>.service.<%= appnameCapitalized %>Service;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {<%= appnameCapitalized %>Configuration.class, <%= appnameCapitalized %>ServiceImpl.class})
public class <%= appnameCapitalized %>ServiceImplTest {

    @Autowired
    private <%= appnameCapitalized %>Service <%= appname %>Service;

    @Before
    public void setUp() {
        //Do something on starting
    }

    @After
    public void tearDown() {
        //Do something on finishing
    }

    @Test
    public void testSend() {
        String response = <%= appname %>Service.send("Hi, Javlon");
        assertEquals("Response for : Hi, Javlon", response);
    }
}