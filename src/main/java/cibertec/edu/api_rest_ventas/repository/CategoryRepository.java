package cibertec.edu.api_rest_ventas.repository;

import cibertec.edu.api_rest_ventas.model.bd.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
