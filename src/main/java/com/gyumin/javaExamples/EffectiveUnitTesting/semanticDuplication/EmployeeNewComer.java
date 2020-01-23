package com.gyumin.javaExamples.EffectiveUnitTesting.semanticDuplication;

public class EmployeeNewComer implements EmployeePredicate {
	@Override
	public boolean test(final Employee employee) {
		return employee.isNewComer();
	}
}
