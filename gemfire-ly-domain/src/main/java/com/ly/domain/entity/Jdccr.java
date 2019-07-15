package com.ly.domain.entity;

import org.apache.geode.pdx.PdxReader;
import org.apache.geode.pdx.PdxSerializable;
import org.apache.geode.pdx.PdxWriter;

/**
 * Created by lany on 2019/6/26.
 */
public class Jdccr implements PdxSerializable{


    private String id;
    private String sbbh;
    private String sbmc;
    private String jdccsysdm;
    private String clpp;
    private String cllx;
    private String jdchpzldm;
    private String jdchphm;
    private String fx;
    private String dlwz;
    private String fxsj;
    private String zp;
    private String cpys;
    private String dqjd;
    private String dqwd;
    private String zdclpdbs;
    private String cjcsdm;
    private String cjxqdm;
    private String rksj;

    public Jdccr() {
    }

    public Jdccr(String id, String sbbh, String sbmc, String jdccsysdm, String clpp, String cllx, String jdchpzldm, String jdchphm, String fx, String dlwz, String fxsj, String zp, String cpys, String dqjd, String dqwd, String zdclpdbs, String cjcsdm, String cjxqdm, String rksj) {
        this.id = id;
        this.sbbh = sbbh;
        this.sbmc = sbmc;
        this.jdccsysdm = jdccsysdm;
        this.clpp = clpp;
        this.cllx = cllx;
        this.jdchpzldm = jdchpzldm;
        this.jdchphm = jdchphm;
        this.fx = fx;
        this.dlwz = dlwz;
        this.fxsj = fxsj;
        this.zp = zp;
        this.cpys = cpys;
        this.dqjd = dqjd;
        this.dqwd = dqwd;
        this.zdclpdbs = zdclpdbs;
        this.cjcsdm = cjcsdm;
        this.cjxqdm = cjxqdm;
        this.rksj = rksj;
    }

    @Override
    public void toData(PdxWriter pdxWriter) {
        pdxWriter.writeString("id",id);
        pdxWriter.writeString("sbbh",sbbh);
        pdxWriter.writeString("sbmc",sbmc);
        pdxWriter.writeString("jdccsysdm",jdccsysdm);
        pdxWriter.writeString("clpp",clpp);
        pdxWriter.writeString("cllx",cllx);
        pdxWriter.writeString("jdchpzldm",jdchpzldm);
        pdxWriter.writeString("jdchphm",jdchphm);
        pdxWriter.writeString("fx",fx);
        pdxWriter.writeString("dlwz",dlwz);
        pdxWriter.writeString("fxsj",fxsj);
        pdxWriter.writeString("zp",zp);
        pdxWriter.writeString("cpys",cpys);
        pdxWriter.writeString("dqjd",dqjd);
        pdxWriter.writeString("dqwd",dqwd);
        pdxWriter.writeString("zdclpdbs",zdclpdbs);
        pdxWriter.writeString("cjcsdm",cjcsdm);
        pdxWriter.writeString("cjxqdm",cjxqdm);
        pdxWriter.writeString("rksj",rksj);

    }

    @Override
    public void fromData(PdxReader pdxReader) {
        id = pdxReader.readString("id");
        sbbh = pdxReader.readString("sbbh");
        sbmc = pdxReader.readString("sbmc");
        jdccsysdm = pdxReader.readString("jdccsysdm");
        clpp = pdxReader.readString("clpp");
        cllx = pdxReader.readString("cllx");
        jdchpzldm = pdxReader.readString("jdchpzldm");
        jdchphm = pdxReader.readString("jdchphm");
        fx = pdxReader.readString("fx");
        dlwz = pdxReader.readString("dlwz");
        fxsj = pdxReader.readString("fxsj");
        zp = pdxReader.readString("zp");
        cpys = pdxReader.readString("cpys");
        dqjd = pdxReader.readString("dqjd");
        dqwd = pdxReader.readString("dqwd");
        zdclpdbs = pdxReader.readString("zdclpdbs");
        cjcsdm = pdxReader.readString("cjcsdm");
        cjxqdm = pdxReader.readString("cjxqdm");
        rksj = pdxReader.readString("rksj");
    }

    @Override
    public String toString() {
        return "Jdccr{" +
                "id='" + id + '\'' +
                ", sbbh='" + sbbh + '\'' +
                ", sbmc='" + sbmc + '\'' +
                ", jdccsysdm='" + jdccsysdm + '\'' +
                ", clpp='" + clpp + '\'' +
                ", cllx='" + cllx + '\'' +
                ", jdchpzldm='" + jdchpzldm + '\'' +
                ", jdchphm='" + jdchphm + '\'' +
                ", fx='" + fx + '\'' +
                ", dlwz='" + dlwz + '\'' +
                ", fxsj='" + fxsj + '\'' +
                ", zp='" + zp + '\'' +
                ", cpys='" + cpys + '\'' +
                ", dqjd='" + dqjd + '\'' +
                ", dqwd='" + dqwd + '\'' +
                ", zdclpdbs='" + zdclpdbs + '\'' +
                ", cjcsdm='" + cjcsdm + '\'' +
                ", cjxqdm='" + cjxqdm + '\'' +
                ", rksj='" + rksj + '\'' +
                '}';
    }
}
