package com.dating.repository.relationship;
import com.dating.model.relationship.Relationships;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IInvitedFriendRepository extends JpaRepository<Relationships, Integer> {
    /**
     * method findRelationshipsById
     * Create HungHLP
     * Date 13-11-2023
     * param String name
     * return
     */
    @Query(value = "SELECT * FROM sprint_dating.relationships ; SELECT r.id, r.date_request, rs.name AS status_name\tFROM relationships r JOIN relationship_status rs ON r.relationship_status_id = rs.id WHERE (r.receiver_account_id = 1 XOR r.sender_account_id = 2)\tor (r.receiver_account_id = 2 XOR r.sender_account_id =1 );",
            nativeQuery = true)
    Relationships findRelationshipsById(@Param("name") String name);


}
