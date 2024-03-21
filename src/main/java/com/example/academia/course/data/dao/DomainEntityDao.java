package com.example.academia.course.data.dao;

import com.example.academia.course.data.entity.DomainEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomainEntityDao extends JpaRepository<DomainEntity, Integer> {

}
