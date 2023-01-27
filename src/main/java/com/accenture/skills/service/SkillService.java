package com.accenture.skills.service;

import com.accenture.skills.bean.Skill;
import com.accenture.skills.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillService {

    @Autowired
    private SkillRepository skillRepository;

    public List<Skill> findEmployees() {
        return skillRepository.findAll();
    }
}
