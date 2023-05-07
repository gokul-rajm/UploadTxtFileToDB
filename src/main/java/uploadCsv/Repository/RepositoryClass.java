package uploadCsv.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import uploadCsv.Entity.EntityClass;

public interface RepositoryClass extends JpaRepository<EntityClass, Integer> {
}