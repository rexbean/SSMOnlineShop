package com.rex.onlineShop.util;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

public class EncryptPropertyPlaceholderConfigurer extends
        PropertyPlaceholderConfigurer {
    // need to be decrypted
    private String[] encryptPropNames = { "jdbc.username", "jdbc.password" };

    /**
     * 对关键的属性进行转换
     */
    @Override
    protected String convertProperty(String propertyName, String propertyValue) {
        if (isEncryptProp(propertyName)) {
            // decrypt
            return DESUtil.getDecryptString(propertyValue);
        } else {
            return propertyValue;
        }
    }

    /**
     *
     * @param propertyName propertyName
     * @return encrypted or not
     */
    private boolean isEncryptProp(String propertyName) {
        for (String encryptpropertyName : encryptPropNames) {
            if (encryptpropertyName.equals(propertyName))
                return true;
        }
        return false;
    }
}