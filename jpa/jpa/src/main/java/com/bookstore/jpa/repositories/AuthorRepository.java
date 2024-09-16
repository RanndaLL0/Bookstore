package com.bookstore.jpa.repositories;
import com.bookstore.jpa.models.AuthorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.UUID;

public interface AuthorRepository extends JpaRepository<AuthorModel,UUID> {
    AuthorModel findAuthorModelByName(String name);

    @Query(value = "SELECT * FROM tb_author WHERE author_id = :id", nativeQuery = true)
    List<AuthorModel> findAuthorsById(@Param("id") UUID id);
}
