package site.metacoding.bb.web.dto.request.expulsions;

import lombok.Getter;
import lombok.Setter;
import site.metacoding.bb.domain.expulsions.Expulsions;
import site.metacoding.bb.domain.players.Players;

@Setter
@Getter
public class InsertDto {
	private String playersName;
	private Integer teamsId;
	private Integer positionsId;
	private Integer reasonsId;

	public Expulsions toExpulsions(Players players) {
		Expulsions expulsionsPS = new Expulsions(players);
		return expulsionsPS;
	}
}
