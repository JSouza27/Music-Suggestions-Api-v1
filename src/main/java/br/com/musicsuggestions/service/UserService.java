package br.com.musicsuggestions.service;

import br.com.musicsuggestions.dto.MessageResponseDTO;
import br.com.musicsuggestions.model.User;
import br.com.musicsuggestions.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UserService {

  private UserRepository userRepository;

  @Autowired
  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public MessageResponseDTO create(User newUser) {
    User saveUser = userRepository.save(newUser);

    return MessageResponseDTO.builder()
      .message("Usuário criado com sucesso " + saveUser.getId())
      .build();
  }
}
