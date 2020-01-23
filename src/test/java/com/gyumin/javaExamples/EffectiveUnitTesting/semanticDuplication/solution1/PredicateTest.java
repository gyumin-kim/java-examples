package com.gyumin.javaExamples.EffectiveUnitTesting.semanticDuplication.solution1;

import com.gyumin.javaExamples.EffectiveUnitTesting.semanticDuplication.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 의미 중복 테스트 개선 1
 *
 * 의미 중복 테스트를 1차적으로 구조 중복으로 개선(StructuralDuplicationTest.java)한 다음,
 * 변수나 메서드를 추출하여 구조 중복을 제거한 형태이다.
 *
 * 즉 의미 중복은 먼저 구조 중복으로 개선한 다음,
 * 최종적으로 변수나 메서드를 추출하여 구조 중복을 제거하는 방식으로 해결하면 된다.
 *
 * PredicateTest는 EmployeePredicate라는 interface를 만들고,
 * 각각의 구현체를 custom 단언 메서드에 넘기는 방식이다.
 * (boolean 값을 리턴하는 함수를 Predicate이라고 한다.)
 */
public class PredicateTest {

	private EmployeeGroup group;

	@Test
	public void groupShouldContainTwoSupervisors() {
		assertContainCertainNumberOfEmployees(new EmployeeSupervisor(), 5);
	}

	@Test
	public void groupShouldContainFiveNewcomers() {
		assertContainCertainNumberOfEmployees(new EmployeeNewComer(), 2);
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
