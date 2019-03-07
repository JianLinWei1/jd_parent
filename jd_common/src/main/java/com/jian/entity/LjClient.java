package com.jian.entity;

import java.io.Serializable;

public class LjClient implements Serializable {
    private String deviceSeril;

    private String deviceName;

    private Integer deviceType;

    private String deviceAddress;

    private String deviceAccuracy;

    private String tcpIp;

    private Integer tcpPort;

    private String merchantId;

    private static final long serialVersionUID = 1L;

    public String getDeviceSeril() {
        return deviceSeril;
    }

    public void setDeviceSeril(String deviceSeril) {
        this.deviceSeril = deviceSeril == null ? null : deviceSeril.trim();
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName == null ? null : deviceName.trim();
    }

    public Integer getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(Integer deviceType) {
        this.deviceType = deviceType;
    }

    public String getDeviceAddress() {
        return deviceAddress;
    }

    public void setDeviceAddress(String deviceAddress) {
        this.deviceAddress = deviceAddress == null ? null : deviceAddress.trim();
    }

    public String getDeviceAccuracy() {
        return deviceAccuracy;
    }

    public void setDeviceAccuracy(String deviceAccuracy) {
        this.deviceAccuracy = deviceAccuracy == null ? null : deviceAccuracy.trim();
    }

    public String getTcpIp() {
        return tcpIp;
    }

    public void setTcpIp(String tcpIp) {
        this.tcpIp = tcpIp == null ? null : tcpIp.trim();
    }

    public Integer getTcpPort() {
        return tcpPort;
    }

    public void setTcpPort(Integer tcpPort) {
        this.tcpPort = tcpPort;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId == null ? null : merchantId.trim();
    }
}