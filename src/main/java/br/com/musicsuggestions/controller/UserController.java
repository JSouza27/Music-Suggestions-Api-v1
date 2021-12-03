package br.com.musicsuggestions.controller;

import br.com.musicsuggestions.dto.MessageResponseDTO;
import br.com.musicsuggestions.model.User;
import br.com.musicsuggestions.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

  private UserRepository userRepository;

  @Autowired
  public UserController(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @PostMapping("/")
  public MessageResponseDTO create(@RequestBody User newUser) {
    User saveUser = userRepository.save(newUser);

    return MessageResponseDTO.builder()
        .message("Usuário criado com sucesso " + saveUser.getId())
        .build();
  }
}
