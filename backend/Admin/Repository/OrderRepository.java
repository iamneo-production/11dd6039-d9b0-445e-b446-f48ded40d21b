package net.striker.Admin.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import net.striker.Admin.Model.OderModel;

@Repository
public interface OrderRepository extends JpaRepository<OderModel,String> {
    @Query("SELECT o from OrderModel o WHERE o.userId=?1")
    public List<OderModel> findUserId(String userId);
}
