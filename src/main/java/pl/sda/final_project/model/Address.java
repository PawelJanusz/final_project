package pl.sda.final_project.model;

import pl.sda.final_project.dto.RegistrationDto;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public class Address {

    private String city;
    private String zipCode;
    /**
     * <code>@Enumerated<code/> is to save enums to database
     */
    @Enumerated(value = EnumType.STRING)
    private Countries country;
    private String street;

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
}
