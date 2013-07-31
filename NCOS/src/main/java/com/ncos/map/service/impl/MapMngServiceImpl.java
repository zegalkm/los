package com.ncos.map.service.impl;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;
import javax.imageio.ImageIO;

import org.springframework.stereotype.Service;

import com.ncos.map.dao.MapMngDao;
import com.ncos.map.entity.MapInfo;
import com.ncos.map.service.MapMngService;

@Service("mapMngService")
public class MapMngServiceImpl implements MapMngService{

	@Resource(name = "mapMngDao")
	MapMngDao mapMngDao;
	
	@Override
	public Integer saveMapInfo(MapInfo mapInfo) {
		File file = new File(mapInfo.getFilePath());
		try {
			Image image = ImageIO.read(file);
			mapInfo.setWidth(image.getWidth(null));
			mapInfo.setHeight(image.getHeight(null));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return mapMngDao.saveMapInfo(mapInfo);
	}

	@Override
	public MapInfo getMapInfo(Integer mapid) {
		return mapMngDao.getMapInfo(mapid);
	}

}
