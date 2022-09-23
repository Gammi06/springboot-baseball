package site.metacoding.bb.web.dto.response.players;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ListDto {
	private Integer id;
	private String playersName;
    private String teamsName;
    private String positionsName;
	private Timestamp createdAt;
}
