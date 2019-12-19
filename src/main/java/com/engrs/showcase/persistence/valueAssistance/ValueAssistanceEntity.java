package com.engrs.showcase.persistence.valueAssistance;

import com.engrs.showcase.persistence.ColumnType;
import com.engrs.showcase.utilities.labeledvalue.LabeledValue;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "value_assistance")
public class ValueAssistanceEntity implements LabeledValue
{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private long id;

  @Size(max = 256)
  @Column(name = "va", columnDefinition = ColumnType.TEXT)
  private String va;

  @Size(max = 128)
  @Column(name = "code", columnDefinition = ColumnType.TEXT)
  private String code;

  @Size(max = 256)
  @Column(name = "term", columnDefinition = ColumnType.TEXT)
  private String term;

  @Column(name = "sort_key")
  private int sortKey;

  @Column(name = "obsolete")
  private boolean obsolete;

  @Override
  public String getValue()
  {
    return getCode();
  }

  @Override
  public String getLabel()
  {
    return getTerm();
  }
}
