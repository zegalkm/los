package com.ncos.map.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="sa_map")
public class MapInfo{

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE , generator="sa_map_mapid_seq")
	@SequenceGenerator(name="sa_map_mapid_seq" ,sequenceName="sa_map_mapid_seq",allocationSize=1)
	@Column(name="mapid",nullable=false)
	private Integer mapid;
	
	@Column(name="map_name")
	private String mapName;
	
	@Column(name="width")
	private Integer width;
	
	@Column(name="height")
	private Integer height;
	
	@Column(name="file_path")
	private String filePath;

	public Integer getMapid() {
		return mapid;
	}

	public void setMapid(Integer mapid) {
		this.mapid = mapid;
	}

	public String getMapName() {
		return mapName;
	}

	public void setMapName(String mapName) {
		this.mapName = mapName;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	
}
