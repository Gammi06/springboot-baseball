package site.metacoding.bb.web.dto.request.expulsions;

import lombok.Getter;
import lombok.Setter;
import site.metacoding.bb.domain.stadiums.Stadiums;

@Setter
@Getter
public class SaveDto {
	private String stadiumname;
	
	public Stadiums toEntity() {
		Stadiums stadiums = new Stadiums(this.stadiumname);
		return stadiums;
	}
}
