package com.gyumin.javaExamples.EffectiveUnitTesting.semanticDuplication.solution2;

import com.gyumin.javaExamples.EffectiveUnitTesting.semanticDuplication.Employee;
import com.gyumin.javaExamples.EffectiveUnitTesting.semanticDuplication.EmployeeGroup;
import com.gyumin.javaExamples.EffectiveUnitTesting.semanticDuplication.EmployeePredicate;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 의미 중복 테스트 개선 2
 *
 * PredicateTest와는 달리 EmployeePredicate의 개별 구현체를 생성하지 않고,
 * custom 단언 메서드의 인자로 익명 클래스를 넘기는 방식이다.
 */
public class AnonymousClassTest {

	private EmployeeGroup group;

	@Test
	public void groupShouldContainTwoSupervisors() {
		assertContainCertainNumberOfEmployees(new EmployeePredicate() {
			@Override
			public boolean test(final Employee employee) {
				return employee.isSupervisor();
			}
		}, 2);
	}

	@Test
	public void groupShouldContainFiveNewcomers() {
		assertContainCertainNumberOfEmployees(new EmployeePredicate() {
			@Override
			public boolean test(final Employee employee) {
				return employee.isNewComer();
			}
		}, 5);
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
