package at.nacs.apptruistic.repository;

import at.nacs.apptruistic.domain.Organization;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface OrganizationRepository extends MongoRepository<Organization, String> {

  Optional<Organization> findOneByEmail(String email);
}
