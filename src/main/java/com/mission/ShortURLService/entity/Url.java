package com.mission.ShortURLService.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "url")
public class Url {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name = "origin")
	private String originUrl;
	@Column(name = "shorten")
	private String shortenUrl;
	@Column(name = "cnt", columnDefinition = "integer default 0")
	private int cnt;

	public Url(String originUrl) {
		this.originUrl = originUrl;
	}

	public void setShortenUrl(String shortenUrl) {
		this.shortenUrl = shortenUrl;
	}

	public void increaseCnt() {
		this.cnt++;
	}
}
