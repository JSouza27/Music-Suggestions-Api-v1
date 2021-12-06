package br.com.musicsuggestions.service;

import br.com.musicsuggestions.dto.UserDTO;
import br.com.musicsuggestions.repository.UserRepository;
import br.com.musicsuggestions.utils.UserUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

  @Mock
  private UserRepository userRepository;
  
  @InjectMocks
  private UserService userService;

  @Test
  void returnsTheUserWhenPassedTheId() {
    UserDTO expectedFoundUser = UserUtils.createFakeUserDTO();

    Mockito.when(userRepository.findById(expectedFoundUser.getId()))
      .thenReturn(Optional.of(expectedFoundUser));

    UserDTO userDTO = userService.findById(expectedFoundUser.getId());

    Assertions.assertEquals(expectedFoundUser.getEmail(), userDTO.getEmail());
  }
}
