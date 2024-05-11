package com.restapp.ticketmanagement.nonreactive;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.restapp.ticketmanagement.pojo.User;

@WebMvcTest(UserControllerNonReactive.class)
public class UserControllerNonReactiveTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserServiceNonReactive userService;

    private ObjectMapper objectMapper = new ObjectMapper();

    private User user1;
    private User user2;

    @BeforeEach
    public void setUp() {
        user1 = new User(1, "Alice");
        user2 = new User(2, "Bob");
    }

    @Test
    public void testGetAllUsers() throws Exception {
        List<User> users = Arrays.asList(user1, user2);
        when(userService.getAllUsers()).thenReturn(users);

        mockMvc.perform(get("/tms/v1/users"))
               .andExpect(status().isOk())
               .andExpect(content().contentType("application/json"))
               .andExpect(jsonPath("$[0].id", is(1)))
               .andExpect(jsonPath("$[0].name", is("Alice")))
               .andExpect(jsonPath("$[1].id", is(2)))
               .andExpect(jsonPath("$[1].name", is("Bob")));
    }

    @Test
    public void testGetUserById() throws Exception {
        when(userService.getUserById(1)).thenReturn(user1);

        mockMvc.perform(get("/tms/v1/users/{id}", 1))
               .andExpect(status().isOk())
               .andExpect(content().contentType("application/json"))
               .andExpect(jsonPath("$.id", is(1)))
               .andExpect(jsonPath("$.name", is("Alice")));
    }

    @Test
    public void testCreateUser() throws Exception {
        when(userService.createUser(Mockito.any(User.class))).thenReturn(user1);

        mockMvc.perform(post("/tms/v1/users")
               .contentType("application/json")
               .content(objectMapper.writeValueAsString(user1)))
               .andExpect(status().isOk())
               .andExpect(content().contentType("application/json"))
               .andExpect(jsonPath("$.id", is(1)))
               .andExpect(jsonPath("$.name", is("Alice")));
    }

    @Test
    public void testUpdateUser() throws Exception {
        when(userService.updateUser(1, user1)).thenReturn(user1);

        mockMvc.perform(put("/tms/v1/users/{id}", 1)
               .contentType("application/json")
               .content(objectMapper.writeValueAsString(user1)))
               .andExpect(status().isOk())
               .andExpect(content().contentType("application/json"))
               .andExpect(jsonPath("$.id", is(1)))
               .andExpect(jsonPath("$.name", is("Alice")));
    }

    @Test
    public void testDeleteUser() throws Exception {
        doNothing().when(userService).deleteUserById(1);

        mockMvc.perform(delete("/tms/v1/users/{id}", 1))
               .andExpect(status().isOk());
    }
}
