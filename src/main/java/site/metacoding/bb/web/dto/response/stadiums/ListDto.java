package site.metacoding.bb.web.dto.response.stadiums;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ListDto {
	private Integer id;
	private String stadiumsName;
    private String teamsName;
	private Timestamp createdAt;
}