package site.metacoding.bb.web.dto.request.players;

import lombok.Getter;
import lombok.Setter;
import site.metacoding.bb.domain.players.Players;

@Setter
@Getter
public class SaveDto {
    private String playerName;
    private Integer teamsId;
    private Integer positionsId;
    
    public Players toEntity() {
    	Players playersPS = new Players(this.playerName, this.teamsId, this.positionsId);
    	return playersPS;
    }
}
