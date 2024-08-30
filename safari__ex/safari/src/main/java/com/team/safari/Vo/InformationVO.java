package com.team.safari.Vo;

public class InformationVO {
    private int infoId;
    private String typeName;
    private String locationName;
    private String infoDetails;

    public InformationVO(int infoId, String typeName, String locationName, String infoDetails) {
        this.infoId = infoId;
        this.typeName = typeName;
        this.locationName = locationName;
        this.infoDetails = infoDetails;
    }

    public int getInfoId() {
        return infoId;
    }

    public String getTypeName() {
        return typeName;
    }

    public String getLocationName() {
        return locationName;
    }

    public String getInfoDetails() {
        return infoDetails;
    }
}
