package io.choerodon.selenium.enums;

/**
 * @author dinghuang123@gmail.com
 * @since 2019/1/2
 */
public enum EPlatform {

    Linux("Linux"),
    Mac_OS("Mac OS"),
    Mac_OS_X("Mac OS X"),
    Windows("Windows"),
    OS2("OS/2"),
    Solaris("Solaris"),
    SunOS("SunOS"),
    MPEiX("MPE/iX"),
    HP_UX("HP-UX"),
    AIX("AIX"),
    OS390("OS/390"),
    FreeBSD("FreeBSD"),
    Irix("Irix"),
    Digital_Unix("Digital Unix"),
    NetWare_411("NetWare"),
    OSF1("OSF1"),
    OpenVMS("OpenVMS"),
    Others("Others");

    EPlatform(String name) {
        this.name = name;
    }

    public String value() {
        return name;
    }

    private String name;
}
