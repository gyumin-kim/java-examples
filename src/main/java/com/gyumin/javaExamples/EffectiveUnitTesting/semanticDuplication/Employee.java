package com.gyumin.javaExamples.EffectiveUnitTesting.semanticDuplication;

import java.time.LocalDateTime;

public class Employee {

	private LocalDateTime startingDate;

	public Employee(final LocalDateTime startingDate) {
		this.startingDate = startingDate;
	}

	public LocalDateTime getStartingDate() {
		return startingDate;
	}

	public boolean isSupervisor() {
		return false;
	}

	public boolean isNewComer() {
		return false;
	}
}
