package com.ly.domain.entity;


import org.apache.geode.pdx.PdxReader;
import org.apache.geode.pdx.PdxSerializable;
import org.apache.geode.pdx.PdxWriter;

/**
 * Created by lany on 2019/6/20.
 */
public class Organization implements PdxSerializable {

    private String orgid;

    private String orgname;

    private String address;

    private int numbers;

    public Organization(){}

    public Organization(String orgid, String orgname, String address,int numbers) {
        this.orgid = orgid;
        this.orgname = orgname;
        this.address = address;
        this.numbers = numbers;
    }

    public String getOrgid() {
        return orgid;
    }

    public void setOrgid(String orgId) {
        this.orgid = orgId;
    }

    public String getOrgname() {
        return orgname;
    }

    public void setOrgname(String orgname) {
        this.orgname = orgname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

   public int getNumbers() {
        return numbers;
    }

    public void setNumbers(int numbers) {
        this.numbers = numbers;
    }

    @Override
    public void toData(PdxWriter pdxWriter) {
        pdxWriter.writeString("orgid",orgid);
        pdxWriter.writeString("orgname",orgname);
        pdxWriter.writeString("address",address);
        pdxWriter.writeInt("numbers",numbers);
    }

    @Override
    public void fromData(PdxReader pdxReader) {
        orgid = pdxReader.readString("orgid");
        orgname = pdxReader.readString("orgname");
        address = pdxReader.readString("address");
        numbers = pdxReader.readInt("numbers");
    }

    @Override
    public String toString() {
        return "Organization{" +
                "orgid='" + orgid + '\'' +
                ", orgname='" + orgname + '\'' +
                ", address='" + address + '\'' +
                ", numbers=" + numbers +
                '}';
    }
}