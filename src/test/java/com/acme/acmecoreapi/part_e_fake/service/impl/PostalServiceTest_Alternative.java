package com.acme.acmecoreapi.part_e_fake.service.impl;

import com.acme.acmecoreapi.part_e_fake.api.client.NotificationApiClient;
import com.acme.acmecoreapi.part_e_fake.api.request.SendEmailRequest;
import com.acme.acmecoreapi.part_e_fake.api.response.EmailResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
class PostalServiceTest_Alternative {
  @InjectMocks
  private PostalServiceImpl postalService;

  @Spy
  private NotificationApiClient notificationApiClient = new NotificationApiClientFake();

  @Test
  void isEmailPrepared_PrepareEmailBeforehand_ReturnTrue() {
    // arrange
    postalService.prepareEmail();

    // act
    boolean result = postalService.isEmailPrepared();

    // assert
    assertTrue(result);
  }

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
}
