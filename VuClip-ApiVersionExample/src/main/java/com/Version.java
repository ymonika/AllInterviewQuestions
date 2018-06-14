package com;

import java.util.Comparator;

public class Version implements Comparable<Version> {

    private Integer v1 = 0;
    private Integer v2 = 0;
    private Integer v3 = 0;

    public Version(String version) {
        String[] versions = version.toUpperCase().replace("V", "").trim().split("/.");
        this.v1 = Integer.parseInt(versions[0]);
        this.v2 = versions.length > 1 ? Integer.parseInt(versions[1]) : 0;
        this.v3 = versions.length > 2 ? Integer.parseInt(versions[2]) : 0;
    }

    public Integer getV1() {
        return v1;
    }

    public Integer getV2() {
        return v2;
    }

    public Integer getV3() {
        return v3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Version)) return false;

        Version version = (Version) o;

        if (v1 != null ? !v1.equals(version.v1) : version.v1 != null) return false;
        if (v2 != null ? !v2.equals(version.v2) : version.v2 != null) return false;
        return v3 != null ? v3.equals(version.v3) : version.v3 == null;
    }

    @Override
    public int hashCode() {
        int result = v1 != null ? v1.hashCode() : 0;
        result = 31 * result + (v2 != null ? v2.hashCode() : 0);
        result = 31 * result + (v3 != null ? v3.hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo(Version version) {
        return Comparator.comparing(Version::getV1)
                .thenComparing(Version::getV2)
                .thenComparing(Version::getV3)
                .compare(this, version);
    }

    @Override
    public String toString() {
        return "Version{" +
                "v1=" + v1 +
                ", v2=" + v2 +
                ", v3=" + v3 +
                '}';
    }
}
