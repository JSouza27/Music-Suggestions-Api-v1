package br.com.musicsuggestions.model;

import javax.persistence.*;

@Entity
public class ReproductionHistory {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "play_list")
  private String playList;

  @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
  @JoinColumn(name = "user_id")
  private User userId;
}
