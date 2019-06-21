package com.tangramsoftware.companymanagement.signup.domain;

public class PhoneCarrier {

    public static final PhoneCarrier SPRINT = new PhoneCarrier("Sprint");
    public static final PhoneCarrier VERIZON = new PhoneCarrier("Verizon");

    private String name;

    @Override
    public String toString() {
        return "PhoneCarrier [name=" + name + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PhoneCarrier other = (PhoneCarrier) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    public String getName() {
        return name;
    }

    private PhoneCarrier(String carrierName) {
        this.name = carrierName;
    }
}
