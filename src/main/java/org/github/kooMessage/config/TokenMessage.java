package org.github.kooMessage.config;

/**
 * @BelongsProject: kooMessage
 * @BelongsPackage: org.github.kooMessage.config
 * @Author: 王飞
 * @CreateTime: 2022-11-01  15:18
 * @Description: 内置Token信息
 * @Version: 1.0
 */
public class TokenMessage {
    private  static String NAME = "";
    private  static String PASSWORD = "";
    private  static String TOKEN_URL = "";
    private  static String DOMAIN = "";
    private  static String PROJECT = "";

    public static String getNAME() {
        return NAME;
    }

    public static String getPASSWORD() {
        return PASSWORD;
    }

    public static String getTOKEN_URL() {
        return TOKEN_URL;
    }

    public static String getDOMAIN() {
        return DOMAIN;
    }

    public static String getPROJECT() {
        return PROJECT;
    }

    public static void setNAME(String NAME) {
        TokenMessage.NAME = NAME;
    }

    public static void setPASSWORD(String PASSWORD) {
        TokenMessage.PASSWORD = PASSWORD;
    }

    public static void setTokenUrl(String tokenUrl) {
        TOKEN_URL = tokenUrl;
    }

    public static void setDOMAIN(String DOMAIN) {
        TokenMessage.DOMAIN = DOMAIN;
    }

    public static void setPROJECT(String PROJECT) {
        TokenMessage.PROJECT = PROJECT;
    }
}
