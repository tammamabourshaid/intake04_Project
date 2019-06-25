package at.nacs.apptruistic.security;

import at.nacs.apptruistic.domain.Organization;
import at.nacs.apptruistic.repository.OrganizationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

  private final OrganizationRepository repository;

  @Override
  public UserDetails loadUserByUsername(String email) {
    Optional<Organization> organization = repository.findOneByEmail(email);
    if (organization.isEmpty()) {
      throw new UsernameNotFoundException(email);
    }
    return new UserPrincipal(organization.get());
  }
}
