package com.dating.dto.relationships;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RelationshipsDTO {

    private Integer id;

    private AccountDTO sendAccount;

    private AccountDTO receiverAccount;




}
