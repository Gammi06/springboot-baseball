package site.metacoding.bb.web.dto.response.stadiums;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class listDto {
	private Integer id;
	private String stadiumname;
	private Timestamp createdAt;
}
