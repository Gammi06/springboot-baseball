package site.metacoding.bb.web.dto.request.players;

import lombok.Getter;
import lombok.Setter;
import site.metacoding.bb.domain.players.Players;

@Setter
@Getter
public class SaveDto {
	private String teamname;
	private String position;
	private String playername;
	
	public Players toEntity() {
		Players players = new Players(this.teamname, this.position, this.playername);
		return players;
	}
}
