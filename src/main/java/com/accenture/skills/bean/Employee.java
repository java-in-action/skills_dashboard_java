package com.accenture.skills.bean;

import com.accenture.skills.commons.utils.SkillsConstants;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = SkillsConstants.ID_COLUMN_TYPE)
	private Long id;
	@NotNull
	@NotEmpty
	@Size(max = 50)
	@Column
	private String eId;
	@NotNull
	@NotEmpty
	@Size(max = 30)
	@Column
	private String name;
	@Size(max = 30)
	@Column
	private String middleName;
	@NotNull
	@NotEmpty
	@Size(max = 100)
	@Column
	private String lastName;
	@NotNull
	@NotEmpty
	@Column
	private Integer level;
	@NotNull
	@NotEmpty
	@Size(max = 20)
	@Column
	private String location;
	@NotNull
	@NotEmpty
	@Column
	private LocalDate birthday;

}
