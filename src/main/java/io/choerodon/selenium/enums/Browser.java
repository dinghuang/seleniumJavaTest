package io.choerodon.selenium.enums;

/**
 * @author dinghuang123@gmail.com
 * @since 2019/1/2
 */
public enum Browser {

    FIRE_FOX("FireFox"),
    CHROME("Chrome"),
    EDGE("Edge"),
    IE("IE"),
    SAFARI("Safari");

    Browser(String name) {
        this.name = name;
    }

    public String value() {
        return name;
    }

    private String name;
}
