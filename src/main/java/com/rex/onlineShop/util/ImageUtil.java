package com.rex.onlineShop.util;


import com.sun.istack.internal.Nullable;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class ImageUtil {
    @Nullable
    //here is the class path
    private static final SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
    private static final Random r = new Random();
    private static String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
    /**
     *
     * @return the path of the thumbnail
     */
    public static String generateThumbnail(InputStream thumbnailInputStream, String filename, String targetAddr){
        String realFilename = getRandomFileName();
        String extension = getFileExtension(filename);
        makeDirPath(targetAddr);
        String relativeAddr = targetAddr + realFilename + extension;
        File dest = new File(PathUtil.getImgBasePath()+relativeAddr);
        try{
            System.out.println("basePath = " + basePath);
            Thumbnails.of(thumbnailInputStream).size(200,200)
                    .watermark(Positions.BOTTOM_RIGHT,ImageIO.read(new File(basePath + "/watermark.jpg")),0.25f)
                    .outputQuality(0.8f).toFile(dest);

        } catch(IOException e){
            e.printStackTrace();
        }
        return dest.getPath();
    }

    /**
     * generate file name by yyyy:MM:dd:HH:mm:ss.SSS + 5 digits random number
     * @return the random file name
     */
    private static String getRandomFileName(){
        // get the 5 digit random
        int ranNum = r.nextInt(89999) + 10000;
        String nowTimeStr = sDateFormat.format(new Date());
        return nowTimeStr+ranNum;
    }

    /**
     * get the extension of the image file
     * @return image type
     */
    private static String getFileExtension(String filename){
        return filename.substring(filename.lastIndexOf("."));
    }

    /**
     * make the directory related to the file path
     * @param targetAddr the target address
     */
    private static void makeDirPath(String targetAddr){
        String realFileParentPath = PathUtil.getImgBasePath() + targetAddr;
        File dirPath = new File(realFileParentPath);
        if(!dirPath.exists()){
            dirPath.mkdirs();
        }
    }

    public static void main(String[] args){

        try {
            if(basePath != null){
                Thumbnails.of(new File("some path of the original image"))
                        .size(200,200).watermark(Positions.BOTTOM_RIGHT,
                        ImageIO.read(new File(basePath+"/watermark.jpg")),0.25f)
                        .outputQuality(0.8f).toFile("new File Name");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
