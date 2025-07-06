package com.cognizant.orm_learn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.orm_learn.model.Skill;

public interface SkillRepository extends JpaRepository<Skill, Integer> {
}
