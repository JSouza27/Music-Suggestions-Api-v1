package br.com.musicsuggestions.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MessageResponseDTO {

  private String message;
}
