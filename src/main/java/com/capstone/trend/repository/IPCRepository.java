package com.capstone.trend.repository;

import com.capstone.trend.domain.IPC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IPCRepository extends JpaRepository<IPC, Integer> {

    @Query(value = "select * from ipc_list", nativeQuery = true)
    List<IPC> find_all();

}