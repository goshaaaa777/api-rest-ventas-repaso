package cibertec.edu.api_rest_ventas.service;

import cibertec.edu.api_rest_ventas.model.bd.Category;
import cibertec.edu.api_rest_ventas.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CategoryService implements  ICategoryService{
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> listCategorias() {
        return categoryRepository.findAll();
    }

    @Override
    public Category guardarCategoria(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Optional<Category>  obtenerCategoriaxID(Integer id) {
        Optional<Category> category
                = categoryRepository.findById(id);
        if (category.isEmpty()){
            return Optional.empty();
        }
        return category;
    }
}
