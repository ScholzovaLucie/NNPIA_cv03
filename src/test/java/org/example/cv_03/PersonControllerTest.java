package org.example.cv_03;

import org.example.cv_03.controllers.PersonController;
import org.example.cv_03.entities.Person;
import org.example.cv_03.repository.PersonRepository;
import org.example.cv_03.services.PersonService;
import org.example.cv_03.services.PersonServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import java.awt.*;
import static org.hamcrest.core.Is.is;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(PersonController.class)
public class PersonControllerTest {

    @Autowired
    MockMvc mock;

    @MockBean
    PersonService mockPersonService;

    PersonServiceImpl personService = new PersonServiceImpl();

    @Test
    public void getPersonByIdTest() throws Exception{
        Person testPerson = personService.listPersons().get(0);

        given(mockPersonService.getPersonById(any(Long.class))).willReturn(testPerson);

        mock.perform((RequestBuilder) get("/api/app-user/v1/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is(testPerson.getId().toString())))
                .andExpect(jsonPath("$.username", is(testPerson.getUsername())));
    }

    /* TODO test pro POST*/

}
