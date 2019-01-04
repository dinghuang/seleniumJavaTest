package io.choerodon.selenium.exception;

/**
 * @author dinghuang123@gmail.com
 * @since 2019/1/3
 */
public class SeleniumException extends RuntimeException{

    private String code;

    private final transient Object[] parameters;

    public SeleniumException(String code, Object... parameters) {
        super(code);
        this.parameters = parameters;
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object[] getParameters() {
        return parameters;
    }
}
