package br.com.musicsuggestions.utils;

import br.com.musicsuggestions.dto.UserDTO;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.github.javafaker.Faker;

public class UserUtils {

  private static final Faker faker = Faker.instance();

  public static UserDTO createFakeUserDTO() {
    return UserDTO.builder()
      .id(faker.number().randomNumber())
      .firstName(faker.name().firstName())
      .LastName(faker.name().lastName())
      .email(faker.name().username() + "@test.com")
      .passwrod("12345678")
      .build();
  }

  // Converte Json
  public static String asJsonString(UserDTO userDTO) {
    try {
      ObjectMapper objectMapper = new ObjectMapper();

      objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
      objectMapper.configure(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS, false);
      objectMapper.registerModule(new JavaTimeModule());

      return objectMapper.writeValueAsString(userDTO);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
