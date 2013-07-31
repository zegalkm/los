package com.ncos.map.dao;

import java.util.List;

import com.ncos.map.entity.MapField;
import com.ncos.map.entity.MapInfo;

public interface MapMngDao {

	public Integer saveMapInfo(MapInfo mapInfo);
	public void saveMapField(MapField mapField);
	public void deleteMapInfo(MapInfo mapInfo);
	public List<MapInfo> getMapInfoList();
	public MapInfo getMapInfo(Integer mapid);
}
