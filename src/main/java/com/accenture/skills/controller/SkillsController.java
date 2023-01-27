package com.accenture.skills.controller;

import com.accenture.skills.bean.Skill;
import com.accenture.skills.service.SkillService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1")
public class SkillsController {

    @Autowired
    private SkillService skillService;

    @GetMapping(
            value = "/skills",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public DeferredResult<List<Skill>> getEmployees() {
        DeferredResult<List<Skill>> result = new DeferredResult<>();
        result.setResult(skillService.findEmployees());

        return result;
    }
}
