package com.dating.trivn_controller.relationship;
import com.dating.model.relationship.Relationships;
import com.dating.service.relationship.IInvitedFriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("api/member/invited")
public class InvitedFriendController {
    @Autowired
    private IInvitedFriendService iInvitedFriendService;

    @GetMapping("")
    public ResponseEntity<List<Relationships>> findAll() {
        List<Relationships> relationshipsList = iInvitedFriendService.findAll();
        if (relationshipsList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(relationshipsList, HttpStatus.OK);
        }
    }
}

