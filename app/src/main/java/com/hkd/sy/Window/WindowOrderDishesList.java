package com.hkd.sy.Window;

public class WindowOrderDishesList {
    private int windowODId;
    private int windowODImage;
    private String windowODName;
    private double windowODMoney;
    private String windowODIntroduction;

    public int getWindowODId() {
        return windowODId;
    }

    public void setWindowODId(int windowODId) {
        this.windowODId = windowODId;
    }

    public int getWindowODImage() {
        return windowODImage;
    }

    public void setWindowODImage(int windowODImage) {
        this.windowODImage = windowODImage;
    }

    public String getWindowODName() {
        return windowODName;
    }

    public void setWindowODName(String windowODName) {
        this.windowODName = windowODName;
    }

    public double getWindowODMoney() {
        return windowODMoney;
    }

    public void setWindowODMoney(double windowODMoney) {
        this.windowODMoney = windowODMoney;
    }

    public String getWindowODIntroduction() {
        return windowODIntroduction;
    }

    public void setWindowODIntroduction(String windowODIntroduction) {
        this.windowODIntroduction = windowODIntroduction;
    }

    public WindowOrderDishesList(int windowODId, int windowODImage, String windowODName, double windowODMoney, String windowODIntroduction) {
        this.windowODId = windowODId;
        this.windowODImage = windowODImage;
        this.windowODName = windowODName;
        this.windowODMoney = windowODMoney;
        this.windowODIntroduction = windowODIntroduction;
    }
}
