package com.capstone.trend.repository;

import com.capstone.trend.domain.Keywordcount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface KeywordcountReopsitory extends JpaRepository<Keywordcount, Long> {

    @Query(value = "select * from keyword_count", nativeQuery = true)
    List<Keywordcount> find_all();


}
