package com.ncos.map.service;

import java.util.List;
import java.util.Map;

import com.ncos.map.entity.MapInfo;

public interface MapMngService {

	public Integer saveMapInfo(MapInfo mapInfo);
	public MapInfo getMapInfo(Integer mapid);
	public List<MapInfo> getMapInfoList(Map<String,Object> param);
	public int getMapInfoListCount(Map<String,Object> param);
}
