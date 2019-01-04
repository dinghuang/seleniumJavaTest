package io.choerodon.selenium.entity;



/**
 * @author dinghuang123@gmail.com
 * @since 2019/1/3
 */
public class SeleniumConfigure {

    private String browser;

    private String baseUrl;

    private String localDriverPath;

    private String remoteDriverUrl;

    public String getLocalDriverPath() {
        return localDriverPath;
    }

    public void setLocalDriverPath(String localDriverPath) {
        this.localDriverPath = localDriverPath;
    }

    public String getRemoteDriverUrl() {
        return remoteDriverUrl;
    }

    public void setRemoteDriverUrl(String remoteDriverUrl) {
        this.remoteDriverUrl = remoteDriverUrl;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SeleniumConfigure{");
        sb.append("browser='").append(browser).append('\'');
        sb.append(", baseUrl='").append(baseUrl).append('\'');
        sb.append(", localDriverPath='").append(localDriverPath).append('\'');
        sb.append(", remoteDriverUrl='").append(remoteDriverUrl).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
