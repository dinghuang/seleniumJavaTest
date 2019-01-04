package io.choerodon.selenium.util;

import io.choerodon.selenium.enums.EPlatform;

/**
 * @author dinghuang123@gmail.com
 * @since 2019/1/2
 */
public class OSinfoUtil {

    private static String OS = System.getProperty("os.name").toLowerCase();

    private EPlatform platform;

    private OSinfoUtil() {
    }

    public static boolean isLinux() {
        return OS.indexOf("linux") >= 0;
    }

    public static boolean isMacOS() {
        return OS.indexOf("mac") >= 0 && OS.indexOf("os") > 0 && OS.indexOf("x") < 0;
    }

    public static boolean isMacOSX() {
        return OS.indexOf("mac") >= 0 && OS.indexOf("os") > 0 && OS.indexOf("x") > 0;
    }

    public static boolean isWindows() {
        return OS.indexOf("windows") >= 0;
    }

    public static boolean isOS2() {
        return OS.indexOf("os/2") >= 0;
    }

    public static boolean isSolaris() {
        return OS.indexOf("solaris") >= 0;
    }

    public static boolean isSunOS() {
        return OS.indexOf("sunos") >= 0;
    }

    public static boolean isMPEiX() {
        return OS.indexOf("mpe/ix") >= 0;
    }

    public static boolean isHPUX() {
        return OS.indexOf("hp-ux") >= 0;
    }

    public static boolean isAix() {
        return OS.indexOf("aix") >= 0;
    }

    public static boolean isOS390() {
        return OS.indexOf("os/390") >= 0;
    }

    public static boolean isFreeBSD() {
        return OS.indexOf("freebsd") >= 0;
    }

    public static boolean isIrix() {
        return OS.indexOf("irix") >= 0;
    }

    public static boolean isDigitalUnix() {
        return OS.indexOf("digital") >= 0 && OS.indexOf("unix") > 0;
    }

    public static boolean isNetWare() {
        return OS.indexOf("netware") >= 0;
    }

    public static boolean isOSF1() {
        return OS.indexOf("osf1") >= 0;
    }

    public static boolean isOpenVMS() {
        return OS.indexOf("openvms") >= 0;
    }

    /**
     * 获取操作系统名字
     *
     * @return 操作系统名
     */
    public static String getOSname() {
        if (isAix()) {
            return EPlatform.AIX.value();
        } else if (isDigitalUnix()) {
            return EPlatform.Digital_Unix.value();
        } else if (isFreeBSD()) {
            return EPlatform.FreeBSD.value();
        } else if (isHPUX()) {
            return EPlatform.HP_UX.value();
        } else if (isIrix()) {
            return EPlatform.Irix.value();
        } else if (isLinux()) {
            return EPlatform.Linux.value();
        } else if (isMacOS()) {
            return EPlatform.Mac_OS.value();
        } else if (isMacOSX()) {
            return EPlatform.Mac_OS_X.value();
        } else if (isMPEiX()) {
            return EPlatform.MPEiX.value();
        } else if (isNetWare()) {
            return EPlatform.NetWare_411.value();
        } else if (isOpenVMS()) {
            return EPlatform.OpenVMS.value();
        } else if (isOS2()) {
            return EPlatform.OS2.value();
        } else if (isOS390()) {
            return EPlatform.OS390.value();
        } else if (isOSF1()) {
            return EPlatform.OSF1.value();
        } else if (isSolaris()) {
            return EPlatform.Solaris.value();
        } else if (isSunOS()) {
            return EPlatform.SunOS.value();
        } else if (isWindows()) {
            return EPlatform.Windows.value();
        } else {
            return EPlatform.Others.value();
        }
    }


}
