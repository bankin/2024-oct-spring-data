package softuni.exam.repository;

import org.springframework.data.jpa.repository.Query;
import softuni.exam.models.entity.Sale;

//TODO
public interface SaleRepository {

    @Query("SELECT s FROM Sale AS s" +
            " JOIN s.seller AS slr" +
            " WHERE slr.firstName = :sellerName")
    Sale findSomething(String sellerName);
}
