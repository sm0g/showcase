package com.engrs.showcase.api.valueAssistance;

import com.engrs.showcase.utilities.labeledvalue.LabeledValue;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class ValueAssistanceDTOBuilder
{
  private final Map<String, List<LabeledValueDTO>> data = new HashMap<>();

  public void add(String type, Collection<LabeledValue> values)
  {
    data.put(type, values.stream().map(LabeledValueDTO::new).collect(Collectors.toList()));
  }

  public ValueAssistanceDTO build()
  {
    return new ValueAssistanceDTO(data);
  }
}
