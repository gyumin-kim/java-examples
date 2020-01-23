package com.gyumin.javaExamples.EffectiveUnitTesting.semanticDuplication.solution3;

import com.gyumin.javaExamples.EffectiveUnitTesting.semanticDuplication.Employee;
import com.gyumin.javaExamples.EffectiveUnitTesting.semanticDuplication.EmployeeGroup;
import com.gyumin.javaExamples.EffectiveUnitTesting.semanticDuplication.EmployeePredicate;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 의미 중복 테스트 개선 3
 *
 * 람다를 사용함으로써 익명 클래스를 활용한 방법(AnonymousClassTest.java)보다
 * 더 간단한 방식이다.
 */
public class LambdaTest {

	private EmployeeGroup group;

	@Test
	public void groupShouldContainTwoSupervisors() {
		assertContainCertainNumberOfEmployees(employee -> employee.isSupervisor(), 5);
	}

	@Test
	public void groupShouldContainFiveNewcomers() {
		assertContainCertainNumberOfEmployees(employee -> employee.isNewComer(), 2);
	}

	private void assertContainCertainNumberOfEmployees(EmployeePredicate predicate, int size) {
		List<Employee> employees = new ArrayList<>();
		for (Employee employee : group.list()) {
			if (predicate.test(employee)) {
				employees.add(employee);
			}
		}
		assertThat(employees.size()).isEqualTo(size);
	}
}
