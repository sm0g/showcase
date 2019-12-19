package com.engrs.showcase.api.valueAssistance;

import com.engrs.showcase.utilities.labeledvalue.LabeledValue;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * Helper class to create {@link ObjectNode} instances for value assistance DTOs.
 */
final class ValueAssistanceNodeBuilder
{
  private final ObjectMapper objectMapper;

  private final ObjectNode valueAssistanceObject;

  public ValueAssistanceNodeBuilder()
  {
    this.objectMapper = new ObjectMapper();
    this.valueAssistanceObject = objectMapper.createObjectNode();
  }

  /**
   * Adds a value list with the given type and values.
   */
  public ValueAssistanceNodeBuilder add(String type, LabeledValue... values)
  {
    valueAssistanceObject.set(type, createArray(values));
    return this;
  }

  private ArrayNode createArray(LabeledValue... values)
  {
    ArrayNode valuesArray = objectMapper.createArrayNode();
    for (LabeledValue value : values)
    {
      valuesArray.add(objectMapper.createObjectNode()
        .put("value", value.getValue())
        .put("label", value.getLabel()));
    }
    return valuesArray;
  }

  /**
   * Adds a value list with the given type and all constants of the given enum class.
   */
  public <E extends Enum<E> & LabeledValue> ValueAssistanceNodeBuilder addEnum(String type, Class<E> enumClass)
  {
    return add(type, enumClass.getEnumConstants());
  }

  /**
   * Adds a value list with all constants of the given enum class using the simpe class name as type.
   */
  public <E extends Enum<E> & LabeledValue> ValueAssistanceNodeBuilder addEnum(Class<E> enumClass)
  {
    return addEnum(enumClass.getSimpleName(), enumClass);
  }

  public ObjectNode build()
  {
    return valueAssistanceObject;
  }

}
