package com.hesc.todoapp.web;

import com.hesc.todoapp.util.ApplicationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.Cloud;
import org.springframework.cloud.app.ApplicationInstanceInfo;
import org.springframework.cloud.service.ServiceInfo;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class InfoController {
    @Autowired(required = false)
    private Cloud cloud;

    private Environment springEnvironment;

//    @Qualifier("dataSource")
//    @Autowired
//    private DataSource dataSource;

    @Autowired
    public InfoController(Environment springEnvironment) {
        this.springEnvironment = springEnvironment;
    }

    @RequestMapping(value = "/appinfo")
    public ApplicationInfo info() {

        ApplicationInstanceInfo applicationInstanceInfo = null;
        if (cloud != null) {
            applicationInstanceInfo = cloud.getApplicationInstanceInfo();
        }
        String info = "";
//        if (dataSource != null) {
//            try {
//                info += "dataSource: " + dataSource.getConnection().getMetaData();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }


        ApplicationInfo applicationInfo = new ApplicationInfo(springEnvironment.getActiveProfiles(), getServiceNames());
        applicationInfo.setApplicationInstanceInfo(applicationInstanceInfo);
        applicationInfo.setInfo(info);
        return applicationInfo;
    }

    @RequestMapping(value = "/service")
    public List<ServiceInfo> showServiceInfo() {
        if (cloud != null) {
            return cloud.getServiceInfos();
        } else {
            return new ArrayList<>();
        }
    }

    private String[] getServiceNames() {
        if (cloud != null) {
            final List<ServiceInfo> serviceInfos = cloud.getServiceInfos();

            List<String> names = new ArrayList<>();
            for (ServiceInfo serviceInfo : serviceInfos) {
                names.add(serviceInfo.getId());
            }
            return names.toArray(new String[names.size()]);
        } else {
            return new String[]{};
        }
    }
}