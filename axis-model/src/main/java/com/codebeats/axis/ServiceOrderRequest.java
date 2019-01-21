package com.codebeats.axis;

public class ServiceOrderRequest implements Serializable {
    private int id;
    private String customer;
    private String customerRef;
    private String vendorRef;
    private String description;
    private Date requested;
    private String shipper;
    private String consignee;
    private String carrier;
    private String service;
    private String status;
    private String hu;
    private String weightLbs;
    private String dimensions;
    private int classNumber;


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomer() {
        return this.customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getCustomerRef() {
        return this.customerRef;
    }

    public void setCustomerRef(String customerRef) {
        this.customerRef = customerRef;
    }

    public String getVendorRef() {
        return this.vendorRef;
    }

    public void setVendorRef(String vendorRef) {
        this.vendorRef = vendorRef;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getRequested() {
        return this.requested;
    }

    public void setRequested(Date requested) {
        this.requested = requested;
    }

    public String getShipper() {
        return this.shipper;
    }

    public void setShipper(String shipper) {
        this.shipper = shipper;
    }

    public String getConsignee() {
        return this.consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public String getCarrier() {
        return this.carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public String getService() {
        return this.service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getHu() {
        return this.hu;
    }

    public void setHu(String hu) {
        this.hu = hu;
    }

    public String getWeightLbs() {
        return this.weightLbs;
    }

    public void setWeightLbs(String weightLbs) {
        this.weightLbs = weightLbs;
    }

    public String getDimensions() {
        return this.dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public int getClassNumber() {
        return this.classNumber;
    }

    public void setClassNumber(int classNumber) {
        this.classNumber = classNumber;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", customer='" + getCustomer() + "'" +
            ", customerRef='" + getCustomerRef() + "'" +
            ", vendorRef='" + getVendorRef() + "'" +
            ", description='" + getDescription() + "'" +
            ", requested='" + getRequested() + "'" +
            ", shipper='" + getShipper() + "'" +
            ", consignee='" + getConsignee() + "'" +
            ", carrier='" + getCarrier() + "'" +
            ", service='" + getService() + "'" +
            ", status='" + getStatus() + "'" +
            ", hu='" + getHu() + "'" +
            ", weightLbs='" + getWeightLbs() + "'" +
            ", dimensions='" + getDimensions() + "'" +
            ", classNumber='" + getClassNumber() + "'" +
            "}";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ServiceOrderRequest)) {
            return false;
        }
        ServiceOrderRequest serviceOrderRequest = (ServiceOrderRequest) o;
        return id == serviceOrderRequest.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

}