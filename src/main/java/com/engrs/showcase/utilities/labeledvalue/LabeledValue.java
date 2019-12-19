package com.engrs.showcase.utilities.labeledvalue;

/**
 * Interface for values with human-readable labels.
 */
public interface LabeledValue
{
  String getValue();

  default String getLabel()
  {
    return getValue();
  }
}
