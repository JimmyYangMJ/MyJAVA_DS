package com.baiduMap.map;

/**
 * @author zhanghuigen@cetiti.com
 * @since 0.1.0
 **/
public class CoordinateBean {
    /**
     * 定位的几个基本信息
     */
    private double longitude;

    private double latitude;

    private boolean isChina;

    public CoordinateBean() {

    }

    public CoordinateBean(double longitude, double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public boolean isChina() {
        return isChina;
    }

    public void setChina(boolean china) {
        this.isChina = china;
    }

    @Override
    public String toString(){
        return this.latitude + "_" + this.longitude;
    }

}
