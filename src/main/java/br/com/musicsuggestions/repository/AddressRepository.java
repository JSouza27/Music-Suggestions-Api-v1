package br.com.musicsuggestions.repository;

import br.com.musicsuggestions.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
