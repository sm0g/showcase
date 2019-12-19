package com.engrs.showcase.domain.valueAssistance;

import com.engrs.showcase.domain.valueAssistance.enumeration.BusinessModel;
import com.engrs.showcase.utilities.labeledvalue.LabeledValue;
import com.engrs.showcase.utilities.labeledvalue.NamedLabeledValueLists;
import com.engrs.showcase.utilities.labeledvalue.NamedLabeledValueListsBuilder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Provides access to all VA lists (i.e. lists of LabeledValue} instances in the system.
 * List may be stored in memory or in the database which is transparent for clients of this class.
 */
@Service
public final class ValueAssistanceProvider implements NamedLabeledValueLists
{
  private final NamedLabeledValueLists listsByName;

  public ValueAssistanceProvider()
  {
    NamedLabeledValueListsBuilder builder = new NamedLabeledValueListsBuilder();
    builder.addEnum(BusinessModel.class);

    this.listsByName = builder.build();
  }

  @Override
  public List<LabeledValue> getLabeledValuesByName(String name)
  {
    return listsByName.getLabeledValuesByName(name);
  }
}
