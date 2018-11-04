package com.rex.onlineShop.util;

public class PathUtil {
    private static String separator = System.getProperty("file.separator");
    /**
     * @return the path of the image file, if the images are save in the class path, it will lost
     * we can save these pic in the other server
     */
    public static String getImgBasePath(){
        String os = System.getProperty("os.name");
        String basePath ="";
        if(os.toLowerCase().startsWith("win")){
            basePath = "Image";
        } else {
            basePath = "/home/folder/image";
        }
        basePath = basePath.replace("/",separator);
        return basePath;
    }

    public static String getShopImagePath(Long shopId){
        String imagePath = "/upload/icon/shop/"+ shopId +"/";
        return imagePath.replace("/",separator);
    }
}
