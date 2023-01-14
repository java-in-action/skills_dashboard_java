package com.accenture.skills.repository;

import java.math.BigInteger;
import java.util.List;

import com.accenture.skills.bean.Employee;
import com.accenture.skills.bean.Skill;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends CrudRepository<Skill, BigInteger> {

    List<Skill> findAll();
}