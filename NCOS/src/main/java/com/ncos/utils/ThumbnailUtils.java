package com.ncos.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;

import com.mortennobel.imagescaling.AdvancedResizeOp;
import com.mortennobel.imagescaling.AdvancedResizeOp.UnsharpenMask;
import com.mortennobel.imagescaling.ResampleOp;

public class ThumbnailUtils {
	private static final Logger logger = Logger.getLogger(ThumbnailUtils.class);

	public static boolean scale(BufferedImage srcImage, String destPath,
								String imageFormat, int destWidth, int destHeight) {

		boolean result = true;

		try {
			ResampleOp resampleOp = new ResampleOp(destWidth, destHeight);
			UnsharpenMask um = AdvancedResizeOp.UnsharpenMask.Soft;
			resampleOp.setUnsharpenMask(um);
			BufferedImage rescaledImage = resampleOp.filter(srcImage, null);
			File destFile = new File(destPath);
			ImageIO.write(rescaledImage, imageFormat, destFile);

		} catch (IOException e) {
			logger.error("Improved Image scaling falied!");
			logger.error(e.getMessage());
			result = false;
		}
		return result;
	}
}
