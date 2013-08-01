package com.ncos.map.service.impl;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ncos.map.dao.MapMngDao;
import com.ncos.map.entity.MapInfo;
import com.ncos.map.service.MapMngService;
import com.ncos.utils.ThumbnailUtils;

@Service("mapMngService")
public class MapMngServiceImpl implements MapMngService{

	@Resource(name = "mapMngDao")
	MapMngDao mapMngDao;
	@Value("#{ncos_prop['commonFilePath']}")
	public String commonFilePath;
	
	@Override
	public Integer saveMapInfo(MapInfo mapInfo) {
		File file = new File(commonFilePath+mapInfo.getFilePath()+".bmp");
		try {
			Image image = ImageIO.read(file);
			mapInfo.setWidth(image.getWidth(null));
			mapInfo.setHeight(image.getHeight(null));
			//썸네일 생성
			ThumbnailUtils.scale((BufferedImage) image, commonFilePath+mapInfo.getFilePath()+"_th.bmp", "bmp",80,80);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return mapMngDao.saveMapInfo(mapInfo);
	}

	@Override
	public MapInfo getMapInfo(Integer mapid) {
		return mapMngDao.getMapInfo(mapid);
	}

	@Override
	public List<MapInfo> getMapInfoList(Map<String, Object> param) {
		return mapMngDao.getMapInfoList(param);
	}

	@Override
	public int getMapInfoListCount(Map<String, Object> param) {
		return mapMngDao.getMapInfoListCount(param);
	}

}
