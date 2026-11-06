package inventory.bomlines;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BomLineRepository extends JpaRepository<BomLine, Long> {
}
