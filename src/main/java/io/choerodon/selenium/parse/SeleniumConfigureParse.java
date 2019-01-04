package io.choerodon.selenium.parse;

import io.choerodon.selenium.entity.SeleniumConfigure;
import org.yaml.snakeyaml.Yaml;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author dinghuang123@gmail.com
 * @since 2019/1/3
 */
public class SeleniumConfigureParse {

    public static SeleniumConfigure seleniumConfigure = null;
    private static final Logger LOGGER = LoggerFactory.getLogger(SeleniumConfigureParse.class);

    private SeleniumConfigureParse() {
    }

    public static SeleniumConfigure getSeleniumConfigure() {
        synchronized (SeleniumConfigureParse.class) {
            if (seleniumConfigure != null) {
                return seleniumConfigure;
            } else {
                Yaml yaml = new Yaml();
                try {
                    seleniumConfigure = yaml.loadAs(new FileInputStream(new File(SeleniumConfigureParse.class.getClassLoader().getResource("configure.yaml").getPath())), SeleniumConfigure.class);
                } catch (FileNotFoundException e) {
                    LOGGER.error("FileNotFoundException{}", e);
                }
                return seleniumConfigure;
            }
        }

    }
}
