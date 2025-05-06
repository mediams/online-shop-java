package de.telran.onlineshopgarden.repository;

import de.telran.onlineshopgarden.entity.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, Integer> {

    @Modifying
    void deleteByUserUserId(Integer userId);

    @Modifying
    void deleteByProductProductId(Integer productId);
}