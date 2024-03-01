package blogs.modules.posts.model;

import blogs.modules.users.model.Users;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "posts_tbl")
public class Posts {

    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String body;
    private String cover;

    @ManyToOne
    private Users users;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;
}
