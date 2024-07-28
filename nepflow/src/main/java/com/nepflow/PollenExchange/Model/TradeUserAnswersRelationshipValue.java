package com.nepflow.PollenExchange.Model;

import com.nepflow.UserManagement.Model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

@RelationshipProperties
@NoArgsConstructor
public class TradeUserAnswersRelationshipValue {

    @Id
    @GeneratedValue
    private String uuid;

    @TargetNode
    @Getter
    User user;

    UserAnswers status;

    public TradeUserAnswersRelationshipValue(User user) {
        this.user = user;
        this.status = UserAnswers.WAITING;
    }

    public String getCurrentTradeStatus(){
        return this.status.toString();
    }

    public void refuseTrade() {
        if (this.status == UserAnswers.WAITING) {
            this.status = UserAnswers.REFUSED;
        }
    }

    public void acceptTrade() {
        if (this.status == UserAnswers.WAITING) {
            this.status = UserAnswers.ACCEPTED;
        }
    }

    public boolean wasTradeRefused(){
        return this.status.equals(UserAnswers.REFUSED);
    }

    public boolean wasTradeAccepted(){
        return this.status.equals(UserAnswers.ACCEPTED);
    }

    public boolean isTradeOpen(){
        return this.status.equals(UserAnswers.WAITING);
    }

    private enum UserAnswers {
        WAITING,
        ACCEPTED,
        REFUSED,
    }

}
