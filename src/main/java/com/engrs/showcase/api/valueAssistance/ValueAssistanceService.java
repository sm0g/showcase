package com.engrs.showcase.api.valueAssistance;

import com.engrs.showcase.domain.valueAssistance.ValueAssistanceProvider;
import com.engrs.showcase.domain.valueAssistance.ValueAssistanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public class ValueAssistanceService
{
  private final ValueAssistanceProvider vaProvider;
  private final ValueAssistanceRepository valueAssistanceRepository;

  @Autowired
  public ValueAssistanceService(
    ValueAssistanceProvider vaProvider,
    ValueAssistanceRepository valueAssistanceRepository)
  {
    this.vaProvider = vaProvider;
    this.valueAssistanceRepository = valueAssistanceRepository;
  }

  public ValueAssistanceDTO getValueAssistance(List<String> vaTypes)
  {
    ValueAssistanceDTOBuilder builder = new ValueAssistanceDTOBuilder();
    vaProvider.forEach(new HashSet<>(vaTypes), builder::add);
    valueAssistanceRepository.forEach(new HashSet<>(vaTypes), builder::add);
    return builder.build();
  }
}
