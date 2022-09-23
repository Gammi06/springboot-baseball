package site.metacoding.bb.web.dto.request.players;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdateDto {
	private String playerName;
	private Integer teamsId;
	private Integer positionsId;
}
