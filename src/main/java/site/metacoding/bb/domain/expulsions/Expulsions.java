package site.metacoding.bb.domain.expulsions;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import site.metacoding.bb.domain.players.Players;
import site.metacoding.bb.web.dto.request.expulsions.UpdateDto;

@NoArgsConstructor
@Setter
@Getter
public class Expulsions {
	private Integer id;
	private String playersName;
	private Integer teamsId;
	private Integer positionsId;
	private Integer reasonsId;
	private Timestamp createdAt;

	public Expulsions(String playersName, Integer teamsId, Integer positionsId, Integer reasonsId) {
		this.playersName = playersName;
		this.teamsId = teamsId;
		this.positionsId = positionsId;
		this.reasonsId = reasonsId;
	}
	
	public Expulsions(Players players) {
		this.playersName = players.getPlayersName();
		this.teamsId = players.getTeamsId();
		this.positionsId = players.getPositionsId();
		this.reasonsId = null;
	}
	
	public void update(UpdateDto updateDto) {
		this.reasonsId = updateDto.getReasonsId();
	}
}
