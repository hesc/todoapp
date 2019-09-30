package com.hesc.todoapp.util;

import org.springframework.cloud.app.ApplicationInstanceInfo;

public class ApplicationInfo {
    private String[] profiles;
    private String[] services;
    private ApplicationInstanceInfo applicationInstanceInfo;
    private String info;

    public ApplicationInfo(String[] profiles, String[] services) {
        this.profiles = profiles;
        this.services = services;
    }

    public String[] getProfiles() {
        return profiles;
    }

    public void setProfiles(String[] profiles) {
        this.profiles = profiles;
    }

    public String[] getServices() {
        return services;
    }

    public void setServices(String[] services) {
        this.services = services;
    }

    public ApplicationInstanceInfo getApplicationInstanceInfo() {
        return applicationInstanceInfo;
    }

    public void setApplicationInstanceInfo(ApplicationInstanceInfo applicationInstanceInfo) {
        this.applicationInstanceInfo = applicationInstanceInfo;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
