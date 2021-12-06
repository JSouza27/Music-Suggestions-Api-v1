package br.com.musicsuggestions.repository;

import br.com.musicsuggestions.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRpository extends JpaRepository<User, Long> {
}
