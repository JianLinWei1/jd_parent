package com.jian.entity;

import java.io.Serializable;
import java.util.Date;

public class JdPersons implements Serializable {
    private String uuid;

    private String idCard;

    private String name;

    private String photo;

    private Long version;

    private Integer action;

    private String deviceSeril;

    private Date regTime;

    private Date invalidTime;

    private byte[] photoFeature;
    
    private String old_idCard;

    private static final long serialVersionUID = 1L;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo == null ? null : photo.trim();
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Integer getAction() {
        return action;
    }

    public void setAction(Integer action) {
        this.action = action;
    }

    public String getDeviceSeril() {
        return deviceSeril;
    }

    public void setDeviceSeril(String deviceSeril) {
        this.deviceSeril = deviceSeril == null ? null : deviceSeril.trim();
    }

    public Date getRegTime() {
        return regTime;
    }

    public void setRegTime(Date regTime) {
        this.regTime = regTime;
    }

    public Date getInvalidTime() {
        return invalidTime;
    }

    public void setInvalidTime(Date invalidTime) {
        this.invalidTime = invalidTime;
    }

    public byte[] getPhotoFeature() {
        return photoFeature;
    }

    public void setPhotoFeature(byte[] photoFeature) {
        this.photoFeature = photoFeature;
    }

	public String getOld_idCard() {
		return old_idCard;
	}

	public void setOld_idCard(String old_idCard) {
		this.old_idCard = old_idCard;
	}
    
}