package blogs.modules.posts.controller;

import blogs.modules.posts.model.Posts;
import blogs.modules.posts.service.PostsService;
import blogs.modules.users.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/posts")
public class PostsController {

    private PostsService postsService;

    @Autowired
    public PostsController(PostsService postsService) {
        this.postsService = postsService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String showRegisterPosts(){
        return "posts/registerPosts";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String registerPosts(@ModelAttribute Posts posts) throws IOException {
        postsService.registerPost(posts);
        return "posts/registerPosts";
    }

    @RequestMapping(value = "/rest", method = RequestMethod.POST)
    public @ResponseBody Posts registerPost(@RequestBody Posts posts) throws IOException {
        return this.postsService.registerPost(posts);
    }

    @RequestMapping(value = "/rest", method = RequestMethod.GET)
    public @ResponseBody
    List<Posts> getPosts() {
        return this.postsService.findAllPosts();
    }
}
