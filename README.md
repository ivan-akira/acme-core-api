# acme-core-api

In this repository, we are going to see practical example for **Dummy**, **Stub**, **Spy**, **Mock**, and **Fake** in unit test for Java.

> [!NOTE]
> If you are using C#, you could head to [the C# repository](https://github.com/ivan-akira/acme-core-net-api).

According to Martin Fowler, there are various kinds of test double that Gerard Meszaros lists:
- **Dummy** objects are passed around but never actually used. Usually they are just used to fill parameter lists.
- **Fake** objects actually have working implementations, but usually take some shortcut which makes them not suitable for production (an InMemoryTestDatabase is a good example).
- **Stubs** provide canned answers to calls made during the test, usually not responding at all to anything outside what's programmed in for the test.
- **Spies** are stubs that also record some information based on how they were called. One form of this might be an email service that records how many messages it was sent.
- **Mocks** are pre-programmed with expectations which form a specification of the calls they are expected to receive. They can throw an exception if they receive a call they don't expect and are checked during verification to ensure they got all the calls they were expecting[^1].

## Dummy

Example of **Dummy** class [🔗](https://github.com/ivan-akira/acme-core-api/blob/main/src/test/java/com/acme/acmecoreapi/part_a_dummy/service/impl/MoveRobotServiceTest.java#L34-L38).
```java
  private static class MovementStrategyDummy implements MovementStrategy { // <- this is dummy
    @Override
    public void move(Long currentPosition, Long nextPosition) {
    }
  }
```

Its usage in unit test [🔗](https://github.com/ivan-akira/acme-core-api/blob/main/src/test/java/com/acme/acmecoreapi/part_a_dummy/service/impl/MoveRobotServiceTest.java#L16-L32).
```java
  @Test
  void move_PositiveStep_ReturnCorrectPosition() {
    // arrange
    Long initialPosition = 10L;
    Long step = 3L;
    Long expectedPosition = 13L;

    MovementStrategy movementStrategy = new MovementStrategyDummy();

    moveRobotService.setInitialPosition(initialPosition);

    // act
    Long result = moveRobotService.move(step, movementStrategy);

    // assert
    assertEquals(expectedPosition, result);
  }
```

See the whole **Dummy** example on [`MoveRobotServiceTest.java`](https://github.com/ivan-akira/acme-core-api/blob/main/src/test/java/com/acme/acmecoreapi/part_a_dummy/service/impl/MoveRobotServiceTest.java).

## Stub

Example of **Stub** classes [🔗](https://github.com/ivan-akira/acme-core-api/blob/main/src/test/java/com/acme/acmecoreapi/part_b_stub/service/impl/CalculatorServiceTest.java#L30-L42).
```java
  private static class OneComplexNumberDTOStub implements ComplexNumberDTO { // <- this is stub
    @Override
    public Long getNumber() {
      return 1L;
    }
  }

  private static class ThreeComplexNumberDTOStub implements ComplexNumberDTO { // <- this is stub
    @Override
    public Long getNumber() {
      return 3L;
    }
  }
```

Its usage in unit test [🔗](https://github.com/ivan-akira/acme-core-api/blob/main/src/test/java/com/acme/acmecoreapi/part_b_stub/service/impl/CalculatorServiceTest.java#L16-L28).
```java
  @Test
  void add_PositiveComplexNumber_ReturnPositiveComplexNumber() {
    // arrange
    ComplexNumberDTO number1 = new OneComplexNumberDTOStub();
    ComplexNumberDTO number2 = new ThreeComplexNumberDTOStub();
    Long expectedResult = 4L;

    // act
    ComplexNumberDTO result = calculatorService.add(number1, number2);

    // assert
    assertEquals(expectedResult, result.getNumber());
  }
```

See the whole **Stub** examples on [`CalculatorServiceTest.java`](https://github.com/ivan-akira/acme-core-api/blob/main/src/test/java/com/acme/acmecoreapi/part_b_stub/service/impl/CalculatorServiceTest.java) and [`CalculatorServiceTest_Alternative.java`](https://github.com/ivan-akira/acme-core-api/blob/main/src/test/java/com/acme/acmecoreapi/part_b_stub/service/impl/CalculatorServiceTest_Alternative.java).

## Spy

Example of **Spy** class [🔗](https://github.com/ivan-akira/acme-core-api/blob/main/src/test/java/com/acme/acmecoreapi/part_c_spy/service/impl/TransportationServiceTest.java#L33-L45).
```java
  @Data
  private static class VehicleServiceSpy implements VehicleService { // <- this is spy
    private Long stepMoveForward;

    @Override
    public void moveForward(Long step) {
      stepMoveForward = step;
    }

    @Override
    public void moveBackward(Long step) {
    }
  }
```

Its usage in unit test [🔗](https://github.com/ivan-akira/acme-core-api/blob/main/src/test/java/com/acme/acmecoreapi/part_c_spy/service/impl/TransportationServiceTest.java#L17-L31).
```java
  @Test
  void moveVehicle_EndGreaterThanStartPosition_VehicleMoveForward() {
    // arrange
    Long startPosition = 10L;
    Long endPosition = 13L;
    Long expectedStep = 3L;

    VehicleServiceSpy vehicleService = new VehicleServiceSpy();

    // act
    transportationService.moveVehicle(startPosition, endPosition, vehicleService);

    // assert
    assertEquals(expectedStep, vehicleService.getStepMoveForward());
  }
```

See the whole **Spy** examples on [`TransportationServiceTest.java`](https://github.com/ivan-akira/acme-core-api/blob/main/src/test/java/com/acme/acmecoreapi/part_c_spy/service/impl/TransportationServiceTest.java) and [`TransportationServiceTest_Alternative.java`](https://github.com/ivan-akira/acme-core-api/blob/main/src/test/java/com/acme/acmecoreapi/part_c_spy/service/impl/TransportationServiceTest_Alternative.java).

## Mock

Example of **Mock** object [🔗](https://github.com/ivan-akira/acme-core-api/blob/main/src/test/java/com/acme/acmecoreapi/part_d_mock/service/impl/RestaurantServiceTest.java#L21-L22).
```java
  @Mock
  private KitchenService kitchenService; // <- this is mock
```

Its usage in unit test [🔗](https://github.com/ivan-akira/acme-core-api/blob/main/src/test/java/com/acme/acmecoreapi/part_d_mock/service/impl/RestaurantServiceTest.java#L24-L37).
```java
  @Test
  void orderTakeoutMeals_OrderOneMeal_ReceiveOneMeal() {
    // arrange
    int quantity = 1;
    int expectedQuantity = 1;

    when(kitchenService.doCookMeal()).thenReturn(MealEntity.builder().build());

    // act
    List<MealEntity> result = restaurantService.orderTakeoutMeals(quantity);

    // assert
    assertEquals(expectedQuantity, result.size());
  }
```

See the whole **Mock** example on [`RestaurantServiceTest.java`](https://github.com/ivan-akira/acme-core-api/blob/main/src/test/java/com/acme/acmecoreapi/part_d_mock/service/impl/RestaurantServiceTest.java).

## Fake

Example of **Fake** class [🔗](https://github.com/ivan-akira/acme-core-api/blob/main/src/test/java/com/acme/acmecoreapi/part_e_fake/service/impl/PostalServiceTest.java#L38-L57).
```java
  private static class NotificationApiClientFake implements NotificationApiClient { // <- this is fake
    private final List<EmailResponse> emails = new ArrayList<>();

    @Override
    public void addEmailToQueue(SendEmailRequest sendEmailRequest) {
      emails.add(EmailResponse
        .builder()
        .emailId(UUID.randomUUID())
        .from(sendEmailRequest.getFrom())
        .to(sendEmailRequest.getTo())
        .subject(sendEmailRequest.getSubject())
        .body(sendEmailRequest.getBody())
        .build());
    }

    @Override
    public List<EmailResponse> getAllEmails() {
      return emails;
    }
  }
```

Its usage in unit test [🔗](https://github.com/ivan-akira/acme-core-api/blob/main/src/test/java/com/acme/acmecoreapi/part_e_fake/service/impl/PostalServiceTest.java#L23-L36).
```java
  @Test
  void isEmailPrepared_PrepareEmailBeforehand_ReturnTrue() {
    // arrange
    NotificationApiClient notificationApiClient = new NotificationApiClientFake();
    ReflectionTestUtils.setField(postalService, "notificationApiClient", notificationApiClient);

    postalService.prepareEmail();

    // act
    boolean result = postalService.isEmailPrepared();

    // assert
    assertTrue(result);
  }
```

See the whole **Fake** example on [`PostalServiceTest.java`](https://github.com/ivan-akira/acme-core-api/blob/main/src/test/java/com/acme/acmecoreapi/part_e_fake/service/impl/PostalServiceTest.java) and [`PostalServiceTest_Alternative.java`](https://github.com/ivan-akira/acme-core-api/blob/main/src/test/java/com/acme/acmecoreapi/part_e_fake/service/impl/PostalServiceTest_Alternative.java).

[^1]: Fowler, Martin. “bliki: Test Double.” martinfowler.com, [martinfowler.com/bliki/TestDouble.html](https://martinfowler.com/bliki/TestDouble.html).
