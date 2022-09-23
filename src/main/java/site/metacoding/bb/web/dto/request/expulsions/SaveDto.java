package site.metacoding.bb.web.dto.request.expulsions;

import lombok.Getter;
import lombok.Setter;
import site.metacoding.bb.domain.expulsions.Expulsions;

@Setter
@Getter
public class SaveDto {
	private String playerName;
	private Integer teamsId;
	private Integer positionId;
	private Integer reasonsId;

	public Expulsions toEntity() {
		Expulsions expulsionsPS = new Expulsions(this.playerName, this.teamsId, this.positionId, this.reasonsId);
		return expulsionsPS;
	}
}
