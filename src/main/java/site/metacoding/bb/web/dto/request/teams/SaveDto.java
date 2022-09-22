package site.metacoding.bb.web.dto.request.teams;

import lombok.Getter;
import lombok.Setter;
import site.metacoding.bb.domain.teams.Teams;

@Setter
@Getter
public class SaveDto {
	private String stadiumname;
	private String teamname;
	
	public Teams toEntity() {
		Teams teams = new Teams(this.stadiumname, this.teamname);
		return teams;
	}
}
