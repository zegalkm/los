package com.ncos.map.service;

import com.ncos.map.entity.MapInfo;

public interface MapMngService {

	public Integer saveMapInfo(MapInfo mapInfo);
	public MapInfo getMapInfo(Integer mapid);
}
