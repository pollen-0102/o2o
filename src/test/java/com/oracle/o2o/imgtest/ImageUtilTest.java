package com.oracle.o2o.imgtest;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

public class ImageUtilTest {
	public static void main(String[] args) throws IOException {
		String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
		System.out.println(basePath);
		//ָ���ļ���С
		Thumbnails.of("d://a.jpg").size(200, 200)
		//����ˮӡ 0.85f��͸����  outputQuality(0.8f)��ѹ����
				.watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File("d://b.jpg")), 0.25f)
				.outputQuality(0.8f).toFile("d://newa.jpg");
	}
}
