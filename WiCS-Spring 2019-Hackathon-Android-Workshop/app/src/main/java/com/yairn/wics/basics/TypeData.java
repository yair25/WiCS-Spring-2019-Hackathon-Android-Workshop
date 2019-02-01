package com.yairn.wics.basics;


public class TypeData {

    public Type type = Type.Activity;
    public String url = null;
    public int resource;

    public TypeData(Type type, String url) {
        this.type = type;
        this.url = url;

        switch (type) {
            case Camera:
                resource = R.drawable.ic_camera;
                break;
            case Browser:
                resource = R.drawable.ic_browser;
                break;
            case Maps:
                resource = R.drawable.ic_maps;
                break;
            case Calc:
                resource = R.drawable.ic_calc;
                break;
            default:
                resource = R.drawable.ic_activity;
        }
    }
}
