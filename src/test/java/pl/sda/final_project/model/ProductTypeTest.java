package pl.sda.final_project.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;


class ProductTypeTest {

    @ParameterizedTest
    @EnumSource(ProductType.class)
    void nameProductTypeShouldBeLessThan(ProductType productType){
        assertThat(productType.toString().length(), lessThan(15));
    }

    @ParameterizedTest
    @EnumSource(ProductType.class)
    void nameProductTypeShouldBeGreaterThan(ProductType productType){
        assertThat(productType.toString().length(), greaterThan(2));
    }

}
