package com.engrs.showcase.persistence.valueAssistance;

import com.engrs.showcase.ShowcaseApplication;
import com.engrs.showcase.utilities.labeledvalue.LabeledValue;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = ShowcaseApplication.class)
@RunWith(SpringRunner.class)
public class ValueAssistanceRepositoryAdapterTest
{
  public static final String IMPRINT_VA_TYPE = "Imprint";

  @Autowired
  private ValueAssistanceRepositoryAdapter adapter;

  @Autowired
  private ValueAssistanceEntityRepository repository;

  @Before
  public final void populateValueAssistant()
  {
    repository.saveAll(TestVaValues.getAll());
  }

  @Test
  @DirtiesContext
  public void getValueAssistanceTest()
  {
    List<LabeledValue> labeledValues = adapter.getValueAssistance(IMPRINT_VA_TYPE);
    assertThat(labeledValues).isEqualTo(TestVaValues.getAll());
  }

  @Test
  @DirtiesContext
  public void getValueAssistanceWithCodeTest()
  {
    String code = "ZIMP";
    Optional<LabeledValue> labeledValue = adapter.getValueAssistanceWithCode(IMPRINT_VA_TYPE, code);
    assertThat(labeledValue.isPresent()).isTrue();
    assertThat(labeledValue.get()).isEqualTo(TestVaValues.ENTITY_IMPRINT_1);
  }
}
