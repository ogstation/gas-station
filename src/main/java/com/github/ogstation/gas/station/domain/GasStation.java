package com.github.ogstation.gas.station.domain;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.hateoas.ResourceSupport;

import java.io.Serializable;

public class GasStation extends ResourceSupport implements Serializable
{
    private String gasStationId;

    @NotBlank
    private String name;
    @NotBlank
    private String provinceCode;
    @NotBlank
    private String cityCode;
    @NotBlank
    private String countryCode;
    @NotBlank
    private String addressDetails;
    @NotBlank
    private String contact;
    private String phone;
    private String telephone;
    private String fax;
    private String email;
    private String postcode;
    private String homepage;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getProvinceCode()
    {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode)
    {
        this.provinceCode = provinceCode;
    }

    public String getCityCode()
    {
        return cityCode;
    }

    public void setCityCode(String cityCode)
    {
        this.cityCode = cityCode;
    }

    public String getCountryCode()
    {
        return countryCode;
    }

    public void setCountryCode(String countryCode)
    {
        this.countryCode = countryCode;
    }

    public String getAddressDetails()
    {
        return addressDetails;
    }

    public void setAddressDetails(String addressDetails)
    {
        this.addressDetails = addressDetails;
    }

    public String getContact()
    {
        return contact;
    }

    public void setContact(String contact)
    {
        this.contact = contact;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getFax()
    {
        return fax;
    }

    public void setFax(String fax)
    {
        this.fax = fax;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPostcode()
    {
        return postcode;
    }

    public void setPostcode(String postcode)
    {
        this.postcode = postcode;
    }

    public String getHomepage()
    {
        return homepage;
    }

    public void setHomepage(String homepage)
    {
        this.homepage = homepage;
    }

    public String getGasStationId()
    {
        return gasStationId;
    }

    public void setGasStationId(String gasStationId)
    {
        this.gasStationId = gasStationId;
    }

    public String getTelephone()
    {
        return telephone;
    }

    public void setTelephone(String telephone)
    {
        this.telephone = telephone;
    }
}
