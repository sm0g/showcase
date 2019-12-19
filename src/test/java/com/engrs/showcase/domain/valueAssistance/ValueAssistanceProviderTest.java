package com.engrs.showcase.domain.valueAssistance;

import com.engrs.showcase.domain.valueAssistance.enumeration.BusinessModel;
import com.engrs.showcase.utilities.labeledvalue.LabeledValue;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class ValueAssistanceProviderTest
{
  private final ValueAssistanceProvider provider = new ValueAssistanceProvider();

  @Test
  public void getLabeledValuesByNameTest()
  {
    assertValues("BusinessModel", BusinessModel.class);
  }

  private <E extends Enum<E> & LabeledValue> void assertValues(String name, Class<E> enumeration)
  {
    assertValues(name, enumeration.getEnumConstants());
  }

  private void assertValues(String name, LabeledValue[] values)
  {
    assertThat(provider.getLabeledValuesByName(name)).isEqualTo(Arrays.asList(values));
  }
}
