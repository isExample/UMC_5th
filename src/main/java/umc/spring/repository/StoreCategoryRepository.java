package umc.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.StoreCategory;

public interface StoreCategoryRepository extends JpaRepository<StoreCategory, Long> {
}