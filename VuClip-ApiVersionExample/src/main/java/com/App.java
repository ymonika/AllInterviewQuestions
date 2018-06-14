package com;

import java.util.ArrayList;
import java.util.List;

public class App {

    private String appDesc;
    private List<Api> apiList;

    public App() {
    }

    public App(String appDesc, ArrayList<Api> apiList) {
        this.appDesc = appDesc;
        this.apiList = apiList;
    }

    public String getAppDesc() {
        return appDesc;
    }

    public void setAppDesc(String appDesc) {
        this.appDesc = appDesc;
    }

    public List<Api> getApiList() {
        return apiList;
    }

    public void setApiList(List<Api> apiList) {
        this.apiList = apiList;
    }

    public void addApi(Api api) {
        if(!apiList.contains(api)) {
            this.apiList.add(api);
        }
    }

    @Override
    public String toString() {
        return "App{" +
                "appDesc='" + appDesc + '\'' +
                ", apiList=" + apiList +
                '}';
    }
}
