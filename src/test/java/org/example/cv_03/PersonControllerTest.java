package org.example.cv_03;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.cv_03.controllers.PersonController;
import org.example.cv_03.entities.Person;
import org.example.cv_03.services.IPersonService;
import org.example.cv_03.services.IPersonServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@Import(PersonController.class)
@WebMvcTest(PersonController.class)
public class PersonControllerTest {

    @Autowired
    MockMvc mock;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    IPersonService mockIPersonService;

    IPersonServiceImpl personService = new IPersonServiceImpl();

    @Test
    @WithMockUser(username = "nnpia", password = "nnpia")
    public void getPersonByIdTest() throws Exception{
        Person testPerson = personService.listPersons().get(0);

        given(mockIPersonService.getPersonById(any(Long.class))).willReturn(testPerson);

        mock.perform(get("/api/app-user/v1/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is(((Person) testPerson).getId().toString())))
                .andExpect(jsonPath("$.username", is(testPerson.getUsername())));
    }

    /* TODO test pro POST*/

}
