package com.ncos.map.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="sa_map_field")
public class MapField {

	@ManyToOne
	@JoinColumn(name = "mapid")
	private MapInfo mapInfo;
	
	@Column(name="gps_x",nullable=false)
	private Integer gpsX;
	@Column(name="gps_y",nullable=false)
	private Integer gpsY;
	@Column(name="geo_type")
	private String geoType;
}
