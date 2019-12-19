package com.engrs.showcase.api.valueAssistance;

import lombok.EqualsAndHashCode;
import lombok.Value;
import org.springframework.validation.annotation.Validated;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Value
@EqualsAndHashCode(callSuper = true)
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-05-03T08:13:37.907Z")
public class ValueAssistanceDTO extends HashMap<String, List>
{
  public ValueAssistanceDTO(Map<String, List<LabeledValueDTO>> data)
  {
    super(data);
  }
}

