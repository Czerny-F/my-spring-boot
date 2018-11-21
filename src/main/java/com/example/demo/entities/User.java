package com.example.demo.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.EnumType;
import javax.persistence.GenerationType;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Entity
@Data
@Table(name="users")
public class User implements UserDetails {

  private static final long serialVersionUID = 1L;
  public enum Authority {ROLE_USER, ROLE_ADMIN};

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Integer id;

  @Column(nullable=false, unique=true)
  private String username;

  @Column(nullable=false)
  private String password;

  @Enumerated(EnumType.STRING)
  private Authority authority;

  protected User() {}

  public User(String username, String password) {
    this.username = username;
    this.password = password;
    this.authority = Authority.ROLE_USER;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    List<GrantedAuthority> authorities = new ArrayList<>();
    authorities.add(new SimpleGrantedAuthority(authority.toString()));
    return authorities;
  }

  @Override
  public String getUsername() {
    return username;
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
