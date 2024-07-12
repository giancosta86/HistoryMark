package info.gianlucacosta.historymark;


public class ArtifactInfo {
    private static final String name = "HistoryMark";
    private static final String version = "2.0.0";
    private static final String title = String.format("%s %s", getName(), getVersion());
    private static final String copyrightYears = "2017-2024";
    private static final String copyrightHolder = "Gianluca Costa";
    private static final String license = "MIT";
    private static final String website = "https://gianlucacosta.info/HistoryMark/";
    private static final boolean release = true;


    public static String getName() {
        return name;
    }


    public static String getVersion() {
        return version;
    }


    public static String getTitle() {
        return title;
    }


    public static String getCopyrightYears() {
        return copyrightYears;
    }


    public static String getCopyrightHolder() {
        return copyrightHolder;
    }


    public static String getLicense() {
        return license;
    }


    public static String getWebsite() {
        return website;
    }


    public static boolean isRelease() {
        return release;
    }


    private ArtifactInfo(){}
}