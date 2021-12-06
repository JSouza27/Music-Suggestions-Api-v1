package br.com.musicsuggestions.controller;

import br.com.musicsuggestions.dto.MessageResponseDTO;
import br.com.musicsuggestions.dto.UserDTO;
import br.com.musicsuggestions.model.User;
import br.com.musicsuggestions.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

  private UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping(value = "/", consumes = "application/json", produces = "application/json")
  public MessageResponseDTO create(@Valid @RequestBody UserDTO userDTO) {
    return userService.create(userDTO);
  }

  @GetMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
  public User findById(@PathVariable Long id) {
    return userService.findById(id);
  }
}
