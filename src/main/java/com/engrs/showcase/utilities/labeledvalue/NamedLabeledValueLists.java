package com.engrs.showcase.utilities.labeledvalue;

import java.util.List;
import java.util.function.BiConsumer;

/**
 * Provides lists of {@link LabeledValue} objects by name.
 */
public interface NamedLabeledValueLists
{
  /**
   * Gets the list of labeled values with the given name, an empty list if the name is unknown.
   */
  List<LabeledValue> getLabeledValuesByName(String name);

  /**
   * Passes all lists with one of the given names to the callback, ignores unknown names.
   */
  default void forEach(Iterable<String> names, BiConsumer<String, List<LabeledValue>> callback)
  {
    for (String name : names)
    {
      List<LabeledValue> list = getLabeledValuesByName(name);
      if (!list.isEmpty()) callback.accept(name, list);
    }
  }
}
