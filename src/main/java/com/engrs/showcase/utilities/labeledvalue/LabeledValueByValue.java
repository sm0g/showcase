package com.engrs.showcase.utilities.labeledvalue;

import java.util.*;

/**
 * Stores {@link LabeledValue} instances by their values.
 *
 */
public final class LabeledValueByValue<T extends LabeledValue>
{
  private final Class<T> type;

  private final Map<String, T> valueToInstance;

  private LabeledValueByValue(Class<T> type, Map<String, T> valueToInstance)
  {
    this.type = type;
    this.valueToInstance = valueToInstance;
  }

  /**
   * @throws IllegalStateException if two instances have the same value.
   */
  public static <E extends Enum<E> & LabeledValue> LabeledValueByValue<E> forEnum(Class<E> enumType)
  {
    return new LabeledValueByValue<>(enumType, createValueToInstanceMap(enumType));
  }

  /**
   * @throws IllegalStateException if two instances have the same value.
   */
  public static <T extends LabeledValue> LabeledValueByValue<T> forValues(Class<T> type, Collection<T> values)
  {
    return new LabeledValueByValue<>(type, createValueToInstanceMap(type, values));
  }


  /**
   * @return <code>null</code> if the given value is <code>null</code> or empty.
   * @throws IllegalArgumentException if the value is not empty but unknown.
   */
  public T fromValue(final String value)
  {
    return fromValue(value, null);
  }

  /**
   * @return the given default value if the given value is <code>null</code> or empty.
   * @throws IllegalArgumentException if the value is not empty but unknown.
   */
  public T fromValue(final String value, final T defaultValue)
  {
    if (value == null || value.isEmpty()) return defaultValue;

    final T instance = valueToInstance.get(value);
    if (instance == null) throw new IllegalArgumentException("'" + value + "' is no value of " + type.getName());

    return instance;
  }

  /**
   * @throws IllegalStateException if two instances have the same value.
   */
  private static <E extends Enum<E> & LabeledValue> Map<String, E> createValueToInstanceMap(final Class<E> enumType)
  {
    return createValueToInstanceMap(enumType, Arrays.asList(enumType.getEnumConstants()));
  }

  /**
   * @throws IllegalStateException if two instances have the same value.
   */
  private static <T extends LabeledValue> Map<String, T> createValueToInstanceMap(
    final Class<T> type,
    Collection<T> values)
  {
    final Map<String, T> map = new HashMap<>(values.size());
    for (final T value : values)
    {
      if (map.put(value.getValue(), value) != null)
        throw new IllegalStateException("Duplicate value for " + type.getName() + ": '" + value.getValue() + "'.");
    }
    return Collections.unmodifiableMap(map);
  }
}
