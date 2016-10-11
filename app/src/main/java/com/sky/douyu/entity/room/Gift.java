package com.sky.douyu.entity.room;

/**
 * Created by tonycheng on 2016/10/11.
 */
public class Gift {

    private String id;
    private String name;
    private String type;
    private int pc;
    private int gx;
    private String desc;
    private String intro;
    private String mimg;
    private String himg;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHimg() {
        return himg;
    }

    public void setHimg(String himg) {
        this.himg = himg;
    }

    public String getMimg() {
        return mimg;
    }

    public void setMimg(String mimg) {
        this.mimg = mimg;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getGx() {
        return gx;
    }

    public void setGx(int gx) {
        this.gx = gx;
    }

    public int getPc() {
        return pc;
    }

    public void setPc(int pc) {
        this.pc = pc;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
