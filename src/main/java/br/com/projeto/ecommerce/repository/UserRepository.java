//package br.com.projeto.ecommerce.repository;
//
//import br.com.projeto.ecommerce.entity.User;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public interface UserRepository extends JpaRepository<User, Long> {
//
//    @Query("SELECT u FROM User where u.userName =:userName")
//    User findByUsername(@Param("userName") String userName);
//}
