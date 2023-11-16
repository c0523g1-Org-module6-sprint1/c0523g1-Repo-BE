package com.dating.repository.relationship;

import com.dating.model.relationship.RelationshipStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IRelationshipStatusRepository extends JpaRepository<RelationshipStatus,Integer> {
    @Query(value = "select * from relationship_status where id = :id",nativeQuery = true)
    RelationshipStatus findRelationshipStatusById(@Param("id") int id);

}
