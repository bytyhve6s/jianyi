package com.oyid.jianyi.dto;

import java.util.Date;

public class Order {
    private Integer id;

    private Double goodsLength;

    private Double goodsWidth;

    private Double goodsHeight;

    private Double actualWeight;

    private Double banlanceWeight;

    private String volume;

    private Double maxLength;

    private String packingType;

    private Integer num;

    private String distributionWay;

    private String itemName;

    private String receipt;

    private String receipt2;

    private String overLength;

    private String overWeight;

    private Integer overWeightNum;

    private String goodsType;

    private String declaredValue;

    private String note;

    private Integer mailingUserId;

    private Integer packingNum;

    private String orderNum;

    private Date mailingTime;

    private String mailingState;

    private String destination;

    private String receivingClerk;

    private String shipingType;

    private String serviceType;

    private String nextStation;

    private String recordMsg;

    private String signMsg;

    private String delivery;

    private String since;

    private Integer collUserId;

    public String getReceipt2() {
        return receipt2;
    }

    public void setReceipt2(String receipt2) {
        this.receipt2 = receipt2;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getGoodsLength() {
        return goodsLength;
    }

    public void setGoodsLength(Double goodsLength) {
        this.goodsLength = goodsLength;
    }

    public Double getGoodsWidth() {
        return goodsWidth;
    }

    public void setGoodsWidth(Double goodsWidth) {
        this.goodsWidth = goodsWidth;
    }

    public Double getGoodsHeight() {
        return goodsHeight;
    }

    public void setGoodsHeight(Double goodsHeight) {
        this.goodsHeight = goodsHeight;
    }

    public Double getActualWeight() {
        return actualWeight;
    }

    public void setActualWeight(Double actualWeight) {
        this.actualWeight = actualWeight;
    }

    public Double getBanlanceWeight() {
        return banlanceWeight;
    }

    public void setBanlanceWeight(Double banlanceWeight) {
        this.banlanceWeight = banlanceWeight;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume == null ? null : volume.trim();
    }

    public Double getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(Double maxLength) {
        this.maxLength = maxLength;
    }

    public String getPackingType() {
        return packingType;
    }

    public void setPackingType(String packingType) {
        this.packingType = packingType == null ? null : packingType.trim();
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getDistributionWay() {
        return distributionWay;
    }

    public void setDistributionWay(String distributionWay) {
        this.distributionWay = distributionWay == null ? null : distributionWay.trim();
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName == null ? null : itemName.trim();
    }

    public String getReceipt() {
        return receipt;
    }

    public void setReceipt(String receipt) {
        this.receipt = receipt == null ? null : receipt.trim();
    }

    public String getOverLength() {
        return overLength;
    }

    public void setOverLength(String overLength) {
        this.overLength = overLength == null ? null : overLength.trim();
    }

    public String getOverWeight() {
        return overWeight;
    }

    public void setOverWeight(String overWeight) {
        this.overWeight = overWeight == null ? null : overWeight.trim();
    }

    public Integer getOverWeightNum() {
        return overWeightNum;
    }

    public void setOverWeightNum(Integer overWeightNum) {
        this.overWeightNum = overWeightNum;
    }

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType == null ? null : goodsType.trim();
    }

    public String getDeclaredValue() {
        return declaredValue;
    }

    public void setDeclaredValue(String declaredValue) {
        this.declaredValue = declaredValue == null ? null : declaredValue.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public Integer getMailingUserId() {
        return mailingUserId;
    }

    public void setMailingUserId(Integer mailingUserId) {
        this.mailingUserId = mailingUserId;
    }

    public Integer getPackingNum() {
        return packingNum;
    }

    public void setPackingNum(Integer packingNum) {
        this.packingNum = packingNum;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum == null ? null : orderNum.trim();
    }

    public Date getMailingTime() {
        return mailingTime;
    }

    public void setMailingTime(Date mailingTime) {
        this.mailingTime = mailingTime;
    }

    public String getMailingState() {
        return mailingState;
    }

    public void setMailingState(String mailingState) {
        this.mailingState = mailingState == null ? null : mailingState.trim();
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination == null ? null : destination.trim();
    }

    public String getReceivingClerk() {
        return receivingClerk;
    }

    public void setReceivingClerk(String receivingClerk) {
        this.receivingClerk = receivingClerk == null ? null : receivingClerk.trim();
    }

    public String getShipingType() {
        return shipingType;
    }

    public void setShipingType(String shipingType) {
        this.shipingType = shipingType == null ? null : shipingType.trim();
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType == null ? null : serviceType.trim();
    }

    public String getNextStation() {
        return nextStation;
    }

    public void setNextStation(String nextStation) {
        this.nextStation = nextStation == null ? null : nextStation.trim();
    }

    public String getRecordMsg() {
        return recordMsg;
    }

    public void setRecordMsg(String recordMsg) {
        this.recordMsg = recordMsg == null ? null : recordMsg.trim();
    }

    public String getSignMsg() {
        return signMsg;
    }

    public void setSignMsg(String signMsg) {
        this.signMsg = signMsg == null ? null : signMsg.trim();
    }

    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery == null ? null : delivery.trim();
    }

    public String getSince() {
        return since;
    }

    public void setSince(String since) {
        this.since = since == null ? null : since.trim();
    }

    public Integer getCollUserId() {
        return collUserId;
    }

    public void setCollUserId(Integer collUserId) {
        this.collUserId = collUserId;
    }
}