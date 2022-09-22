package site.metacoding.bb.web.dto.response.expulsions;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TeamlistDto {
	private Integer id;
	private String position;
	private String playername;
	private String reason;
	private Timestamp createdAt;
}
