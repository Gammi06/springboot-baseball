package site.metacoding.bb.web.dto.request.teams;

import lombok.Getter;
import lombok.Setter;
import site.metacoding.bb.domain.teams.Teams;

@Setter
@Getter
public class SaveDto {
	private String teamName;

	public Teams toEntity() {
		Teams teams = new Teams(this.teamName);
		return teams;
	}
}
