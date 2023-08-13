package com.github.andylke.demo.purchaseorder;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder, Long> {

  public PurchaseOrder getByUserCodeAndProductCode(String userCode, String productCode);

  @Query(
      """
          select
            new com.github.andylke.demo.spring.purchaseorder.PurchaseOrderSummary(
            po.userCode,
            count(po.userCode))
          from
            PurchaseOrder po
          where
            po.userCode = :userCode
          group by
            po.userCode
          """)
  public PurchaseOrderSummary getSummaryByUserCode(String userCode);

  @Query(
      """
          select
            p.productCode as productCode,
            p.userCode as purchaseBy,
            p.amount as purchaseAmount,
            p.count as purchaseCount,
            s.count as remainingCount
          from PurchaseOrder p join Stock s
          on p.productCode = s.productCode
          where p.userCode = :userCode
            and p.productCode = :productCode
          """)
  public PurchaseOrderAndRemainingStock getPurchaseOrderAndRemainingStock(
      @Param("userCode") String userCode, @Param("productCode") String productCode);
}
