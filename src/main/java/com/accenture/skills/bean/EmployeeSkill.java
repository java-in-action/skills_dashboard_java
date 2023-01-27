package com.accenture.skills.bean;

import com.accenture.skills.commons.utils.SkillsConstants;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(uniqueConstraints = {
    @UniqueConstraint(
            columnNames = {
                    EmployeeSkill.EMPLOYEE_COLUMN,
                    EmployeeSkill.SKILL_COLUMN
            })
})
public class EmployeeSkill {

    public static final String EMPLOYEE_COLUMN = "employee_id";
    public static final String SKILL_COLUMN = "skill_id";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = SkillsConstants.ID_COLUMN_TYPE)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    private Employee employee;

    @ManyToOne(cascade = CascadeType.ALL)
    private Skill skill;
}
