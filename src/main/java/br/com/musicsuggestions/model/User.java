package br.com.musicsuggestions.model;

import javax.persistence.*;

@Entity
@Table(name="users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name= "first_name",nullable = false)
  private String firstName;

  @Column(name= "last_name",nullable = false)
  private String lastName;

  @Column(nullable = true)
  private String email;

  @Column(nullable = true)
  private String password;

  @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
  @JoinColumn(name= "address_id")
  private Address address;
}
