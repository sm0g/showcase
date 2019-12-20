package com.engrs.showcase.persistence.valueAssistance;

import com.engrs.showcase.domain.valueAssistance.ValueAssistanceRepository;
import com.engrs.showcase.utilities.labeledvalue.LabeledValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ValueAssistanceRepositoryAdapter implements ValueAssistanceRepository
{
  private final ValueAssistanceEntityRepository repository;

  @Autowired
  public ValueAssistanceRepositoryAdapter(ValueAssistanceEntityRepository repository)
  {
    this.repository = repository;
  }

  @Override
  public List<LabeledValue> getValueAssistance(String type)
  {
    return repository.findAllByVaAndObsoleteOrderBySortKeyAsc(type, false);
  }

  @Override
  public Optional<LabeledValue> getValueAssistanceWithCode(String va, final String code)
  {
    return repository.findByVaAndCode(va, code);
  }
}
