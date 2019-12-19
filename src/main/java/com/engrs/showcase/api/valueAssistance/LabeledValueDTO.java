package com.engrs.showcase.api.valueAssistance;

import com.engrs.showcase.utilities.labeledvalue.LabeledValue;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@ToString
@EqualsAndHashCode
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-04-29T12:23:05.681Z")
final class LabeledValueDTO
{

  private final LabeledValue value;

  public LabeledValueDTO(LabeledValue value)
  {
    this.value = value;
  }

  @JsonProperty("value")
  @ApiModelProperty(example = "EN", required = true, value = "")
  @NotNull
  public String getValue()
  {
    return value.getValue();
  }

  @JsonProperty("label")
  @ApiModelProperty(example = "English", required = true, value = "")
  @NotNull
  public String getLabel()
  {
    return value.getLabel();
  }

}

