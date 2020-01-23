package com.gyumin.javaExamples.EffectiveUnitTesting.semanticDuplication;

@FunctionalInterface
public interface EmployeePredicate {
	boolean test(Employee employee);
}
