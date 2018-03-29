package com.raysmond.blog.services;

import com.domingosuarez.boot.autoconfigure.jade4j.JadeHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Raysmond
 */
@JadeHelper("App")
@Service
public class AppSetting {

    public static final String SITE_NAME = "site_name";
    public static final String SITE_SLOGAN = "site_slogan";
    public static final String PAGE_SIZE = "page_size";
    public static final String SITE_INTRO = "site_intro";
    public static final String PICTURE_URL = "picture_url";

    @Autowired
    private SettingService settingService;

    private String siteName = "SpringBlog";
    private String siteSlogan = "An interesting place to discover";
    private Integer pageSize = 5;
    private String intro = "Introduce";
    private String pictureUrl = "/images/user.jpg";

    public String getSiteName() {
        return (String) settingService.get(SITE_NAME, siteName);
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
        settingService.put(SITE_NAME, siteName);
    }

    public Integer getPageSize() {
        return (Integer) settingService.get(PAGE_SIZE, pageSize);
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
        settingService.put(PAGE_SIZE, pageSize);
    }

    public String getSiteSlogan() {
        return (String) settingService.get(SITE_SLOGAN, siteSlogan);
    }

    public void setSiteSlogan(String siteSlogan) {
        this.siteSlogan = siteSlogan;
        settingService.put(SITE_SLOGAN, siteSlogan);
    }

    public String getIntro() {
        return (String) settingService.get(SITE_INTRO, intro);
    }

    public void setIntro(String siteIntro) {
        this.intro = siteIntro;
        settingService.put(SITE_INTRO, siteIntro);
    }

    public String getPictureUrl() {
        return (String) settingService.get(PICTURE_URL, pictureUrl);
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
        settingService.put(PICTURE_URL, pictureUrl);
    }
}
