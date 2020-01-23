package com.gyumin.javaExamples.EffectiveUnitTesting.semanticDuplication;

import java.util.List;

public class EmployeeGroup {

	private List<Employee> employees;

	public EmployeeGroup(final List<Employee> employees) {
		this.employees = employees;
	}

	public List<Employee> list() {
		return this.employees;
	}
}
