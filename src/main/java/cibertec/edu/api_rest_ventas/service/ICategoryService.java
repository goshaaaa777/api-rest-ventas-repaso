package cibertec.edu.api_rest_ventas.service;

import cibertec.edu.api_rest_ventas.model.bd.Category;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {
    List<Category> listCategorias();
    Category guardarCategoria(Category category);
    Optional<Category> obtenerCategoriaxID(Integer id);
}
