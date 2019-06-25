package at.nacs.apptruistic.security;

import at.nacs.apptruistic.domain.Organization;
import lombok.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

@Value
public class UserPrincipal implements UserDetails {
  private Organization organization;


  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    Set<String> authorities = organization.getAuthorities();

    return AuthorityUtils.createAuthorityList(authorities.toArray(new String[authorities.size()]));
  }

  @Override
  public String getPassword() {
    return organization.getPassword();
  }


  @Override
  public String getUsername() {
    return organization.getEmail();
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

  public Organization getUserDetails() {
    return organization;
  }
}
