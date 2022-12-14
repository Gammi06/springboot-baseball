package site.metacoding.bb.web.dto.response.players;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ListPlayersDto {
	private Integer id;
	private Integer no;
	private String playersName;
    private String teamsName;
    private String positions;
	private Timestamp createdAt;
}
