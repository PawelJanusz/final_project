package pl.sda.final_project.model;

import pl.sda.final_project.dto.RegistrationDto;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Objects;

@Embeddable
public class Address {

    @NotNull
    private String city;
    @NotNull
    @Pattern(regexp = "[0-9]{2}-[0-9]{3}")
    private String zipCode;

    /**
     * <code>@Enumerated<code/> is to save values enums to database like String not a ordinary number
     */
    @Enumerated(value = EnumType.STRING)
    private Countries country;

    @NotNull
    private String street;

    public Address(String city, String zipCode, Countries country, String street) {
        this.city = city;
        this.zipCode = zipCode;
        this.country = country;
        this.street = street;
    }

    public Address() {
    }

    static Address apply(RegistrationDto registrationDto){
        Address address = new Address();
        address.city = registrationDto.getCity();
        address.country = Countries.fromSymbol(registrationDto.getCountry());
        address.street = registrationDto.getStreet();
        address.zipCode = registrationDto.getZipCode();
        return address;
    }

    public String getCity() {
        return city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return  Objects.equals(city, address.city) &&
                Objects.equals(zipCode, address.zipCode) &&
                country == address.country &&
                Objects.equals(street, address.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, zipCode, country, street);
    }
}
