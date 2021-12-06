package br.com.musicsuggestions.repository;

import br.com.musicsuggestions.model.ReproductionHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReproductionHistoryRepository extends JpaRepository<ReproductionHistory, Long> {
}
