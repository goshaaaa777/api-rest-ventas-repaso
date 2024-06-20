package cibertec.edu.api_rest_ventas.controller;

import cibertec.edu.api_rest_ventas.exception.ResourceNotFoundException;
import cibertec.edu.api_rest_ventas.model.bd.Category;
import cibertec.edu.api_rest_ventas.repository.CategoryRepository;
import cibertec.edu.api_rest_ventas.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/v1/category")
public class CategoryControler {

    private CategoryService categoryService;
    @GetMapping("")
    public ResponseEntity<List<Category>> listarCategorias(){
        List<Category> categoryList = new ArrayList<>(categoryService.listCategorias());
        if(categoryList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Category> obtenerCategoriaXid(
            @PathVariable Integer id){
        Category category = categoryService
                .obtenerCategoriaxID(id).orElseThrow(
                        () ->new ResourceNotFoundException("La Categoria con Id " +
                               id + " no existe" ));
        return  new ResponseEntity<>(category, HttpStatus.OK);
    }
@PostMapping("")
    public ResponseEntity<Category> registrarCategoria(
            @RequestBody Category category
    ){
        return new ResponseEntity<>(
                categoryService.guardarCategoria(category),HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Category> actualizarCategoria(
            @PathVariable Integer id,
            @RequestBody Category category
    ){
        Category  newCategory = categoryService.obtenerCategoriaxID(id)
                .orElseThrow(() ->new ResourceNotFoundException("La Categoria con Id "
                + id + " no existe"));
        newCategory.setCategoryname(category.getCategoryname());
        newCategory.setDescription(category.getDescription());
        return new ResponseEntity<>(
                categoryService.guardarCategoria(newCategory),
                HttpStatus.OK);
    }
}
