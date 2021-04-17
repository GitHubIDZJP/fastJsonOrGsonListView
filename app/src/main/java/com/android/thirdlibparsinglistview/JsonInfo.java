package com.android.thirdlibparsinglistview;
 //最外层
public class JsonInfo {
    private int resultCode;
    private String resultInfo;
    private PageinfoMer info;

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultInfo() {
        return resultInfo;
    }

    public void setResultInfo(String resultInfo) {
        this.resultInfo = resultInfo;
    }

    public PageinfoMer getInfo() {
        return info;
    }

    public void setInfo(PageinfoMer info) {
        this.info = info;
    }
}

