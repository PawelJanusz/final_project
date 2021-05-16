package pl.sda.final_project.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

class CountriesTest {

    @ParameterizedTest
    @EnumSource(Countries.class)
    void nameCountriesShouldBeGreaterThan(Countries countries){
        assertThat(countries.toString().length(), greaterThan(4));
    }

    @ParameterizedTest
    @EnumSource(Countries.class)
    void nameCountriesShouldBeLessThan(Countries countries){
        assertThat(countries.toString().length(), lessThan(20));
    }

    @ParameterizedTest
    @EnumSource(Countries.class)
    void countriesShouldBeEndWithLetterOrEqualTo(Countries countries){
        String[] countriesList = {"POLAND", "ITALY", "GERMANY", "USA"};
        assertAll(
                () -> countries.toString().endsWith("a"),
                () -> countries.toString().endsWith("y"),
                () -> countries.toString().equals(countriesList)
        );
    }
}
