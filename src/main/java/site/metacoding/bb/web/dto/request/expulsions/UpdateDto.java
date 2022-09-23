package site.metacoding.bb.web.dto.request.expulsions;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdateDto {
	private String playersName;
	private Integer teamsId;
	private Integer positionsId;
	private Integer reasonsId;
}
