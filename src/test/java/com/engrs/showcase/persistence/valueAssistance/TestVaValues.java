package com.engrs.showcase.persistence.valueAssistance;

import java.util.List;

public final class TestVaValues
{
  public static final ValueAssistanceEntity ENTITY_IMPRINT_1 = new ValueAssistanceEntity();
  public static final ValueAssistanceEntity ENTITY_IMPRINT_2 = new ValueAssistanceEntity();

  public static List<ValueAssistanceEntity> getAll()
  {
    setEntityValueTest();
    return List.of(ENTITY_IMPRINT_1, ENTITY_IMPRINT_2);
  }

  private static void setEntityValueTest()
  {
    String imprint = "Imprint";

    ENTITY_IMPRINT_1.setVa(imprint);
    ENTITY_IMPRINT_1.setCode("ZIMP");
    ENTITY_IMPRINT_1.setTerm("Zimpel Media-Daten");
    ENTITY_IMPRINT_1.setSortKey(0);
    ENTITY_IMPRINT_1.setObsolete(false);

    ENTITY_IMPRINT_2.setVa(imprint);
    ENTITY_IMPRINT_2.setCode("ZHUP");
    ENTITY_IMPRINT_2.setTerm("Zhejiang University Press");
    ENTITY_IMPRINT_2.setSortKey(0);
    ENTITY_IMPRINT_2.setObsolete(false);
  }
}
