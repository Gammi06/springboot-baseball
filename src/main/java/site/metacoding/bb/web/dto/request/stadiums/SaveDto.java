package site.metacoding.bb.web.dto.request.stadiums;

import lombok.Getter;
import lombok.Setter;
import site.metacoding.bb.domain.stadiums.Stadiums;

@Setter
@Getter
public class SaveDto {
	private String stadiumsName;
    private Integer teamsId;

	public Stadiums toEntity() {
		Stadiums stadiums = new Stadiums(this.stadiumsName, this.teamsId);
		return stadiums;
	}
}
