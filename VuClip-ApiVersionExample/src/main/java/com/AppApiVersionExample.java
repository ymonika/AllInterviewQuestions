package com;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AppApiVersionExample {

    public String processData(String[] args) {
        Map<String, App> apps = new ConcurrentHashMap<>(args.length);
        Map<String, Version> latestApisMap = new ConcurrentHashMap<>(args.length);
        for (String s : args) {
            String[] appDetails = s.split(",");
            String appDesc = appDetails[0];
            String apiDesc = appDetails[1];
            Version version = new Version(appDetails[2]);
            Api api = new Api(apiDesc, version);

            if (apps.get(appDesc) != null) {
                App app = apps.get(appDesc);
                app.addApi(api);
                apps.remove(appDesc);
                apps.put(appDesc, app);
            } else {
                ArrayList<Api> apiList = new ArrayList<>();
                apiList.add(api);
                App app = new App(appDesc, apiList);
                app.addApi(api);
                apps.put(appDesc, app);
            }
            if(latestApisMap.containsKey(apiDesc)) {
               if( version.compareTo(latestApisMap.get(apiDesc)) > 0) {
                   latestApisMap.remove(apiDesc);
                   latestApisMap.put(apiDesc, version);
               }
            } else {
                latestApisMap.put(apiDesc, version);
            }

        }
        List<Api> latestApiList = new ArrayList<>();
        for(Map.Entry<String, Version> api : latestApisMap.entrySet()) {
            latestApiList.add(new Api(api.getKey(), api.getValue()));
        }
        String latestApp = "";
        for(Map.Entry<String, App> app : apps.entrySet()) {
            String appName = app.getKey();
            List<Api> removedApis = app.getValue().getApiList();
            removedApis.removeAll(latestApiList);
            if(removedApis.isEmpty()) {
                latestApp = appName;
            }
        }

        return latestApp;
    }

    public static void main(String[] args) {

        String[] str = {"Chat box, Search Api, V11",
                "Idea intelliJ, Db Oracle Api, V15",
                "Idea intelliJ, jdk, v11",
                "Chat box, Db Oracle Api, V5",
                "Chat box, jdk, v8"
                };

        AppApiVersionExample apiVersionExample = new AppApiVersionExample();
        System.out.println(apiVersionExample.processData(str));
    }
}
