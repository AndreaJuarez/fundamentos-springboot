package com.fundamentosplatzi.springboot.fundamentos.repository;
import com.fundamentosplatzi.springboot.fundamentos.entity.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository <User,Long> {
    //Querys con JPQL
    @Query("SELECT u FROM User u WHERE u.email=?1")
    Optional<User> findByUserEmail(String email);

    @Query("SELECT u FROM User u WHERE u.name like ?1%")
    List<User> findAndSort(String name, Sort sort);

    //Query Methods
    List<User> findByName(String name);
    Optional<User> findByEmailAndName(String email,String name);

    List<User> findByNameLike(String name);
    List<User> findByNameOrEmail(String name, String email);
    List<User> findByBirthdayBetween(LocalDate begin, LocalDate end);

    List<User> findByNameLikeOrderByIdDesc(String name);

}
