package com.engrs.showcase.api.valueAssistance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping(value = "/api/va", produces = MediaType.APPLICATION_JSON_VALUE)
public class ValueAssistanceController implements ValueAssistanceApi
{
  private final ValueAssistanceService service;

  @Autowired
  public ValueAssistanceController(ValueAssistanceService service)
  {
    this.service = service;
  }

  @Override
  public ValueAssistanceDTO getValueAssistance(@NotNull List<String> types)
  {
    return service.getValueAssistance(types);
  }
}
