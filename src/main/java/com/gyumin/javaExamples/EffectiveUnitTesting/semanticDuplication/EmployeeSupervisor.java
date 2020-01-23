package com.gyumin.javaExamples.EffectiveUnitTesting.semanticDuplication;

public class EmployeeSupervisor implements EmployeePredicate {
	@Override
	public boolean test(final Employee employee) {
		return employee.isSupervisor();
	}
}
