package com.digitalnomads.api.entities;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
@Slf4j
public abstract class BaseEntity {
    public void isEquals(BaseEntity expectedEntity) {
        Assertions.assertThat(this)
                .usingRecursiveComparison()
                .ignoringActualNullFields()
                .ignoringExpectedNullFields()
                .withFailMessage("Objects not match \nActual "+this+"\nExpected "+expectedEntity)
                .isEqualTo(expectedEntity);
        log.info("Object is match, \nActual {}, \nExpected {}",this,expectedEntity);

    }
}
