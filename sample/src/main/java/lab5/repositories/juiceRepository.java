package lab5.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import lab5.entity.Juice;

//@RepositoryRestResource(collectionResourceRel = "juice", path = "juice")

@RepositoryRestResource
@CrossOrigin(origins = "*")
public interface juiceRepository extends JpaRepository<Juice, Long> {
//  List<Juice> findByTitle(@Param("title") String title);	
}
