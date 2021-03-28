package com.hkd.sy.Recommend;

public class RecommendList {
    private int windowId;
    private int windowAvatar;
    private String windowName;
    private String windowBtn;
    private int windowImageA;
    private int windowImageB;
    private int windowImageC;
    private String windowTheme;
    private String windowIntroduction;

    public int getWindowId() {
        return windowId;
    }

    public void setWindowId(int windowId) {
        this.windowId = windowId;
    }

    public int getWindowAvatar() {
        return windowAvatar;
    }

    public void setWindowAvatar(int windowAvatar) {
        this.windowAvatar = windowAvatar;
    }

    public String getWindowName() {
        return windowName;
    }

    public void setWindowName(String windowName) {
        this.windowName = windowName;
    }

    public String getWindowBtn() {
        return windowBtn;
    }

    public void setWindowBtn(String windowBtn) {
        this.windowBtn = windowBtn;
    }

    public int getWindowImageA() {
        return windowImageA;
    }

    public void setWindowImageA(int windowImageA) {
        this.windowImageA = windowImageA;
    }

    public int getWindowImageB() {
        return windowImageB;
    }

    public void setWindowImageB(int windowImageB) {
        this.windowImageB = windowImageB;
    }

    public int getWindowImageC() {
        return windowImageC;
    }

    public void setWindowImageC(int windowImageC) {
        this.windowImageC = windowImageC;
    }

    public String getWindowTheme() {
        return windowTheme;
    }

    public void setWindowTheme(String windowTheme) {
        this.windowTheme = windowTheme;
    }

    public String getWindowIntroduction() {
        return windowIntroduction;
    }

    public void setWindowIntroduction(String windowIntroduction) {
        this.windowIntroduction = windowIntroduction;
    }

    public RecommendList(int windowId, int windowAvatar, String windowName, String windowBtn, int windowImageA, int windowImageB, int windowImageC, String windowTheme, String windowIntroduction) {
        this.windowId = windowId;
        this.windowAvatar = windowAvatar;
        this.windowName = windowName;
        this.windowBtn = windowBtn;
        this.windowImageA = windowImageA;
        this.windowImageB = windowImageB;
        this.windowImageC = windowImageC;
        this.windowTheme = windowTheme;
        this.windowIntroduction = windowIntroduction;
    }
}
