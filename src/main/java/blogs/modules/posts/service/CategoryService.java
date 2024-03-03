package blogs.modules.posts.service;
import blogs.modules.posts.model.Category;
import blogs.modules.posts.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category registerCategory(Category category){
        return this.categoryRepository.save(category);
    }

    public List<Category> findAllCategory(){
        return this.categoryRepository.findAll();
    }
}
