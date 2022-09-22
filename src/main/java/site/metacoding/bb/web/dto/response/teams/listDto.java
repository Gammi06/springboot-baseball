package site.metacoding.bb.web.dto.response.teams;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ListDto {
	private Integer id;
	private String stadiumname;
	private String teamname;
	private Timestamp createdAt;
}
