package com.rex.onlineShop.util;

import javax.servlet.http.HttpServletRequest;

public class HTTPServletRequestUtil {

    public static int getInt(HttpServletRequest request, String key){
        try{
            return Integer.decode(request.getParameter(key));
        } catch (Exception e){
            return -1;
        }
    }

    public static long getLong(HttpServletRequest request, String key){
        try{
            return Long.decode(request.getParameter(key));
        } catch (Exception e){
            return -1;
        }
    }

    public static double getDouble(HttpServletRequest request, String key){
        try{
            return Double.valueOf(request.getParameter(key));
        } catch (Exception e){
            return -1;
        }
    }

    public static boolean getBoolean(HttpServletRequest request, String key){
        try{
            return Boolean.valueOf(request.getParameter(key));
        } catch (Exception e){
            return false;
        }
    }

    public static String getString(HttpServletRequest request, String key){
        try{
            String result = request.getParameter(key);
            if(result != null){
                result = result.trim();

                if(result.equals("")){
                    result = null;
                }
            }
            return result;
        } catch (Exception e){
            return null;
        }
    }
}
