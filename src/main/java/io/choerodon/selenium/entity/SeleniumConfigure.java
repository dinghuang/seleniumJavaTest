package io.choerodon.selenium.entity;



/**
 * @author dinghuang123@gmail.com
 * @since 2019/1/3
 */
public class SeleniumConfigure {

    private String browser;

    private String baseUrl;

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
        final StringBuffer sb = new StringBuffer("SeleniumConfigure{");
        sb.append("browser='").append(browser).append('\'');
        sb.append(", baseUrl='").append(baseUrl).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
