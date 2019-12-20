package com.engrs.showcase.domain.valueAssistance;

import com.engrs.showcase.utilities.labeledvalue.LabeledValue;

import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;

public interface ValueAssistanceRepository
{

  List<LabeledValue> getValueAssistance(final String type);
  Optional<LabeledValue> getValueAssistanceWithCode(String va, final String code);

  /**
   * Passes all lists with one of the given names to the callback, ignores unknown names.
   */
  default void forEach(Iterable<String> names, BiConsumer<String, List<LabeledValue>> callback)
  {
    for (String name : names)
    {
      List<LabeledValue> list = getValueAssistance(name);
      if (!list.isEmpty()) callback.accept(name, list);
    }
  }
}
