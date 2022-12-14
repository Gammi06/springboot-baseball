package site.metacoding.bb.web.dto.response.expulsions;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ListExpulsionsDto {
	private Integer id;
	private Integer no;
	private String playersName;
	private String teamsName;
	private String positions;
	private String reasons;
	private Timestamp createdAt;
}
