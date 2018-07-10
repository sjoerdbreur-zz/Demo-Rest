package com.mendix.restapi.repository;

import com.mendix.restapi.model.RecipeHead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RecipeHeadRepository extends JpaRepository<RecipeHead,String> {
}
