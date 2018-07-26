# Triangle Shell

An interactive Shell built which makes operations using triangles. 

This solution have made base on Spring Shell and Kotlin. Spring Shell has been choosen to simplify shell interactive process and Kotlin has been choosen because of the simple syntax without a lot of boiler plates.

The system is built using a really simple and straightforward object oriented design. A Shell Component receives the data in the Shell Method called triangle type, It make an Triangle Object Instance and the Shell Method prints the triangle type. The triangles types is calculated during the instantiation of the object. If the three points don't satisfy the Triangle Inequality Theorem, the triangle will considered invalid.

It have been chosen use BigDecimal as the triangles sides lengths side to avoid problems with imprecision and round.

## Build Process

There are two options to build the project

### Using Java 8 and Spring Boot Maven Wrapper

If you have Java 8 configured in your machine, you just need to run:

```
mvnw clean install
```

And than run the programa using `java -jar target/triangle-{version}.jar`

### Using Docker

If you have Docker and You don't want to install Java 8, you just can run:

```
docker build -t triangle .
```

And than run the program over the container using `docker run -it triangle`

## Shell Commands

*  triangle-type: This command receives 3 sides lengths and tells the kind of triangle is It.
    * Example: `> triangle-type 1.5 1.6 1.7`

## List of build properties

* settings.bigdecimal.scale: The scale of the bigdecimals values. Default: 120
* settings.bigdecimal.rounding.mode: The rouding method. Default: HALF_UP