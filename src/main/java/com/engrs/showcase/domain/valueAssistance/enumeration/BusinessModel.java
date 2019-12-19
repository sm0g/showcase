package com.engrs.showcase.domain.valueAssistance.enumeration;

import com.engrs.showcase.utilities.labeledvalue.LabeledValue;
import com.engrs.showcase.utilities.labeledvalue.LabeledValueByValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Optional;

@AllArgsConstructor
public enum BusinessModel implements LabeledValue
{
  OPEN_ACCESS("Open Access"),
  SUBSCRIPTION("Subscription"),
  HYBRID("Hybrid"),
  OTHER("Other");

  @Getter
  private final String label;

  private static final LabeledValueByValue<BusinessModel> INSTANCES
    = LabeledValueByValue.forEnum(BusinessModel.class);

  /**
   * Gets the status for the given label, an empty result if the label is null or an empty string.
   *
   * @throws IllegalArgumentException if the string is not empty and no valid status label.
   */
  public static Optional<BusinessModel> getOptionalByLabel(String label)
  {
    return Optional.ofNullable(INSTANCES.fromValue(label));
  }

  /**
   * Gets the status for the given label.
   *
   * @throws IllegalArgumentException if the string is null, empty or no valid status label.
   */
  public static BusinessModel getByLabel(String label)
  {
    return getOptionalByLabel(label).orElse(null);
  }

  @Override
  public String toString()
  {
    return label;
  }

  @Override
  @JsonValue
  public String getValue()
  {
    return label;
  }
}
