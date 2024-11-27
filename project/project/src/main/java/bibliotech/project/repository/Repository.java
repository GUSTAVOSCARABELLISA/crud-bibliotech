package bibliotech.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import bibliotech.project.model.Model;

public interface Repository extends JpaRepository<Model,Long> {

}
