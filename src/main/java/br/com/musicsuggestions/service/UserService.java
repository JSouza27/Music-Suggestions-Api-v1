package br.com.musicsuggestions.service;

import br.com.musicsuggestions.dto.MessageResponseDTO;
import br.com.musicsuggestions.dto.UserDTO;
import br.com.musicsuggestions.model.User;
import br.com.musicsuggestions.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
public class UserService {

  private UserRepository userRepository;

  @Autowired
  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public MessageResponseDTO create(UserDTO userDTO) {
    User userToSave = User.builder()
      .firstName(userDTO.getFirstName())
      .LastName(userDTO.getLastName())
      .email(userDTO.getEmail())
      .passwrod(userDTO.getPasswrod())
      .build();
    User saveUser = userRepository.save(userToSave);

    return MessageResponseDTO.builder()
      .message("Usuário criado com sucesso " + saveUser.getId())
      .build();
  }

  public User findById(Long id) {
    Optional<User> optionalUser = userRepository.findById(id);

    return optionalUser.get();
  }
}
