package com.yuzhyn.azylee.core.datas.exts;

public class StudentUa extends Student {
    private String caName;
    private String caNumber;

    public String getCaName() {
        return caName;
    }

    public void setCaName(String caName) {
        this.caName = caName;
    }

    public String getCaNumber() {
        return caNumber;
    }

    public void setCaNumber(String caNumber) {
        this.caNumber = caNumber;
    }

    @Override
    public String toString() {
        return "StudentUa{" +
                "caName='" + caName + '\'' +
                ", caNumber='" + caNumber + '\'' +
                '}';
    }
}
