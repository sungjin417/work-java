package com.team.safari.Vo;

public class UserSelectionVO {
    private String userId;
    private int typeId;
    private int locationId;

    public UserSelectionVO() {}

    public UserSelectionVO(String userId, int typeId, int locationId) {
        this.userId = userId;
        this.typeId = typeId;
        this.locationId = locationId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

}