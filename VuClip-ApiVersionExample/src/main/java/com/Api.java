package com;

public class Api {

    private String apiDesc;
    private Version version;

    public Api(String apiDesc, Version version) {
        this.apiDesc = apiDesc;
        this.version = version;
    }

    public String getApiDesc() {
        return apiDesc;
    }

    public Version getVersion() {
        return version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Api)) return false;

        Api api = (Api) o;

        if (!getApiDesc().equals(api.getApiDesc())) return false;
        return getVersion().equals(api.getVersion());
    }

    @Override
    public int hashCode() {
        int result = getApiDesc().hashCode();
        result = 31 * result + getVersion().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Api{" +
                "apiDesc='" + apiDesc + '\'' +
                ", version=" + version +
                '}';
    }
}
