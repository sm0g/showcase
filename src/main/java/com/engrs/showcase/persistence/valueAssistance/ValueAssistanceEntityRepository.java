package com.engrs.showcase.persistence.valueAssistance;

import com.engrs.showcase.utilities.labeledvalue.LabeledValue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ValueAssistanceEntityRepository extends JpaRepository<ValueAssistanceEntity, Long>
{
  List<LabeledValue> findAllByVaAndObsoleteOrderBySortKeyAsc(final String va, final boolean obsolete);

  List<LabeledValue> findAllByVaAndObsoleteOrCodeOrderBySortKeyAsc(
          final String va, final boolean obsolete, final String code);

  Optional<LabeledValue> findByVaAndCode(final String va, final String code);
}

