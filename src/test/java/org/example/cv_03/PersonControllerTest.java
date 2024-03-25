package org.example.cv_03;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.cv_03.controllers.PersonController;
import org.example.cv_03.entities.Person;
import org.example.cv_03.services.IPersonService;
import org.example.cv_03.services.PersonService;
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
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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

    PersonService personService = new PersonService();

    @Test
    @WithMockUser(username = "user", password = "password")
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

    @Test
    @WithMockUser(username = "user", password = "password")
    public void addPerson() throws Exception {
        Person person = new Person();
        person.setUsername("TestPerson");
        person.setPassword("test");

        given(personService.saveNewPerson(any(Person.class))).willReturn(person);

        mock.perform(post("/api/app-user/v1/app-person-add")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(person)))
                .andExpect(status().isCreated())
                .andExpect(header().exists("Location"));
    }

}
