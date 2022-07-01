package org.jointheleague.api.unisearch.presentation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class HomeControllerTest {
    private HomeController controller;
    @BeforeEach
    void setup() {
        controller = new HomeController();
    }
    @Test
    void whenHome_thenReturnRedirect() {
        //given
        String expected = "redirect:swagger-ui.html";
        //when
        String actual = controller.home();
        //then
        assertEquals(expected, actual);
    }
}
