package com.ncos.hero.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="sa_hero")
public class Hero {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE , generator="sa_hero_heroid_seq")
	@SequenceGenerator(name="sa_hero_heroid_seq" ,sequenceName="sa_hero_heroid_seq",allocationSize=1)
	@Column(name="heroid",nullable=false)
	private Integer heroid;
	
	@Column(name="hero_name")
	private String heroName;
	
	@Column(name="type")
	private String type;
	@Column(name="price")
	private String price;
	@Column(name="mov_area")
	private Integer movArea;
	@Column(name="force")
	private Integer force;
	@Column(name="intellect")
	private Integer intellect;
	@Column(name="leadership")
	private Integer leadership;
	@Column(name="charm")
	private Integer charm;
	@Column(name="file_path")
	private String filePath;
	

	public Integer getHeroid() {
		return heroid;
	}

	public void setHeroid(Integer heroid) {
		this.heroid = heroid;
	}

	public String getHeroName() {
		return heroName;
	}

	public void setHeroName(String heroName) {
		this.heroName = heroName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Integer getMovArea() {
		return movArea;
	}

	public void setMovArea(Integer movArea) {
		this.movArea = movArea;
	}

	public Integer getForce() {
		return force;
	}

	public void setForce(Integer force) {
		this.force = force;
	}

	public Integer getIntellect() {
		return intellect;
	}

	public void setIntellect(Integer intellect) {
		this.intellect = intellect;
	}

	public Integer getLeadership() {
		return leadership;
	}

	public void setLeadership(Integer leadership) {
		this.leadership = leadership;
	}

	public Integer getCharm() {
		return charm;
	}

	public void setCharm(Integer charm) {
		this.charm = charm;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}


}
