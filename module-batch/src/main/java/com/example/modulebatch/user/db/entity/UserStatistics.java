package com.example.modulebatch.user.db.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;

@Entity
@Getter
public class UserStatistics {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long user_stat_id;

	@Column(name = "statistics_at", unique = true)
	private LocalDateTime statisticsAt;

	@Column(name = "registered_count")
	private Integer registeredCount;

	public static UserStatistics create(int registeredCount) {
		UserStatistics statistics = new UserStatistics();
		statistics.registeredCount = registeredCount;
		statistics.statisticsAt = LocalDateTime.now().minusDays(1);
		return statistics;
	}
}
