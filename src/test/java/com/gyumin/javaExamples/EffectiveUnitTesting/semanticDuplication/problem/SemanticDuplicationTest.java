package com.gyumin.javaExamples.EffectiveUnitTesting.semanticDuplication.problem;

import com.gyumin.javaExamples.EffectiveUnitTesting.semanticDuplication.Employee;
import com.gyumin.javaExamples.EffectiveUnitTesting.semanticDuplication.EmployeeGroup;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 의미 중복 테스트
 *
 * 의미 중복이란, 같은 기능이나 개념을 다른 방식으로 구현한 것이다.
 * 상수 중복이나 구조 중복에 비해 맨 눈으로 찾기 어렵다.
 */
public class SemanticDuplicationTest {

	private EmployeeGroup group;

	@Test
	public void groupShouldContainTwoSupervisors() {
		List<Employee> all = group.list();
		List<Employee> employees = new ArrayList<>(all);

		Iterator<Employee> i = employees.iterator();
		while (i.hasNext()) {
			Employee employee = i.next();
			if (!employee.isSupervisor()) {
				i.remove();
			}
		}
		assertThat(employees.size()).isEqualTo(2);
	}

	@Test
	public void groupShouldContainFiveNewcomers() {
		List<Employee> newcomers = new ArrayList<>();
		for (Employee employee : group.list()) {
			LocalDateTime oneYearAgo = LocalDateTime.now().minusYears(1);
			if (employee.getStartingDate().isAfter(oneYearAgo)) {
				newcomers.add(employee);
			}
		}
		assertThat(newcomers.size()).isEqualTo(5);
	}
}
