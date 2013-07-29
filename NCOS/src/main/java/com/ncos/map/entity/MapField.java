package com.ncos.map.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="sa_map_field")
public class MapField implements Serializable{

	@Id
	@ManyToOne
	@JoinColumn(name = "mapid")
	private MapInfo mapInfo;
	
	@Column(name="gps_x",nullable=false)
	private Integer gpsX;
	@Column(name="gps_y",nullable=false)
	private Integer gpsY;
	@Column(name="geo_type")
	private String geoType;
	
	public MapInfo getMapInfo() {
		return mapInfo;
	}
	public void setMapInfo(MapInfo mapInfo) {
		this.mapInfo = mapInfo;
	}
	public Integer getGpsX() {
		return gpsX;
	}
	public void setGpsX(Integer gpsX) {
		this.gpsX = gpsX;
	}
	public Integer getGpsY() {
		return gpsY;
	}
	public void setGpsY(Integer gpsY) {
		this.gpsY = gpsY;
	}
	public String getGeoType() {
		return geoType;
	}
	public void setGeoType(String geoType) {
		this.geoType = geoType;
	}
	
	
}
