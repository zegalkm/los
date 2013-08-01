package com.ncos.map.dao;

import java.util.List;
import java.util.Map;

import com.ncos.map.entity.MapField;
import com.ncos.map.entity.MapInfo;

public interface MapMngDao {

	public Integer saveMapInfo(MapInfo mapInfo);
	public void saveMapField(MapField mapField);
	public void deleteMapInfo(MapInfo mapInfo);
	public List<MapInfo> getMapInfoList(Map<String,Object> param);
	public int getMapInfoListCount(Map<String,Object> param);
	public MapInfo getMapInfo(Integer mapid);
}
