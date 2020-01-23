package com.gyumin.javaExamples.EffectiveUnitTesting.semanticDuplication.problem;

import com.gyumin.javaExamples.EffectiveUnitTesting.semanticDuplication.Employee;
import com.gyumin.javaExamples.EffectiveUnitTesting.semanticDuplication.EmployeeGroup;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 구조 중복 테스트
 *
 * 의미 중복 테스트(SemanticDuplicationTest.java)의 개선을 위해
 * 1차적으로 구조 중복으로 바꾼 형태이다.
 */
public class StructuralDuplicationTest {

	private EmployeeGroup group;

	@Test
	public void groupShouldContainTwoSupervisors() {
		List<Employee> supervisors = new ArrayList<>();
		for (Employee employee : group.list()) {
			if (employee.isSupervisor()) {
				supervisors.add(employee);
			}
		}
		assertThat(supervisors.size()).isEqualTo(2);
	}

	@Test
	public void groupShouldContainFiveNewcomers() {
		List<Employee> newcomers = new ArrayList<>();
		for (Employee employee : group.list()) {
			if (employee.isNewComer()) {
				newcomers.add(employee);
			}
		}
		assertThat(newcomers.size()).isEqualTo(5);
	}
}
