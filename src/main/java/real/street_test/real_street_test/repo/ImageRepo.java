package real.street_test.real_street_test.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import real.street_test.real_street_test.entity.Image;

import java.util.UUID;

public interface ImageRepo extends JpaRepository<Image, UUID> {
}
