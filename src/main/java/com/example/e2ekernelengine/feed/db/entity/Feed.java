package com.example.e2ekernelengine.feed.db.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.example.e2ekernelengine.blog.db.entity.Blog;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "feed")
public class Feed {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "feed_id", columnDefinition = "BIGINT", nullable = false)
	private Long feedId;

	// Blog Entity와 연관관계 섧정
	@ManyToOne
	@JoinColumn(name = "blog_id")
	private Blog blog;

	@Column(name = "feed_url", nullable = false)
	private String feedUrl;

	@Column(name = "feed_title", columnDefinition = "VARCHAR(100)")
	private String feedTitle;

	@Column(name = "feed_description", columnDefinition = "TEXT")
	private String feedDescription;

	@Column(name = "feed_content", nullable = false)
	private String feedContent;

	@CreationTimestamp
	@Column(name = "feed_created_at", nullable = false)
	private Timestamp feedCreatedAt;

	@Builder
	public Feed(Long feedId, Blog blog, String feedUrl, String feedTitle, String feedDescription, String feedContent,
			Timestamp feedCreatedAt) {
		this.feedId = feedId;
		this.blog = blog;
		this.feedUrl = feedUrl;
		this.feedTitle = feedTitle;
		this.feedDescription = feedDescription;
		this.feedContent = feedContent;
		this.feedCreatedAt = feedCreatedAt;
	}
}
