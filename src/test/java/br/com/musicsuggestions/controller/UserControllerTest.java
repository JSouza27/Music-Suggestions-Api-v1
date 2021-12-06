package br.com.musicsuggestions.controller;

import br.com.musicsuggestions.dto.MessageResponseDTO;
import br.com.musicsuggestions.dto.UserDTO;
import br.com.musicsuggestions.service.UserService;
import br.com.musicsuggestions.utils.UserUtils;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.net.URI;

import static br.com.musicsuggestions.utils.UserUtils.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

  public static final String USER_API_URL_PATH = "/api/v1/users/";

  private MockMvc mockMvc;

  @Mock
  private UserService userService;

  @InjectMocks
  private UserController userController;

  @BeforeEach
  void setUp() {
    mockMvc = MockMvcBuilders.standaloneSetup(userController)
      .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
      .setViewResolvers(((viewName, locale) -> new MappingJackson2JsonView()))
      .build();
  }

  @Test
  void testItMayBePossibleToCreateAUser() throws Exception {
    UserDTO userDTO = createFakeUserDTO();
    MessageResponseDTO expectedMessageResponse = MessageResponseDTO.builder()
      .message("Usuário criado com sucesso " + userDTO.getId())
      .build();

    Mockito.when(userService.create(userDTO)).thenReturn(expectedMessageResponse);

    mockMvc.perform(post(USER_API_URL_PATH)
      .contentType(MediaType.APPLICATION_JSON)
      .content(asJsonString(userDTO)))
      .andExpect(status().isOk())
      .andExpect(jsonPath("$.message", Is.is(expectedMessageResponse.getMessage())));
  }
}
