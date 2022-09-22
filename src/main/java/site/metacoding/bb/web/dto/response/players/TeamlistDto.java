package site.metacoding.bb.web.dto.response.players;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TeamlistDto {
	private Integer id;
	private String position;
	private String playername;
	private Timestamp createdAt;
}
