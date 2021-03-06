package com.example.repository;

import com.example.entity.Language;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageDao extends CrudRepository<Language, Long> {
}
