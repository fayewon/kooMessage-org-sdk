package org.github.kooMessage.config;

import org.springframework.stereotype.Component;

/**
 * @BelongsProject: kooMessage
 * @BelongsPackage: org.github.kooMessage.config
 * @Author: 王飞
 * @CreateTime: 2022-11-01  15:19
 * @Description: 修改token信息
 * @Version: 1.0
 */
@Component
public class TokenMessageCopy {
    private   String name;
    private   String password;
    private   String tokenUrl;
    private   String domain;
    private   String project;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTokenUrl() {
        return tokenUrl;
    }

    public void setTokenUrl(String tokenUrl) {
        this.tokenUrl = tokenUrl;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }
}
