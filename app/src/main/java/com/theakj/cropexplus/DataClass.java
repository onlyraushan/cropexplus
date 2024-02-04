package com.theakj.cropexplus;

public class DataClass {
    private String dataTitle;
    private String dataDesc;
    private String dataLang;
    private String dataImage;
    private String key;
    public String getKey() {
        return key;
    }
    public void setKey(String key) {
        this.key = key;
    }
    public String getDataTitle() {
        return dataTitle;
    }
    public String getDataDesc() {
        return dataDesc;
    }
    public String getDataLang() {
        return dataLang;
    }
    public String getDataImage() {
        return dataImage;
    }
    public DataClass(String dataTitle, String dataDesc, String dataLang, String dataImage) {
        this.dataTitle = dataTitle;
        this.dataDesc = dataDesc;
        this.dataLang = dataLang;
        this.dataImage = dataImage;
    }
    public DataClass(){
    }

    public void setDataTitle(String dataTitle) {
        this.dataTitle = dataTitle;
    }

    public void setDataDesc(String dataDesc) {
        this.dataDesc = dataDesc;
    }

    public void setDataLang(String dataLang) {
        this.dataLang = dataLang;
    }

    public void setDataImage(String dataImage) {
        this.dataImage = dataImage;
    }
}
