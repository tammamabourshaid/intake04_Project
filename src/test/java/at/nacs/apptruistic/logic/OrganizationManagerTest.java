package at.nacs.apptruistic.logic;

import at.nacs.apptruistic.domain.Organization;
import at.nacs.apptruistic.repository.OrganizationRepository;
import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ConfigurationProperties("dataset")
class OrganizationManagerTest {
  @SpyBean
  OrganizationManager manager;

  @Autowired
  OrganizationRepository repository;
  @Setter
  @Getter
  Organization organization;
  @Setter
  @Getter
  private List<Organization> organizations;

  @Bean
  PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @BeforeEach
  void before() {
    repository.saveAll(organizations);
  }

  @AfterEach
  void after() {
    repository.deleteAll();
  }

  @Test
  void testFindByEmail() {
    Organization organization1 = organizations.get(0);
    Optional<Organization> actual = manager.findByEmail(organization.getEmail());

    assertThat(actual.isPresent()).isTrue();
    assertThat(actual.get()).isEqualTo(organization1);
    assertThat(actual.get().getId()).isNotEmpty();
    assertThat(organizations.size()).isEqualTo(2);
  }
}