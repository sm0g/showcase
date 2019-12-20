package com.engrs.showcase.utilities.labeledvalue;

import lombok.AllArgsConstructor;
import lombok.NonNull;

import java.util.*;

/**
 * Builder for {@link NamedLabeledValueLists} instances.
 * All methods that return a {@link NamedLabeledValueListsBuilder} return
 * the object on which they were invoked to support method chaining.
 */
public class NamedLabeledValueListsBuilder
{
  private Map<String, List<LabeledValue>> collectedLists = new HashMap<>();

  /**
   * Adds the given values, appends them to an existing list if there is one with the given name.
   * Does nothing if the given list is null or empty.
   */
  public NamedLabeledValueListsBuilder add(@NonNull String name, List<LabeledValue> values)
  {
    if (values != null && !values.isEmpty())
    {
      collectedLists.computeIfAbsent(name, s -> new ArrayList<>(values.size())).addAll(values);
    }
    return this;
  }

  /**
   * Adds the given values, appends them to an existing list if there is one with the given name.
   * Does nothing if no value is given.
   */
  public NamedLabeledValueListsBuilder add(@NonNull String name, @NonNull LabeledValue... values)
  {
    return add(name, Arrays.asList(values));
  }

  /**
   * Adds all instances of the given enum class, appends them to an existing list if there is one with the given name.
   */
  public <E extends Enum<E> & LabeledValue> NamedLabeledValueListsBuilder addEnum(
    @NonNull String name,
    @NonNull Class<E> enumClass)
  {
    return add(name, enumClass.getEnumConstants());
  }

  /**
   * Calls {@link #addEnum(String, Class)} using the {@linkplain Class#getSimpleName() simple name}
   * of the enum class as name.
   */
  public <E extends Enum<E> & LabeledValue> void addEnum(@NonNull Class<E> enumClass)
  {
    add(enumClass.getSimpleName(), enumClass.getEnumConstants());
  }

  /**
   * Creates the {@link NamedLabeledValueLists} instances and clears the data of this builder.
   */
  @NonNull
  public NamedLabeledValueLists build()
  {
    try
    {
      return new NamedLabeledValueListsImpl(collectedLists);
    } finally
    {
      collectedLists = new HashMap<>();
    }
  }

  @AllArgsConstructor
  private static final class NamedLabeledValueListsImpl implements NamedLabeledValueLists
  {
    private final Map<String, List<LabeledValue>> listsByName;

    @Override
    public List<LabeledValue> getLabeledValuesByName(String name)
    {
      return listsByName.getOrDefault(name, Collections.emptyList());
    }
  }
}
