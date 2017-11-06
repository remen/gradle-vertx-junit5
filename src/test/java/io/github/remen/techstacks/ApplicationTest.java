package io.github.remen.techstacks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ApplicationTest {
    @Test
    @DisplayName("This test will intentionally fail")
    void fail() {
        Assertions.fail("Failing intentionally");
    }
}
