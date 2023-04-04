# Starter for a java code kata

This repository is there to allow you starting a new code kata fast.

Requirements:

* Java (minimally 1.8)
* Maven


## Tips


### Use parameterized tests


A linkt to the JUnit5 documentation for [Parameterized tests](https://junit.org/junit5/docs/current/user-guide/#writing-tests-parameterized-tests).

```java
@ParameterizedTest
@EnumSource(value = Color.class)
void passing(Color color) {
    assertThat(isValid(color), equalTo(true));
}

@ParameterizedTest
@CsvSource({
        "Red, Purple",
        "Red, Green",
        "Purple, Green"
}
)
void failing(String color1, String color2) {
    assertThat(Color.valueOf(color1), equalTo(Color.valueOf(color2)));
}

@ParameterizedTest
@MethodSource("generateAllColors")
void name(List<Color> color) {
    assertThat(isValid(color), equalTo(true));
}
```





