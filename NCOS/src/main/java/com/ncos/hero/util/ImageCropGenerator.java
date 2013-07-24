package com.ncos.hero.util;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;

public class ImageCropGenerator {
	private static final Logger logger = Logger.getLogger(ImageCropGenerator.class);
	
	public void cropImages(String originalPath, String originalFileName, int cropCount, int imgSize, int[] rgb){
		File f = new File(originalPath+originalFileName);
		BufferedImage src = null;
		String[] fileNameArray = originalFileName.split("\\.");
		try {
			src = ImageIO.read(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
		for(int i=0; i<cropCount; i++){
			BufferedImage bf = src.getSubimage(0, i*imgSize,  imgSize, imgSize); //x, y , width, height
			//png파일 확장자로 고정.
			try {
				String tempTargetPath = originalPath+"temp_"+fileNameArray[0]+i+".png";
				String targetPath = originalPath+fileNameArray[0]+i+".png";
				ImageIO.write(bf, "PNG", new File(tempTargetPath));
			      final BufferedImage source = ImageIO.read(new File(tempTargetPath));

//			      final int color = source.getRGB(0, 0);
			      System.out.println("RGB : "+new Color(rgb[0],rgb[1],rgb[2],255).getRGB());//순서대로 R,G,B,Alpha값이다. 0이 투명, 255가 불투명.
			      final Image imageWithTransparency = ImageTransParency.makeColorTransparent(source, new Color(rgb[0],rgb[1],rgb[2],255));
			      
			      final BufferedImage transparentImage = ImageTransParency.imageToBufferedImage(imageWithTransparency);

			      final File out = new File(targetPath);
			      ImageIO.write(transparentImage, "PNG", out);//배경제거된 이미지 생성.
			      new File(tempTargetPath).delete();//임시이미지는 삭제
			} catch (IOException e) {
				e.printStackTrace();
			}  
		}
		new File(originalPath+originalFileName).delete();//원본 마스터 이미지 삭제.
	}
	
	
}
