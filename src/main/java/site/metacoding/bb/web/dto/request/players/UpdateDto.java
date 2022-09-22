package site.metacoding.bb.web.dto.request.players;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdateDto {
	private String teamname;
	private String position;
	private Timestamp createdAt;
}
