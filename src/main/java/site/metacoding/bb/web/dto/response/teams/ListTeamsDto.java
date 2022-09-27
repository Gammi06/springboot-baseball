package site.metacoding.bb.web.dto.response.teams;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ListTeamsDto {
	private Integer id;
	private Integer no;
	private String teamsName;
	private String stadiumsName;
	private Timestamp createdAt;
}
