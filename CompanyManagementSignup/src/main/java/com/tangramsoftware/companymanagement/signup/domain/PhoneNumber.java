package com.tangramsoftware.companymanagement.signup.domain;

public class PhoneNumber {
    private String countryCode;
    private String areaCode;
    private String prefix;
    private String lineNumber;
    private String extension;
    private String type;
    private Boolean isTextable;
    private PhoneCarrier carrier;

    @Override
    public String toString() {
        return "PhoneNumber [countryCode=" + countryCode + ", areaCode=" + areaCode + ", prefix=" + prefix
                + ", lineNumber=" + lineNumber + ", extension=" + extension + ", type=" + type + ", isTextable="
                + isTextable + ", carrier=" + carrier + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((areaCode == null) ? 0 : areaCode.hashCode());
        result = prime * result + ((carrier == null) ? 0 : carrier.hashCode());
        result = prime * result + ((countryCode == null) ? 0 : countryCode.hashCode());
        result = prime * result + ((extension == null) ? 0 : extension.hashCode());
        result = prime * result + ((isTextable == null) ? 0 : isTextable.hashCode());
        result = prime * result + ((lineNumber == null) ? 0 : lineNumber.hashCode());
        result = prime * result + ((prefix == null) ? 0 : prefix.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
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
        PhoneNumber other = (PhoneNumber) obj;
        if (areaCode == null) {
            if (other.areaCode != null)
                return false;
        } else if (!areaCode.equals(other.areaCode))
            return false;
        if (carrier == null) {
            if (other.carrier != null)
                return false;
        } else if (!carrier.equals(other.carrier))
            return false;
        if (countryCode == null) {
            if (other.countryCode != null)
                return false;
        } else if (!countryCode.equals(other.countryCode))
            return false;
        if (extension == null) {
            if (other.extension != null)
                return false;
        } else if (!extension.equals(other.extension))
            return false;
        if (isTextable == null) {
            if (other.isTextable != null)
                return false;
        } else if (!isTextable.equals(other.isTextable))
            return false;
        if (lineNumber == null) {
            if (other.lineNumber != null)
                return false;
        } else if (!lineNumber.equals(other.lineNumber))
            return false;
        if (prefix == null) {
            if (other.prefix != null)
                return false;
        } else if (!prefix.equals(other.prefix))
            return false;
        if (type == null) {
            if (other.type != null)
                return false;
        } else if (!type.equals(other.type))
            return false;
        return true;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public PhoneNumber setCountryCode(String countryCode) {
        this.countryCode = countryCode;

        return this;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public PhoneNumber setAreaCode(String areaCode) {
        this.areaCode = areaCode;

        return this;
    }

    public String getPrefix() {
        return prefix;
    }

    public PhoneNumber setPrefix(String prefix) {
        this.prefix = prefix;

        return this;
    }

    public String getLineNumber() {
        return lineNumber;
    }

    public PhoneNumber setLineNumber(String lineNumber) {
        this.lineNumber = lineNumber;

        return this;
    }

    public String getExtension() {
        return extension;
    }

    public PhoneNumber setExtension(String extension) {
        this.extension = extension;

        return this;
    }

    public String getType() {
        return type;
    }

    public PhoneNumber setType(String type) {
        this.type = type;

        return this;
    }

    public Boolean getIsTextable() {
        return isTextable;
    }

    public PhoneNumber setIsTextable(Boolean isTextable) {
        this.isTextable = isTextable;

        return this;
    }

    public PhoneCarrier getCarrier() {
        return carrier;
    }

    public PhoneNumber setCarrier(PhoneCarrier carrier) {
        this.carrier = carrier;

        return this;
    }

    public PhoneNumber() {

    };

    public PhoneNumber(String phoneNumber, String type) {
        String deFormattedPhoneNumber = phoneNumber.replaceAll("[^+0-9]", "");
        switch (deFormattedPhoneNumber.length()) {
            case 10: {
                countryCode = "1";
                areaCode = deFormattedPhoneNumber.substring(0, 2);
                prefix = deFormattedPhoneNumber.substring(3, 5);
                lineNumber = deFormattedPhoneNumber.substring(6, 9);
                break;
            }
            default: {
                countryCode = "1";
                areaCode = deFormattedPhoneNumber.substring(0, 2);
                prefix = deFormattedPhoneNumber.substring(3, 5);
                lineNumber = deFormattedPhoneNumber.substring(6, 9);
                extension = deFormattedPhoneNumber.substring(10, deFormattedPhoneNumber.length() - 1);
            }
        }
    }

    public String getFormattedPhoneNumber() {
        StringBuffer fn = new StringBuffer();

        if (null != countryCode && countryCode.length() > 0) {
            fn.append("(" + countryCode + ") ");
        }

        if (null != areaCode && areaCode.length() > 0) {
            fn.append("(" + areaCode + ") ");
        }

        fn.append(prefix + "-" + lineNumber);

        if (null != extension && extension.length() > 0) {
            fn.append(".xtn " + extension);
        }

        return fn.toString();
    }
}
