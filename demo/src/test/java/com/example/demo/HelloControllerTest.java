package com.example.demo;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

/*
    Used to inject a MockMvc instance
    @SpringBootTest : creates the whole application context
        instead, you could just use @WebMvcTest to only create the web layers of the context
    Either way, spring boot auto tries to locate the main app class of your app.
        But it can be overriden and narrowed down, if you want to build something different.
*/
@SpringBootTest 
@AutoConfigureMockMvc
public class HelloControllerTest {

    /*
        MockMvc comes from Spring Test and lets you , through a set of convenient builder classes
            send HTTP requests into the DispatcherServlet and make assertions about the result
    */
    @Autowired
    private MockMvc mvc;

    @Test
    public void getHello() throws Exception{

        mvc.perform(get("/").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().string(equalTo("Greetings from Spring Boot!")));

    }
    
}
