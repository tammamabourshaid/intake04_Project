package at.nacs.apptruistic.logic;

import at.nacs.apptruistic.domain.Organization;
import at.nacs.apptruistic.security.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginManager {

  public Organization getCurrentUser() {
    UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
    validatePrinciple(authentication.getPrincipal());
    Organization organization = ((UserPrincipal) authentication.getPrincipal()).getOrganization();
    return organization;
  }

  private void validatePrinciple(Object principal) {
    if (!(principal instanceof UserPrincipal)) {
      throw new IllegalArgumentException("Principal can not be null!");
    }
  }
}
