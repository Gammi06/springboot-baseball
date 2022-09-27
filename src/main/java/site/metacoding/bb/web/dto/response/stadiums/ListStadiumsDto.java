package site.metacoding.bb.web.dto.response.stadiums;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ListStadiumsDto {
	private Integer id;
	private Integer no;
	private String stadiumsName;
	private Timestamp createdAt;
}
