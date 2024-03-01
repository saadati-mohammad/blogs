package blogs.modules.users.repository;

import blogs.modules.users.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Timestamp;

public interface UsersRepository extends JpaRepository<Users, Long> {

Users findByEmail(String email);
Users findByName(String name);
Users findByPassword(String password);
Users findByCreatedAtNotContaining(Timestamp createdAt);

@Query("select u from Users u where u.email =: email")
Users findUserByEmailWithName(@Param("nameAndEmail") String nameAndEmail);

@Query(nativeQuery=true,value="select * from users")
Users getEveryThing();

//    Users findByEmail(String email);
//
//    @Query("select u from Users u where u.email =: email")
//    Users userEmail(@Param("email") String email);
}
