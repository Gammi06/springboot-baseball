package site.metacoding.bb.web.dto.request.expulsions;

import lombok.Getter;
import lombok.Setter;
import site.metacoding.bb.domain.expulsions.Expulsions;

@Setter
@Getter
public class SaveDto {
	private String playersName;
	private Integer teamsId;
	private Integer positionsId;
	private Integer reasonsId;

	public Expulsions toEntity() {
		Expulsions expulsionsPS = new Expulsions(this.playersName, this.teamsId, this.positionsId, this.reasonsId);
		return expulsionsPS;
	}
}
