package blogs.modules.posts.controller;
import blogs.modules.posts.model.Category;
import blogs.modules.posts.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping(value = {"/",""},method = RequestMethod.POST)
    public Category registerCategory(@RequestBody Category category){
        return this.categoryService.registerCategory(category);
    }

    @RequestMapping(value = {"/",""}, method = RequestMethod.GET)
    public List<Category> findAllCategories(){
        return this.categoryService.findAllCategory();
    }
}
