package com.capstone.trend.repository;

import com.capstone.trend.domain.Keywordcount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface KeywordcountReopsitory extends JpaRepository<Keywordcount, Long> {

    @Query(value = "select keyword,ipc_code,count,rank from keyword_count", nativeQuery = true)
    List<Keywordcount> find_all();

    @Query(value = "select keyword,ipc_code,count,rank from keyword_count where keyword=:keyword", nativeQuery = true)
    List<Keywordcount> findByKeyword(@Param("keyword") String keyword);

    @Query(value = "select keyword, ipc_code, count, rank from keyword_count where ipc_code=:ipcCode", nativeQuery = true)
    List<Keywordcount> findByIpcCode(@Param("ipcCode")String ipcCode);
}
